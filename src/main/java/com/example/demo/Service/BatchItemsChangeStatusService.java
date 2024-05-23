package com.example.demo.Service;

import com.example.demo.Model.BatchItemsChangeStatus;
import com.example.demo.Repository.BatchItemsChangeStatusRepository;
import com.example.demo.dto.BatchItemsChangeStatusRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BatchItemsChangeStatusService {
    private final BatchItemsChangeStatusRepository batchItemsChangeStatusRepository;
    private final JdbcTemplate jdbcTemplate;

    public BatchItemsChangeStatusService(BatchItemsChangeStatusRepository batchItemsChangeStatusRepository, JdbcTemplate jdbcTemplate) {
        this.batchItemsChangeStatusRepository = batchItemsChangeStatusRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public int registerBatch(String actionBy) {
        String registerBatchItemsChangeStatus = "usp_RegisterBatchItemsChangeStatus";
        Integer newBatchNumber = jdbcTemplate.update("EXEC " + registerBatchItemsChangeStatus + " ?", actionBy);
        return newBatchNumber;
    }

    public int registerBatchItemsChangeStatus(String actionBy) {
        String procedureCall = "{CALL Custody.usp_RegisterBatchItemsChangeStatus(?)}";
        jdbcTemplate.update(procedureCall, actionBy);
        int  batchnumber =jdbcTemplate.queryForObject("Select top 1 batchnumber from [dbo].BatchItemsChangeStatus order by batchnumber desc", Integer.class);
         return  batchnumber ;
    }



    @Transactional
    public String batchItemsChangeStatus(String actionBy, BatchItemsChangeStatusRequest batchItemsChangeStatusRequest) {
       String batchnumber = new String();
      String ErrorDescription =new String();
      String ID = new String();
            BatchItemsChangeStatus newItem = new BatchItemsChangeStatus();
            newItem.setItemSerial(batchItemsChangeStatusRequest.getItemSerial());
            newItem.setReference(batchItemsChangeStatusRequest.getReference());
            newItem.setItemCode(batchItemsChangeStatusRequest.getItemCode());
            newItem.setCustodyItemEndDate(batchItemsChangeStatusRequest.getItemEndDate());
            newItem.setNewItemStatus(batchItemsChangeStatusRequest.getNewItemStatus());
            newItem.setCustodyBy(batchItemsChangeStatusRequest.getEmployeeId());
            newItem.setRequestType(batchItemsChangeStatusRequest.getRequestType());
            newItem.setBarcodeNumber(batchItemsChangeStatusRequest.getBarcodeNumber());
            newItem.setItemSerialNumber(batchItemsChangeStatusRequest.getItemSerialNumber());
            newItem.setItemType(batchItemsChangeStatusRequest.getItemType());

        batchItemsChangeStatusRepository.save(newItem);
        System.out.println("newItem"+ newItem);
        System.out.println("actionBy   :"+ actionBy);


        String registerBatchItemsChangeStatus = "Custody.usp_RegisterBatchItemsChangeStatus";
        Integer newBatchNumber = jdbcTemplate.update("EXEC " + registerBatchItemsChangeStatus + " ?", actionBy);
        System.out.println("newBatchNumber     "+ newBatchNumber );

//        String sqlQuery = "SELECT TOP 1 Id FROM [dbo].BatchItemsChangeStatusInfo " +
//                "WHERE ID = (SELECT TOP 1 Id FROM [dbo].BatchItemsChangeStatus ORDER BY Id DESC)";
//
//
//         batchnumber = jdbcTemplate.queryForObject(sqlQuery, String.class);
//        System.out.println( "batchnumber   :"+batchnumber);








         String batchnumberfinal =jdbcTemplate.queryForObject("Select top 1 Id  from [dbo].BatchItemsChangeStatusInfo order by Id desc", String.class);
        System.out.println( "batchnumberfinal   :"+batchnumberfinal);

         batchnumber =jdbcTemplate.queryForObject("Select top 1 batchNumber  from [dbo].BatchItemsChangeStatus  order by Id desc", String.class);
        System.out.println( "batchnumber   :"+batchnumber);
        System.out.println( "batchnumber   :"+Integer.parseInt(batchnumber));

        String runBatchChangeStatus = "Custody.usp_RunBatchChangeStatus";
        Integer numErrors = jdbcTemplate.update("EXEC " + runBatchChangeStatus + " ?, ?", actionBy, Integer.parseInt(batchnumber));
         ErrorDescription =jdbcTemplate.queryForObject("Select top 1 ErrorDescription from [dbo].BatchItemsChangeStatus where BatchNumber="+Integer.parseInt(batchnumber) +" order by Id desc", String.class);
        System.out.println("ErrorDescription   : "+ErrorDescription);








//        String BatchNumber = "UPDATE [dbo].BatchItemsChangeStatus\n" +
//                "SET BatchNumber = (SELECT TOP 1 Id FROM [dbo].BatchItemsChangeStatusInfo ORDER BY Id DESC)\n" +
//                "WHERE ID = (SELECT TOP 1 Id FROM [dbo].BatchItemsChangeStatus ORDER BY Id DESC)\n " ;
//        jdbcTemplate.update(BatchNumber);
//        System.out.println("Final Batch Number: "+BatchNumber);
        return ErrorDescription;
    }

    @Transactional
    public void updateBatchNumber() {
        String BatchNumber = "UPDATE [dbo].BatchItemsChangeStatus " +
                "SET BatchNumber = (SELECT TOP 1 Id FROM BatchItemsChangeStatusInfo where BatchNumber=\"+Integer.parseInt(batchnumber) +\" ORDER BY Id DESC  ) ";
        jdbcTemplate.update(BatchNumber);
        System.out.println(BatchNumber);
    }
}
