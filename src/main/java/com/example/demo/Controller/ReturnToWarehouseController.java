package com.example.demo.Controller;
import com.example.demo.dto.ReturnToWarehouseRequest;
import com.example.demo.Service.ReturnToWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class ReturnToWarehouseController {
    private final ReturnToWarehouseService returnToWarehouseService;
    @Autowired
    public ReturnToWarehouseController(ReturnToWarehouseService returnToWarehouseService) {
        this.returnToWarehouseService = returnToWarehouseService;
    }
    @PostMapping("/ReturnToWarehouse")
    public ResponseEntity<String> ReturnToWarehouse(@RequestBody ReturnToWarehouseRequest request) {
        try {
            returnToWarehouseService.changeItemStatus(request);
            return ResponseEntity.ok("Item status changed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to change item status.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to change item status: " + e.getMessage());

        }
    }
}
