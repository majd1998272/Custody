package com.example.demo.Controller;

import com.example.demo.Service.ItemStatusService;
import com.example.demo.Service.UsersService;
import com.example.demo.dto.IssuedFromWarehouseRequest;
import com.example.demo.dto.ReturnToWarehouseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
@CrossOrigin(origins = "*")

@RestController
public class ItemStatusController {

    @Autowired
    private ItemStatusService itemStatusService;
    @Autowired
    private final UsersService usersService;

    public ItemStatusController(UsersService usersService) {
        this.usersService = usersService;
    }


    //ON
    @PostMapping("/UnderCustody")
    //Case 1 Transfer between employee
    //case 2  Issued from Warehouse
    public ResponseEntity<Object> changeItemStatusUnderCustody(@RequestParam(required = false) int itemId,
                                                               @RequestParam(required = false) int statusId,
                                                               @RequestParam(required = false) String statusBy,
                                                               @RequestParam(required = false) Date date,
                                                               @RequestParam(required = false) String refNo, @RequestParam(required = false) String custodyBy, @RequestParam(required = false) String requestType) {
        try {

            itemStatusService.changeItemStatus(itemId, statusId, statusBy, date, refNo, requestType);
            itemStatusService.addCustody(itemId, custodyBy, date, refNo, requestType);
//            itemStatusService.updateItemStatus(itemId,statusId,statusBy,date,refNo,requestType);
//            itemStatusService.updateItem(itemId, statusId, date, refNo, requestType);


            return ResponseEntity.ok("Custody Submitted & Changed Successfully");
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return new ResponseEntity<>("Error " + e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }

    }


    @PostMapping("/inWarehouseplusLost")
    //without refNo parameter
    //Return To Warehouse
    public ResponseEntity<Object> changeItemStatusInWarehouseAndLost(@RequestParam(required = true) int itemId,
                                                                     @RequestParam(required = true) int statusId,
                                                                     @RequestParam(required = true) String statusBy,
                                                                     @RequestParam(required = true) Date date,
                                                                     @RequestParam(required = false) String refNo,
                                                                     @RequestParam(required = true) String requestType) {
        try {
            if (statusBy == null || statusBy.isEmpty()) {
                return new ResponseEntity<>("statusBy cannot be null or empty.", HttpStatus.BAD_REQUEST);
            }
            boolean userExists =  usersService.isUserExists(statusBy);
            if (!userExists) {
                return new ResponseEntity<>("{\"User with StatusBy Id \"" + statusBy + "\" does not have permission.\"}", HttpStatus.OK);
            }

            // Check if the item exists
            if (!itemStatusService.itemExists(itemId)) {
                return new ResponseEntity<>("{\"Item with ID \"" + itemId + "\" does not exist.\"}", HttpStatus.OK);
            }

            if (statusId != 2) {
                return new ResponseEntity<>("Invalid statusId. Please Select only  number  2 ", HttpStatus.OK);
            }
            if (!"Return to Warehouse".equals(requestType)) {
                return new ResponseEntity<>("Invalid requestType. Please provide 'Return to Warehouse' exclusively.", HttpStatus.OK);
            }


            boolean IsDeleted = itemStatusService.getIsDeleted(itemId);
            int ItemStatusId = itemStatusService.getStatusId(itemId);

            if (ItemStatusId == 3) {
                return new ResponseEntity<>("ITEM LOST", HttpStatus.OK);
            }
            if (IsDeleted == true) {
                return new ResponseEntity<>(" ITEM DELETED", HttpStatus.OK);
            }

            if (ItemStatusId == 2) {
                return new ResponseEntity<>("ITEM ALREADY IN WAREHOUSE", HttpStatus.OK);
            }

            else {
                itemStatusService.changeItemStatus(itemId, statusId, statusBy, date, refNo, requestType);
                return ResponseEntity.ok("Returned  Successfully");
            }
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return new ResponseEntity<>("Error " + e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }













//this api active in production
@Transactional
@PostMapping("/returnToWarehouse")
    //without refNo parameter
    //Return To Warehouse
    public ResponseEntity<Object> ReturnToWarehouse( @RequestBody ReturnToWarehouseRequest returnToWarehouseRequest) {
        try {
                if (returnToWarehouseRequest.getStatusBy()==null|| returnToWarehouseRequest.getStatusBy().isEmpty()){
                return new ResponseEntity<>("statusBy cannot be null or empty.", HttpStatus.BAD_REQUEST);
            }
            boolean userExists =  usersService.isUserExists(returnToWarehouseRequest.getStatusBy());
            if (!userExists) {
                return new ResponseEntity<>("{\"User with StatusBy Id \"" + returnToWarehouseRequest.getStatusBy() + "\" does not have permission.\"}", HttpStatus.OK);
            }

            // Check if the item exists
            if (!itemStatusService.itemExists(returnToWarehouseRequest.getItemId())) {
                return new ResponseEntity<>("{\"Item with ID \"" + returnToWarehouseRequest.getItemId() + "\" does not exist.\"}", HttpStatus.OK);
            }

            if (returnToWarehouseRequest.getStatusId() != 2) {
                return new ResponseEntity<>("Invalid statusId. Please Select only  number  2 ", HttpStatus.OK);
            }
            if (!"Return to Warehouse".equals(returnToWarehouseRequest.getRequestType())) {
                return new ResponseEntity<>("Invalid requestType. Please provide 'Return to Warehouse' exclusively.", HttpStatus.OK);
            }


            boolean IsDeleted = itemStatusService.getIsDeleted(returnToWarehouseRequest.getItemId());
            int ItemStatusId = itemStatusService.getStatusId(returnToWarehouseRequest.getItemId());


            if (ItemStatusId == 3) {
                return new ResponseEntity<>("ITEM LOSTed And You Can Not  Returned To Warehouse", HttpStatus.OK);
            }
            if (IsDeleted == true) {
                return new ResponseEntity<>(" ITEM Is  DELETED And You Can Not  Returned To Warehouse", HttpStatus.OK);
            }

            if (ItemStatusId == 2) {
                return new ResponseEntity<>("ITEM ALREADY IN WAREHOUSE", HttpStatus.OK);
            }



            else {
                itemStatusService.changeItemStatus(returnToWarehouseRequest.getItemId(), returnToWarehouseRequest.getStatusId(), returnToWarehouseRequest.getStatusBy(), returnToWarehouseRequest.getDate(), returnToWarehouseRequest.getRefNo(), returnToWarehouseRequest.getRequestType());
                return ResponseEntity.ok("Returned  Successfully");
            }
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return new ResponseEntity<>("Error " + e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }




@Transactional
    @PostMapping("/issuedFromWarehouse")
    //Case 1 Transfer between employee
    //case 2  Issued from Warehouse
    public ResponseEntity<Object> issuedFromWarehouse( @RequestBody IssuedFromWarehouseRequest issuedFromWarehouseRequest) {
        try {
            if (issuedFromWarehouseRequest.getStatusBy()==null|| issuedFromWarehouseRequest.getStatusBy().isEmpty()){
                return new ResponseEntity<>("statusBy cannot be null or empty.", HttpStatus.BAD_REQUEST);
            }

            boolean userExists =  usersService.isUserExists(issuedFromWarehouseRequest.getStatusBy());

            boolean isEmployeeExist =  usersService.isEmployeeExist(issuedFromWarehouseRequest.getCustodyBy());



            if (!userExists) {
                return new ResponseEntity<>("{\"User with StatusBy Id \"" + issuedFromWarehouseRequest.getStatusBy() + "\" does not have permission.\"}", HttpStatus.OK);
            }
            if (!isEmployeeExist) {
                return new ResponseEntity<>("{\"Employee  with CustodyBy Id \"" + issuedFromWarehouseRequest.getCustodyBy() + "\" does not Exist \"}", HttpStatus.OK);
            }

            if (!itemStatusService.itemExists(issuedFromWarehouseRequest.getItemId())) {
                return new ResponseEntity<>("{\"Item with ID \"" + issuedFromWarehouseRequest.getItemId() + "\" does not exist.\"}", HttpStatus.OK);
            }
            if (issuedFromWarehouseRequest.getStatusId() != 1) {
                return new ResponseEntity<>("Invalid statusId. Please Select only  number  1 ", HttpStatus.OK);
            }
            if (!"Issued from Warehouse".equals(issuedFromWarehouseRequest.getRequestType())) {
                return new ResponseEntity<>("Invalid requestType. Please provide 'Issued from Warehouse' exclusively.", HttpStatus.OK);
            }
            int ItemStatusId = itemStatusService.getStatusId(issuedFromWarehouseRequest.getItemId());
            boolean IsDeleted = itemStatusService.getIsDeleted(issuedFromWarehouseRequest.getItemId());
            if (IsDeleted == true) {
                return new ResponseEntity<>(" ITEM Is  DELETED And You Can Not  Issued From  Warehouse", HttpStatus.OK);
            }
            if (ItemStatusId == 3) {
                return new ResponseEntity<>("ITEM LOSTed And You Can Not  Issued From  Warehouse", HttpStatus.OK);
            }
            if (ItemStatusId == 1) {
                return new ResponseEntity<>("ITEM Under Custody  You Can Not Issued  From  Warehouse", HttpStatus.OK);
            }
            else {


                itemStatusService.changeItemStatus(issuedFromWarehouseRequest.getItemId(), issuedFromWarehouseRequest.getStatusId(), issuedFromWarehouseRequest.getStatusBy(), issuedFromWarehouseRequest.getDate(), issuedFromWarehouseRequest.getRefNo(), issuedFromWarehouseRequest.getRequestType());
                itemStatusService.addCustody(issuedFromWarehouseRequest.getItemId(), issuedFromWarehouseRequest.getCustodyBy(), issuedFromWarehouseRequest.getDate(), issuedFromWarehouseRequest.getRefNo(), issuedFromWarehouseRequest.getRequestType());
                return ResponseEntity.ok(" Changed Successfully");
            }
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return new ResponseEntity<>("Error " + e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }

    }





}

