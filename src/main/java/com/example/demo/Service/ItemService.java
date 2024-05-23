package com.example.demo.Service;

import com.example.demo.dto.BatchAddItemsRequest;

import java.util.List;

public interface ItemService {

    int registerBatch(Long actionBy);

    int runBatch(Long actionBy, List<BatchAddItemsRequest> batchItems);
}

