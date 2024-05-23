package com.example.demo.Controller;

import com.example.demo.dto.CustodyDataInEveryCaseResponse;
import com.example.demo.dto.CustodyDataInEveryCaseResponseTemporary;
import com.example.demo.dto.CustodyDataResponse;
import com.example.demo.Service.CustodyDataService;
import com.example.demo.dto.CustodyDataResponseTemporary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CustodyDataController {

    @Autowired
    private CustodyDataService custodyDataService;

    @GetMapping("/getCustodyData")
    public List<CustodyDataResponse> getCustodyData(
            @RequestParam(required = true) String employeeId,
            @RequestParam(required = false) String iteamSerialNumber,
            @RequestParam(required = false) String itemCode,
            @RequestParam(required = false) Date date,
            @RequestParam(required = false) String itemDescription,
            @RequestParam(defaultValue = "false") boolean includeHistory) {
        return custodyDataService.getCustodyData(employeeId, iteamSerialNumber, itemCode, date, itemDescription, includeHistory);
    }


    @GetMapping("/getCustodyDataTemporary")
    public List<CustodyDataResponseTemporary> getCustodyDataTemporary(
            @RequestParam(required = true) String employeeId,
            @RequestParam(required = false) String iteamSerialNumber,
            @RequestParam(required = false) String itemCode,
            @RequestParam(required = false) Date date,
            @RequestParam(required = false) String itemDescription,
            @RequestParam(defaultValue = "false") boolean includeHistory) {
        return custodyDataService.getCustodyDataTemporary(employeeId, iteamSerialNumber, itemCode, date, itemDescription, includeHistory);
    }


    @GetMapping("/getCustodyDataInEveryCase")
    public ResponseEntity<Object> getCustodyDataInEveryCase(
            @RequestParam(required = false) int ItemStatusID,
            @RequestParam(required = false) String ItemCode,
            @RequestParam(required = false) String BarcodeNumber,
            @RequestParam(required = false) String iteamSerialNumber,
            @RequestParam(required = false) String BarcodeId,
            @RequestParam(defaultValue = "false") boolean IsDeleted) {
//        if (ItemStatusID != 0){
//            throw new IllegalArgumentException("IsDeleted must be allways  number [0]");
//
//        }

        List<CustodyDataInEveryCaseResponse> custodyDataInEveryCaseResponses = custodyDataService.getCustodyDataInEveryCase(ItemStatusID, ItemCode, BarcodeNumber, iteamSerialNumber, BarcodeId, IsDeleted);

        // Enforce specific values for ItemStatusID
        if (ItemStatusID != 1 && ItemStatusID != 2) {
            return new ResponseEntity<>("Invalid ItemStatusID. Please provide Number [1]: to search item UnderCustody or Number  [2]:  to search item In Warehouse.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(custodyDataInEveryCaseResponses, HttpStatus.OK);
        }
    }








    @GetMapping("/getCustodyDataInEveryCaseTemporary")
    public ResponseEntity<Object> getCustodyDataInEveryCaseTemporary(
            @RequestParam(required = false) int ItemStatusID,
            @RequestParam(required = false) String ItemCode,
            @RequestParam(required = false) String BarcodeNumber,
            @RequestParam(required = false) String iteamSerialNumber,
            @RequestParam(required = false) String BarcodeId,
            @RequestParam(defaultValue = "false") boolean IsDeleted) {
//        if (ItemStatusID != 0){
//            throw new IllegalArgumentException("IsDeleted must be allways  number [0]");
//
//        }

        List<CustodyDataInEveryCaseResponseTemporary> custodyDataInEveryCaseResponses = custodyDataService.getCustodyDataInEveryCaseTemporary(ItemStatusID, ItemCode, BarcodeNumber, iteamSerialNumber, BarcodeId, IsDeleted);

        // Enforce specific values for ItemStatusID
        if (ItemStatusID != 1 && ItemStatusID != 2) {
            return new ResponseEntity<>("Invalid ItemStatusID. Please provide Number [1]: to search item UnderCustody or Number  [2]:  to search item In Warehouse.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(custodyDataInEveryCaseResponses, HttpStatus.OK);
        }
    }





}
