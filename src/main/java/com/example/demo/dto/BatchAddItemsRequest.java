package com.example.demo.dto;


import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Data

public class    BatchAddItemsRequest { //12 parameters    but stockSerialId not found in BatchAddItems Table the found is BarcodeId     "note": stockSerialId is the same of BarcodeId

    private String itemCode;
    private String itemSerial;
    private String stockSerialID;
    private String locationCode;
    private String referenceNo;
    private Date newStatusDate;
    private String employeeId;
    private String requestType;
    private String category;
    private String barcodeNumber;
    private String itemSerialNumber;
    private String itemType;


    // Constructors, getters, and setters

    public BatchAddItemsRequest() {
        // Default constructor
    }

    public BatchAddItemsRequest(String itemCode, String itemSerial, String locationCode,
                                String referenceNo, String employeeId, Date newStatusDate, String requestType,
                                String category, String barcodeNumber, String itemSerialNumber, String itemType, String stockSerialID) {
        this.itemCode = itemCode;
        this.itemSerial = itemSerial;
        this.stockSerialID = stockSerialID;
        this.locationCode = locationCode;
        this.referenceNo = referenceNo;
        this.employeeId = employeeId;
        this.newStatusDate = newStatusDate;
        this.requestType = requestType;
        this.category = category;
        this.barcodeNumber = barcodeNumber;
        this.itemSerialNumber = itemSerialNumber;
        this.itemType = itemType;

    }


    // Getters and setters for each field


    public String getStockSerialID() {
        return stockSerialID;
    }

    public void setStockSerialID(String stockSerialID) {
       this. stockSerialID = stockSerialID;
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


    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getNewStatusDate() {
        return newStatusDate;
    }

    public void setNewStatusDate(Date newStatusDate) {
        this.newStatusDate = newStatusDate;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
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
