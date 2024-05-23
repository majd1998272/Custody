package com.example.demo.Service;
import com.example.demo.Model.Items;
import com.example.demo.Model.ItemsCustody;
import com.example.demo.Model.ItemsHistory;
import com.example.demo.Repository.ItemsCustodyRepository;
import com.example.demo.Repository.ItemsHistoryRepository;
import com.example.demo.Repository.ItemsRepository;
import com.example.demo.dto.ReturnToWarehouseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
@Service
public class ReturnToWarehouseService {
    @Autowired
    private  ItemsRepository itemsRepository;
    @Autowired
    private ItemsHistoryRepository itemsHistoryRepository;
    @Autowired
    private ItemsCustodyRepository itemsCustodyRepository;

    @Autowired
    private EntityManager entityManager;


    @Transactional
    public void changeItemStatus(ReturnToWarehouseRequest request) {
        // Implement the logic of your stored procedure here
        try {
            Date statusOn = new Date();
            Items item = itemsRepository.findById(request.getItemId()).orElse(null);
            if (item != null) {
                item.setItemStatusId(request.getStatusId());
                item.setItemStatusBy(request.getStatusBy());
                item.setItemStatusOn(statusOn);
                item.setItemDate(request.getDate());
                item.setItemRefNo(request.getRefNo());
                item.setRequestType(request.getRequestType());
                itemsRepository.save(item);

                // Insert into ItemsHistory table
                ItemsHistory itemsHistory = new ItemsHistory();
                itemsHistory.setItemId((long) item.getItemId());
                itemsHistory.setItemStatusId(request.getStatusId());
                itemsHistory.setItemStatusBy(request.getStatusBy());
                itemsHistory.setItemStatusOn(statusOn);
                itemsHistory.setItemDate(request.getDate());
                itemsHistory.setItemRefNo(request.getRefNo());
                itemsHistory.setRequestType(request.getRequestType());
                itemsHistoryRepository.save(itemsHistory);

                // Update ItemsCustody table if item is under custody
                StoredProcedureQuery query = entityManager.createStoredProcedureQuery("usf_GetItemCustodyCount")
                        .registerStoredProcedureParameter("ItemID", Integer.class, ParameterMode.IN)
                        .registerStoredProcedureParameter("ActiveOnly", Integer.class, ParameterMode.IN)
                        .registerStoredProcedureParameter("ActiveCount", Integer.class, ParameterMode.OUT)
                        .setParameter("ItemID", request.getItemId())
                        .setParameter("ActiveOnly", 1); // Set the parameter value for active count

                query.execute();
                Integer activeCount = (Integer) query.getOutputParameterValue("ActiveCount");
                if (activeCount == 1) {
                    itemsCustodyRepository.updateItemCustodyEndOn((long) item.getItemId(), new Date());
                }

                // Get the output parameter value
//                Integer activeCount = (Integer) query.getOutputParameterValue("ActiveCount");
//                if (ItemsRepository.getItemCustodyCount(item.getItemId(), 1) == 1) {
//                    ItemsRepository.updateItemCustodyEndOn(item.getItemId(), new Date());
//                }
            }
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            throw new RuntimeException("Error while changing item status");
        }
    }





}
