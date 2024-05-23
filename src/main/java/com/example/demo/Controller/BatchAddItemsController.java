//package com.example.demo.Controller;
//
//
//import com.example.demo.Service.BatchAddItemsService;
//import com.example.demo.dto.BatchAddItemsRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//
////chat Gpt
//@RestController
////@RequestMapping("/api")
////@RequiredArgsConstructor
//public class BatchAddItemsController {
//
//    @Autowired
//    private final BatchAddItemsService batchItemsService;
//
//    public BatchAddItemsController(BatchAddItemsService batchItemsService) {
//        this.batchItemsService = batchItemsService;
//    }
//
//
//    @PostMapping("/addItem")
//    public ResponseEntity<String> processBatchItems(@RequestParam String actionBy, @RequestBody BatchAddItemsRequest batchItems) {
//        try {
//            // Your logic to process batch items
//            int numErrors = batchItemsService.batchAddItems(actionBy, batchItems);
//            if (numErrors == 0) {
//                return ResponseEntity.ok("Execute successfully " + numErrors);
//            } else {
//                return ResponseEntity.badRequest().body(" Number of errors  : " + numErrors);
//            }
//
//        } catch (Exception e) {
//            // Handle exceptions and return an appropriate response
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing batch: " + e.getMessage());
//        }
//    }
//}
package com.example.demo.Controller;

import com.example.demo.Service.BatchAddItemsService;
import com.example.demo.Service.UsersService;
import com.example.demo.dto.BatchAddItemsRequest;
import com.example.demo.dto.BatchAddItemsRequestTemporary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class BatchAddItemsController {

    @Autowired
    private final BatchAddItemsService batchItemsService;
    @Autowired
    private final UsersService usersService;

    public BatchAddItemsController(BatchAddItemsService batchItemsService, UsersService usersService) {
        this.batchItemsService = batchItemsService;
        this.usersService = usersService;
    }

//
//    @PostMapping("/addItem")
//    public ResponseEntity<String> processBatchItems(@RequestParam String actionBy, @RequestBody BatchAddItemsRequest batchItems) {
//        try {
//            // Your logic to process batch items
//            int numErrors = batchItemsService.batchAddItems(actionBy, batchItems);
//            if (numErrors == 0) {
//                return ResponseEntity.ok("Execute successfully " + numErrors);
//            } else {
//                return ResponseEntity.badRequest().body(" Number of errors  : " + numErrors);
//            }
//
//        } catch (Exception e) {
//            // Handle exceptions and return an appropriate response
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing batch: " + e.getMessage());
//        }
//    }}


    @PostMapping("/addItem")
    public ResponseEntity<Object> processBatchItems(@RequestParam(required = true) String actionBy, @RequestBody BatchAddItemsRequest batchItems) {
        try {
            if (actionBy == null || actionBy.isEmpty() || actionBy.equalsIgnoreCase("null")) {
                return new ResponseEntity<>("actionBy cannot be null or empty.", HttpStatus.BAD_REQUEST);
            }
            // Check if actionBy exists in the user table's userid column
            boolean userExists = usersService.isUserExists(actionBy);
            if (!userExists) {
                return new ResponseEntity<>("{ \"User with ID \"" + actionBy + "\" does not have permission.\"}", HttpStatus.OK);
            }

            System.out.println(batchItems);
            String ErrorDescription = batchItemsService.batchAddItems(actionBy, batchItems);
            if (ErrorDescription.equals("SUCCESS")) {
                return ResponseEntity.ok("Execute successfully " + ErrorDescription);
            } else {
                return new ResponseEntity<>("{\" Error  : \"" + ErrorDescription + "\"}", HttpStatus.OK);
            }

        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("Error processing batch: " + e.getMessage());
        }
    }





    @PostMapping("/addItemTemporary")
    public ResponseEntity<Object> processBatchItemsTemporary(@RequestParam(required = true) String actionBy, @RequestBody BatchAddItemsRequestTemporary batchItems) {
        try {
            if (actionBy == null || actionBy.isEmpty() || actionBy.equalsIgnoreCase("null")) {
                return new ResponseEntity<>("actionBy cannot be null or empty.", HttpStatus.BAD_REQUEST);
            }
            // Check if actionBy exists in the user table's userid column
            boolean userExists = usersService.isUserExists(actionBy);
            if (!userExists) {
                return new ResponseEntity<>("{ \"User with ID \"" + actionBy + "\" does not have permission.\"}", HttpStatus.OK);
            }
            // Validate temporary parameter
            if (batchItems.getTemporary() != null && !(batchItems.getTemporary() instanceof Boolean)) {
                return new ResponseEntity<>("temporary must be true, false, or null.", HttpStatus.BAD_REQUEST);
            }
            System.out.println(batchItems);
            String ErrorDescription = batchItemsService.batchAddItemsTemporary(actionBy, batchItems);
            if (ErrorDescription.equals("SUCCESS")) {
                return ResponseEntity.ok("Execute successfully " + ErrorDescription);
            } else {
                return new ResponseEntity<>(" {\" Error  : \"" + ErrorDescription + "\"} ", HttpStatus.OK);
            }

        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("Error processing batch: " + e.getMessage());
        }


    }}












