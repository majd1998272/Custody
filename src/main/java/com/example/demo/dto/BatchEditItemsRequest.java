package com.example.demo.dto;

import lombok.Data;

@Data
public class BatchEditItemsRequest { // 7 parameters
    private String itemSerial;
    private String stockSerialID;
    private String locationCode;
    private String category;
    private String barcodeNumber;
    private String itemSerialNumber;
    private String itemType;

    public BatchEditItemsRequest() {
    }

    public BatchEditItemsRequest(String itemSerial, String stockSerialID, String locationCode, String category, String barcodeNumber, String itemSerialNumber, String itemType) {
        this.itemSerial = itemSerial;
        this.stockSerialID = stockSerialID;
        this.locationCode = locationCode;
        this.category = category;
        this.barcodeNumber = barcodeNumber;
        this.itemSerialNumber = itemSerialNumber;
        this.itemType = itemType;
    }

    public String getItemSerial() {
        return itemSerial;
    }

    public void setItemSerial(String itemSerial) {
        this.itemSerial = itemSerial;
    }

    public String getStockSerialID() {
        return stockSerialID;
    }

    public void setStockSerialID(String stockSerialID) {
       this. stockSerialID = stockSerialID;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBarcodeNumber() {
        return barcodeNumber;
    }

    public void setBarcodeNumber(String barcodeNumber) {
        this.barcodeNumber = barcodeNumber;
    }

    public String getItemSerialNumber() {
        return itemSerialNumber;
    }

    public void setItemSerialNumber(String itemSerialNumber) {
        this.itemSerialNumber = itemSerialNumber;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
