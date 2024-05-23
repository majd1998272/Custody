package com.example.demo.Controller;

import com.example.demo.Service.NewSingleItemService;
import com.example.demo.dto.NewSingleItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
public class NewSingleItemController {

    @Autowired
    private NewSingleItemService newSingleItemService;

    @PostMapping("/addSingleItem")
    public ResponseEntity<String> addItem(@RequestBody NewSingleItemRequest newSingleItemRequest) {
        int result = newSingleItemService.addItem(newSingleItemRequest.getItemCode(), newSingleItemRequest.getItemSerial(),
                newSingleItemRequest.getItemStatusID(), newSingleItemRequest.getItemStatusBy(), newSingleItemRequest.getBarcodeID(),
                newSingleItemRequest.getReference(), newSingleItemRequest.getLocationCode(), newSingleItemRequest.getCategoryId(),
                newSingleItemRequest.getItemTypeId(), newSingleItemRequest.getBarcodeNumber(), newSingleItemRequest.getItemSerialNumber());
        
        System.out.println(newSingleItemRequest);

        if (result > 0) {
            return ResponseEntity.ok("Item added successfully. Item ID: " + result);
        }
        if (result== -1) {
            return  ResponseEntity.badRequest().body(" Item Code not exists" + result);
        }
        if (result== -2) {
            return  ResponseEntity.badRequest().body("Invalid Serial (Serial already exists): " + result);
        }
        if (result== -3) {
            return  ResponseEntity.badRequest().body("Invalid BarcodeID (BarcodeID already exists" + result);
        }



        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add item. Please try again.");
        }
    }
}

