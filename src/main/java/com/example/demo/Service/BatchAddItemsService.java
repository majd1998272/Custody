//package com.example.demo.Service;
//
//
//import com.example.demo.Model.BatchAddItems;
//import com.example.demo.Repository.BatchAddItemsRepository;
//import com.example.demo.dto.BatchAddItemsRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//
//
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class BatchAddItemsService {
//
//    //    @Autowired
//    private final BatchAddItemsRepository batchItemsRepository;
//    private final JdbcTemplate jdbcTemplate;
//    @Autowired
//    public BatchAddItemsService(BatchAddItemsRepository batchItemsRepository, JdbcTemplate jdbcTemplate) {
//        this.batchItemsRepository = batchItemsRepository;
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//
//    @Transactional
//    public int registerBatch(String actionBy) {
//        String registerAddItemsBatch = "Custody.usp_RegisterAddItemsBatch";
//        Integer newBatchNumber = jdbcTemplate.update("EXEC " + registerAddItemsBatch + " ?", actionBy);
//        return newBatchNumber;
//    }
//
////    @Transactional
////    public int runBatch(int actionBy, int batchNumber, List<BatchAddItemsRequest> batchItems) {
////        int  batchNumber2 = jdbcTemplate.update("EXEC " + registerAddItemsBatch + " ?", actionBy);
////
////        // Your logic to run a batch
////        // Process batchItems and update database records
////        String runAddItemsBatch = "Custody.usp_RunAddItemsBatch";
////        Integer numErrors=jdbcTemplate.update("EXEC " + runAddItemsBatch + " ?, ?", actionBy, batchNumber2);
////
////        return numErrors;
////    }
//
//
////    @Transactional
////    public int batchAddItems(String actionBy, List<BatchAddItemsRequest> batchItems) {
////
////        List<BatchAddItems> items = new ArrayList<>();
////
////        for (BatchAddItemsRequest item : batchItems) {
////            BatchAddItems newItem = new BatchAddItems();
////            newItem.setItemCode(item.getItemCode());
////            newItem.setItemSerial(item.getItemSerial());
////            newItem.setBarcodId(item.getStockSerialID());
////            newItem.setLocationCode(item.getLocationCode());
////            newItem.setReferenceNo(item.getReferenceNo());
////            newItem.setEmployeeId(item.getEmployeeId());
////            newItem.setNewStatusDate(item.getNewStatusDate());
////            newItem.setRequestType(item.getRequestType());
////            newItem.setCategory(item.getCategory());
////            newItem.setBarcodeNumber(item.getBarcodeNumber());
////            newItem.setItemSerialNumber(item.getItemSerialNumber());
////            newItem.setItemType(item.getItemType());
////            items.add(newItem);
////        }
////        batchItemsRepository.saveAll(items);
//
//
//
//    @Transactional
//    public int batchAddItems(String actionBy, BatchAddItemsRequest batchItems) {
//            BatchAddItems newItem = new BatchAddItems();
//            newItem.setItemCode(batchItems.getItemCode());
//            newItem.setItemSerial(batchItems.getItemSerial());
//            newItem.setBarcodId(batchItems.getStockSerialID());
//            newItem.setLocationCode(batchItems.getLocationCode());
//            newItem.setReferenceNo(batchItems.getReferenceNo());
//            newItem.setEmployeeId(batchItems.getEmployeeId());
//            newItem.setNewStatusDate(batchItems.getNewStatusDate());
//            newItem.setRequestType(batchItems.getRequestType());
//            newItem.setCategory(batchItems.getCategory());
//            newItem.setBarcodeNumber(batchItems.getBarcodeNumber());
//            newItem.setItemSerialNumber(batchItems.getItemSerialNumber());
//            newItem.setItemType(batchItems.getItemType());
//
//        batchItemsRepository.save(newItem);
//        int outputParam = 0; // Placeholder for the output parameter
//
//       // int newBatchNumber = executeRegisterAddItemsBatch(13633);
//
//
//        //String registerAddItemsBatch = "Custody.usp_RegisterAddItemsBatch";
//        //int newBatchNumber = jdbcTemplate.update("EXEC " + registerAddItemsBatch + " ?", 13633);
//
//        //System.out.println("NewBatchNumber : "+ newBatchNumber);
//        System.out.println("ActionBy : "+ actionBy);
//
//        int newBatchNumber = batchItemsRepository.runAddItemsBatch(actionBy);
//        System.out.println("newBatchNumber : "+ newBatchNumber);
//
//
//       // String runAddItemsBatch = "Custody.usp_RunAddItemsBatch";
//       // int numErrors = jdbcTemplate.update("EXEC " + runAddItemsBatch + " ?, ?", 13633, 25);
//        int numErrors = batchItemsRepository.runAddItemsBatch(actionBy, newBatchNumber);
//        System.out.println("numErrors : "+ numErrors);
//
//        return numErrors;
//
//
////        List<BatchAddItems> items = batchItemsRepository.findAll();
////        items.stream().map(this::mapDTO).toList();
//
////        BatchAddItems item = new BatchAddItems();
////        item.setItemCode(batchAddItemsRequest.getItemCode());
////        item.setItemSerial(batchAddItemsRequest.getItemSerial());
////        item.setItemType(batchAddItemsRequest.getItemType());
////        item.setBarcodeNumber(batchAddItemsRequest.getBarcodeNumber());
////        item.setBatchNumber(batchAddItemsRequest.getBatchNumber());
////        item.setCategory(batchAddItemsRequest.getCategory());
////        item.setEmployeeId(batchAddItemsRequest.getEmployeeId());
////        item.setLocationCode(batchAddItemsRequest.getLocationCode());
////        item.setErrorCode(batchAddItemsRequest.getErrorCode());
////        item.setErrorDescription(batchAddItemsRequest.getErrorDescription());
////        item.setNewStatusDate(batchAddItemsRequest.getNewStatusDate());
////        item.setPending(batchAddItemsRequest.getPending());
////        item.setReferenceNo(batchAddItemsRequest.getReferenceNo());
////        item.setRequestType(batchAddItemsRequest.getRequestType());
////        item.setItemSerialNumber(batchAddItemsRequest.getItemSerialNumber());
////        item.setBarcodId(batchAddItemsRequest.getBarcodId());
////        batchItemsRepository.save(item);
//
////        batchItems.stream().map(this::mapDTO).toList();
//
//
//        // Your logic to run a batch
//        // Process batchItems and update database records
//
//    }
//
////    private BatchAddItems mapDTO(BatchAddItemsRequest batchAddItemsRequest) {
////        BatchAddItems batchAddItems = BatchAddItems.builder()
////                .itemCode(batchAddItemsRequest.getItemCode())
////               .itemSerial(batchAddItemsRequest.getItemSerial())  // Uncomment this line
////                .itemType(batchAddItemsRequest.getItemType())      // Uncomment this line
////                .barcodeNumber(batchAddItemsRequest.getBarcodeNumber())  // Uncomment this line
////                .batchNumber(batchAddItemsRequest.getBatchNumber())      // Uncomment this line
////                .category(batchAddItemsRequest.getCategory())      // Uncomment this line
////                .employeeId(batchAddItemsRequest.getEmployeeId())    // Uncomment this line
////                .locationCode(batchAddItemsRequest.getLocationCode())  // Uncomment this line
////                .errorCode(batchAddItemsRequest.getErrorCode())      // Uncomment this line
////                .errorDescription(batchAddItemsRequest.getErrorDescription())  // Uncomment this line
////                .newStatusDate(batchAddItemsRequest.getNewStatusDate())  // Uncomment this line
////                .pending(batchAddItemsRequest.getPending())        // Uncomment this line
////                .referenceNo(batchAddItemsRequest.getReferenceNo())  // Uncomment this line
////                .requestType(batchAddItemsRequest.getRequestType())  // Uncomment this line
////                .itemSerialNumber(batchAddItemsRequest.getItemSerialNumber())  // Uncomment this line
////                .barcodId(batchAddItemsRequest.getBarcodeId())      // Uncomment this line
////                .build();  // Add this line to complete the builder
////
////        return batchAddItems;
////    }
//
//
////
////    private BatchAddItems mapDTO(BatchAddItemsRequest batchAddItemsRequest) {
////        BatchAddItems batchAddItems = new BatchAddItems();
////        return batchAddItems
////                .setbatchNumber(batchAddItemsRequest.getBatchNumber())
////                .setitemCode(batchAddItemsRequest.getItemCode())
////                .setitemType(batchAddItemsRequest.getItemType())
////                .setbarcodeNumber(batchAddItemsRequest.getBarcodeNumber())
////                .setbatchNumber(batchAddItemsRequest.getBatchNumber())
////                .setcategory(batchAddItemsRequest.getCategory())
////                .setemployeeId(batchAddItemsRequest.getEmployeeId())
////                .setlocationCode(batchAddItemsRequest.getLocationCode())
////                .seterrorCode(batchAddItemsRequest.getErrorCode())
////                .seterrorDescription(batchAddItemsRequest.getErrorDescription())
////                .setnewStatusDate(batchAddItemsRequest.getNewStatusDate())
////                .setpending(batchAddItemsRequest.getPending())
////                .setreferenceNo(batchAddItemsRequest.getReferenceNo())
////                .setrequestType(batchAddItemsRequest.getRequestType())
////                .setitemSerialNumber(batchAddItemsRequest.getItemSerialNumber())
////                .setbarcodId(batchAddItemsRequest.getBarcodeId());
////    }
////
////public int executeRegisterAddItemsBatch(int actionby)
////{
////    return batchItemsRepository.executeRegisterAddItemsBatch(actionby);
////}
////
////    public int executeRunAddItemsBatch(int actionby , int batchNumber)
////    {
////        return batchItemsRepository.executeRunAddItemsBatch(actionby,batchNumber);
////    }
//
//
//
//
//
////    public int runAddItemsBatch(String actionBy, int batchNumber) {
////        return batchItemsRepository.runAddItemsBatch(actionBy, batchNumber);
////    }
//
//}

package com.example.demo.Service;


import com.example.demo.Model.BatchAddItems;
import com.example.demo.Repository.BatchAddItemsRepository;
import com.example.demo.dto.BatchAddItemsRequest;
import com.example.demo.dto.BatchAddItemsRequestTemporary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BatchAddItemsService {

    //    @Autowired
    private final BatchAddItemsRepository batchItemsRepository;
    private final JdbcTemplate jdbcTemplate;

    public BatchAddItemsService(BatchAddItemsRepository batchItemsRepository, JdbcTemplate jdbcTemplate) {
        this.batchItemsRepository = batchItemsRepository;
        this.jdbcTemplate = jdbcTemplate;
    }


//    @Transactional
//    public int registerBatch(String actionBy) {
//        String registerAddItemsBatch = "Custody.usp_RegisterAddItemsBatch";
//        Integer newBatchNumber = jdbcTemplate.update("EXEC " + registerAddItemsBatch + " ?", actionBy);
//        return newBatchNumber;
//    }
//
//    @Transactional
//    public int batchAddItems(String actionBy, BatchAddItemsRequest batchItems) {
//        BatchAddItems newItem = new BatchAddItems();
//        newItem.setItemCode(batchItems.getItemCode());
//        newItem.setItemSerial(batchItems.getItemSerial());
//        newItem.setBarcodId(batchItems.getStockSerialID());
//        newItem.setLocationCode(batchItems.getLocationCode());
//        newItem.setReferenceNo(batchItems.getReferenceNo());
//        newItem.setEmployeeId(batchItems.getEmployeeId());
//        newItem.setNewStatusDate(batchItems.getNewStatusDate());
//        newItem.setRequestType(batchItems.getRequestType());
//        newItem.setCategory(batchItems.getCategory());
//        newItem.setBarcodeNumber(batchItems.getBarcodeNumber());
//        newItem.setItemSerialNumber(batchItems.getItemSerialNumber());
//        newItem.setItemType(batchItems.getItemType());
//        batchItemsRepository.save(newItem);
//        System.out.println("newItem:    " + newItem);
//
//        String batchnumber = new String();
//        String ErrorDescription =new String();
//
//
//        System.out.println("actionBy:    " + actionBy);
//
//        String registerAddItemsBatch = "Custody.usp_RegisterAddItemsBatch";
//        int newBatchNumber = jdbcTemplate.update("EXEC " + registerAddItemsBatch + " ?", actionBy);
//        System.out.println("newBatchNumber:       " + newBatchNumber);
//        batchnumber =jdbcTemplate.queryForObject("Select top 1 batchnumber from [dbo].BatchAddItems order by batchnumber desc", String.class);
//        System.out.println("batchnumber :  "+ batchnumber);
//
////when call this procedure usp_RunAddItemsBatch  with batchnumber   the error is happen
//        String runAddItemsBatch = "Custody.usp_RunAddItemsBatch";
//        Integer numErrors = jdbcTemplate.update("EXEC " + runAddItemsBatch + " ?, ?", actionBy, batchnumber);
//
//        System.out.println("numErrors:     " + numErrors);
//
//        return numErrors;
//    }
//}





    //Bshr
    @Transactional
    public String batchAddItems(String actionBy, BatchAddItemsRequest batchItems) {
        BatchAddItems newItem = new BatchAddItems();
        newItem.setItemCode(batchItems.getItemCode());
        newItem.setItemSerial(batchItems.getItemSerial());
        newItem.setBarcodId(batchItems.getStockSerialID());
        newItem.setLocationCode(batchItems.getLocationCode());
        newItem.setReferenceNo(batchItems.getReferenceNo());
        newItem.setEmployeeId(batchItems.getEmployeeId());
        newItem.setNewStatusDate(batchItems.getNewStatusDate());
        newItem.setRequestType(batchItems.getRequestType());
        newItem.setCategory(batchItems.getCategory());
        newItem.setBarcodeNumber(batchItems.getBarcodeNumber());
        newItem.setItemSerialNumber(batchItems.getItemSerialNumber());
        newItem.setItemType(batchItems.getItemType());
        batchItemsRepository.save(newItem);

        System.out.println(newItem);
        System.out.println(actionBy);

       String registerAddItemsBatch = "Custody.usp_RegisterAddItemsBatchApi";
        Integer newBatchNumber = jdbcTemplate.update("EXEC " + registerAddItemsBatch + " ?", actionBy);
        String batchnumber =jdbcTemplate.queryForObject("Select top 1 batchnumber from [dbo].BatchAddItems order by batchnumber desc", String.class);
        System.out.println(batchnumber);

        String runEditItemsBatch = "Custody.usp_RunAddItemsBatchApi";
        Integer numErrors = jdbcTemplate.update("EXEC " + runEditItemsBatch + " ?, ?", actionBy, Integer.parseInt(batchnumber));
        String ErrorDescription =jdbcTemplate.queryForObject("Select top 1 ErrorDescription from [dbo].BatchAddItems where BatchNumber="+Integer.parseInt(batchnumber) +" order by batchnumber desc", String.class);
        System.out.println(ErrorDescription);
        return ErrorDescription;
    }






    @Transactional
    public String batchAddItemsTemporary(String actionBy, BatchAddItemsRequestTemporary batchItems) {
        BatchAddItems newItem = new BatchAddItems();
        newItem.setItemCode(batchItems.getItemCode());
        newItem.setItemSerial(batchItems.getItemSerial());
        newItem.setBarcodId(batchItems.getStockSerialID());
        newItem.setLocationCode(batchItems.getLocationCode());
        newItem.setReferenceNo(batchItems.getReferenceNo());
        newItem.setEmployeeId(batchItems.getEmployeeId());
        newItem.setNewStatusDate(batchItems.getNewStatusDate());
        newItem.setRequestType(batchItems.getRequestType());
        newItem.setCategory(batchItems.getCategory());
        newItem.setBarcodeNumber(batchItems.getBarcodeNumber());
        newItem.setItemSerialNumber(batchItems.getItemSerialNumber());
        newItem.setItemType(batchItems.getItemType());
        batchItemsRepository.save(newItem);

        System.out.println(newItem);
        System.out.println(actionBy);

        String registerAddItemsBatch = "Custody.usp_RegisterAddItemsBatchApi_Temporary";
        Integer newBatchNumber = jdbcTemplate.update("EXEC " + registerAddItemsBatch + " ?", actionBy);
        String batchnumber =jdbcTemplate.queryForObject("Select top 1 batchnumber from [dbo].BatchAddItems order by batchnumber desc", String.class);
        System.out.println(batchnumber);


        String runAddItemsBatch = "Custody.usp_RunAddItemsBatch_Api_Temporary";
        Integer numErrors = jdbcTemplate.update("EXEC " + runAddItemsBatch + " ?, ?, ?", actionBy, Integer.parseInt(batchnumber), batchItems.isTemporary());
        String ErrorDescription =jdbcTemplate.queryForObject("Select top 1 ErrorDescription from [dbo].BatchAddItems where BatchNumber="+Integer.parseInt(batchnumber) +" order by batchnumber desc", String.class);
        System.out.println(ErrorDescription);
        return ErrorDescription;
    }




}





