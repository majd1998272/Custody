package com.example.demo.Controller;

import com.example.demo.Service.BatchItemsChangeStatusService;
import com.example.demo.dto.BatchAddItemsRequest;
import com.example.demo.dto.BatchItemsChangeStatusRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
//@RequestMapping("/change")
public class BatchItemsChangeStatusController {
    private final BatchItemsChangeStatusService batchItemsChangeStatusService;

    public BatchItemsChangeStatusController(BatchItemsChangeStatusService batchItemsChangeStatusService) {
        this.batchItemsChangeStatusService = batchItemsChangeStatusService;
    }

    @PostMapping("/changeStatusItem")

    public ResponseEntity<Object> batchItemsChangeStatus(@RequestParam String actionBy, @RequestBody BatchItemsChangeStatusRequest batchItemsChangeStatusRequests) {
        try {
            System.out.println(batchItemsChangeStatusRequests);
            String ErrorDescription = batchItemsChangeStatusService.batchItemsChangeStatus(actionBy, batchItemsChangeStatusRequests);
//            int numErrors = batchItemsChangeStatusService.batchItemsChangeStatus(actionBy, batchItemsChangeStatusRequests);
//             batchItemsChangeStatusService.updateBatchNumber();

            if (ErrorDescription.equals("SUCCESS")) {
                return new ResponseEntity<>("{ \"Description : \"" + ErrorDescription + "\"}.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("{\" Error  : \"" + ErrorDescription + "\"}", HttpStatus.OK);
            }
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("Error processing batch: " + e.getMessage());
        }

    }
}
