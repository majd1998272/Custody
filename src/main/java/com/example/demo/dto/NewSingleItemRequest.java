package com.example.demo.dto;

import lombok.Data;

@Data
public class NewSingleItemRequest { // 11 parameters   reference is same as  StockSerialId
        private String itemCode;
        private String itemSerial;
        private int itemStatusID;
        private String itemStatusBy;
        private String barcodeID;
        private String reference;
        private String locationCode;
        private int categoryId;
        private int itemTypeId;
        private String barcodeNumber;
        private String itemSerialNumber;

    public NewSingleItemRequest(String itemCode, String itemSerial, int itemStatusID, String itemStatusBy, String barcodeID, String reference, String locationCode, int categoryId, int itemTypeId, String barcodeNumber, String itemSerialNumber) {
        this.itemCode = itemCode;
        this.itemSerial = itemSerial;
        this.itemStatusID = itemStatusID;
        this.itemStatusBy = itemStatusBy;
        this.barcodeID = barcodeID;
        this.reference = reference;
        this.locationCode = locationCode;
        this.categoryId = categoryId;
        this.itemTypeId = itemTypeId;
        this.barcodeNumber = barcodeNumber;
        this.itemSerialNumber = itemSerialNumber;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemSerial() {
        return itemSerial;
    }

    public void setItemSerial(String itemSerial) {
        this.itemSerial = itemSerial;
    }

    public int getItemStatusID() {
        return itemStatusID;
    }

    public void setItemStatusID(int itemStatusID) {
        this.itemStatusID = itemStatusID;
    }

    public String getItemStatusBy() {
        return itemStatusBy;
    }

    public void setItemStatusBy(String itemStatusBy) {
        this.itemStatusBy = itemStatusBy;
    }

    public String getBarcodeID() {
        return barcodeID;
    }

    public void setBarcodeID(String barcodeID) {
        this.barcodeID = barcodeID;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
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

    public NewSingleItemRequest() {
    }
}
