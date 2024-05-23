package com.example.demo.Service;

import com.example.demo.Model.BatchEditItems;
import com.example.demo.Model.Items;
import com.example.demo.Repository.BatchEditItemsRepository;
import com.example.demo.Repository.ItemsRepository;
import com.example.demo.dto.BatchEditItemsRequest;
import com.example.demo.dto.UpadateTemporary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BatchEditItemsService {
    // @Autowired
    private final BatchEditItemsRepository batchEditItemsRepository;
    private final ItemsRepository itemsRepository;

    private final JdbcTemplate jdbcTemplate;


    public BatchEditItemsService(BatchEditItemsRepository batchEditItemsRepository, ItemsRepository itemsRepository, JdbcTemplate jdbcTemplate) {
        this.batchEditItemsRepository = batchEditItemsRepository;
        this.itemsRepository = itemsRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public int registerBatch(String actionBy) {
        String registerNewEditeItemsBatch = "Custody.usp_RegisterNewEditeItemsBatch";
        Integer newBatchNumber = jdbcTemplate.update("EXEC " + registerNewEditeItemsBatch + " ?", actionBy);
        return newBatchNumber;
    }

    @Transactional
    public String batchEditItems(String actionBy, BatchEditItemsRequest batchEditItemsRequests) {
//        BatchEditItems items = new BatchEditItems();
            BatchEditItems newItem = new BatchEditItems();
    String batchnumber = new String();
    String ErrorDescription =new String();
            newItem.setItemSerial(batchEditItemsRequests.getItemSerial());
            newItem.setBarcodId(batchEditItemsRequests.getStockSerialID());
            newItem.setLocationCode(batchEditItemsRequests.getLocationCode());
            newItem.setCategory(batchEditItemsRequests.getCategory());
            newItem.setBarcodeNumber(batchEditItemsRequests.getBarcodeNumber());
            newItem.setItemSerialNumber(batchEditItemsRequests.getItemSerialNumber());
            newItem.setItemType(batchEditItemsRequests.getItemType());

        batchEditItemsRepository.save(newItem);
        System.out.println(newItem);
        System.out.println(actionBy);

        String registerNewEditeItemsBatch = "Custody.usp_RegisterNewEditeItemsBatchApi";
        Integer newBatchNumber = jdbcTemplate.update("EXEC " + registerNewEditeItemsBatch + " ?", actionBy);
        batchnumber =jdbcTemplate.queryForObject("Select top 1 batchnumber from [dbo].BatchEditItems order by batchnumber desc", String.class);
        System.out.println(batchnumber);
        String runEditItemsBatch = "Custody.usp_RunEditItemsBatchApi";
        Integer numErrors = jdbcTemplate.update("EXEC " + runEditItemsBatch + " ?, ?", actionBy, Integer.parseInt(batchnumber));
        ErrorDescription =jdbcTemplate.queryForObject("Select top 1 ErrorDescription from [dbo].BatchEditItems where BatchNumber="+Integer.parseInt(batchnumber) +" order by batchnumber desc", String.class);
        System.out.println(ErrorDescription);
        return ErrorDescription;
    }





    @Transactional
    public String batchEditItemsTemporary(UpadateTemporary temporary) {
        try {
            Optional<Items> optionalItem = itemsRepository.findById(temporary.getItemId());
            if (optionalItem.isPresent()) {
                Items items = optionalItem.get();
                items.setTemporary(temporary.getTemporary());
                itemsRepository.save(items);
                return "Updated";
            } else {
                return "Item with ID " + temporary.getItemId() + " does not exist.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception (optional)
            // logger.error("Error updating item temporary status", e);
            return "Failed to update item temporary status: " + e.getMessage();
        }
    }





}
