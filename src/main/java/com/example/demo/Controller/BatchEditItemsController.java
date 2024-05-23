package com.example.demo.Controller;

import com.example.demo.Service.BatchEditItemsService;
import com.example.demo.Service.ItemStatusService;
import com.example.demo.Service.UsersService;
import com.example.demo.dto.BatchEditItemsRequest;
import com.example.demo.dto.UpadateTemporary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
//@RequestMapping("/edit")
public class BatchEditItemsController {

    private final Logger logger = Logger.getLogger(BatchEditItemsController.class.getName());

    private final BatchEditItemsService batchEditItemsService;
    @Autowired
    private final UsersService usersService;
    private final ItemStatusService itemStatusService;


    public BatchEditItemsController(BatchEditItemsService batchEditItemsService, UsersService usersService, ItemStatusService itemStatusService) {
        this.batchEditItemsService = batchEditItemsService;
        this.usersService = usersService;
        this.itemStatusService = itemStatusService;
    }

    @PostMapping("/editItems")
    public ResponseEntity<Object> batchEditItems(@RequestParam String actionBy, @RequestBody BatchEditItemsRequest batchEditItemsRequests) {
        try {
            if (actionBy == null || actionBy.isEmpty() || actionBy.equalsIgnoreCase("null")) {
                return new ResponseEntity<>("actionBy cannot be null or empty.", HttpStatus.BAD_REQUEST);
            }
            boolean userExists = usersService.isUserExists(actionBy);
            if (!userExists) {
                return new ResponseEntity<>("{\"User with ID \"" + actionBy + "\" does not have permission.\"}", HttpStatus.OK);
            }
            System.out.println(batchEditItemsRequests);
            String ErrorDescription = batchEditItemsService.batchEditItems(actionBy, batchEditItemsRequests);
            if (ErrorDescription.equals("SUCCESS")) {
                return ResponseEntity.ok("Execute successfully " + ErrorDescription);
            } else {
                return new ResponseEntity<>(" { \"Error  : \"" + ErrorDescription + "\"}", HttpStatus.OK);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("Error Processing batch :" + e.getMessage());
        }

    }


    @PostMapping("/editTemporary")
    public ResponseEntity<Object> editTemporary(@RequestParam String actionBy, @RequestBody UpadateTemporary temporary) {
        try {
            logger.info("Temporary id " + temporary.getItemId() + " is temporary " + temporary.getTemporary());
            if (actionBy == null || actionBy.isEmpty() || actionBy.equalsIgnoreCase("null")) {
                return new ResponseEntity<>("actionBy cannot be null or empty.", HttpStatus.BAD_REQUEST);
            }
            boolean itemExsist = itemStatusService.itemExists(temporary.getItemId());
            if (!itemExsist) {
                System.out.println("temporaryId = " + temporary.getItemId());
                logger.info("Temporary id " + temporary.getItemId() + " is temporary " + temporary.getTemporary());
                return new ResponseEntity<>("{\"Item  with ID \"" + temporary.getItemId() + "\" does not Exist.\"}", HttpStatus.BAD_REQUEST);
            }
            boolean userExists = usersService.isUserExists(actionBy);
            if (!userExists) {
                return new ResponseEntity<>("{\"User with ID \"" + actionBy + "\" does not have permission.\"}", HttpStatus.OK);
            }
            // Validate temporary parameter
            if (temporary.getTemporary() != null && !(temporary.getTemporary() instanceof Boolean)) {
                return new ResponseEntity<>("temporary must be true, false, or null.", HttpStatus.BAD_REQUEST);
            } else {
                String updateTemporary = batchEditItemsService.batchEditItemsTemporary(temporary);
                return new ResponseEntity<>("Updated Success", HttpStatus.OK);

            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("Error Processing batch :" + e.getMessage());
        }

    }


}


