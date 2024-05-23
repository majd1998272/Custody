package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BatchItemsChangeStatusRequest { // 10 parameters  "note" employeeId is same as custodyBy in table BatchItemsChangeStatus   +  itemEndDate is same as CustodyItemEndDate
    private String itemCode;
    private String itemSerial;
    private String newItemStatus;
    private Date itemEndDate;
    private String reference;
    private String employeeId;
    private String requestType;
    private String barcodeNumber;
    private String itemSerialNumber;
    private String itemType;

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

    public String getNewItemStatus() {
        return newItemStatus;
    }

    public void setNewItemStatus(String newItemStatus) {
        this.newItemStatus = newItemStatus;
    }

    public Date getItemEndDate() {
        return itemEndDate;
    }

    public void setItemEndDate(Date itemEndDate) {
        this.itemEndDate = itemEndDate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
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

    public BatchItemsChangeStatusRequest(String itemCode, String itemSerial, String newItemStatus, Date itemEndDate, String reference, String employeeId, String requestType, String barcodeNumber, String itemSerialNumber, String itemType) {
        this.itemCode = itemCode;
        this.itemSerial = itemSerial;
        this.newItemStatus = newItemStatus;
        this.itemEndDate = itemEndDate;
        this.reference = reference;
        this.employeeId = employeeId;
        this.requestType = requestType;
        this.barcodeNumber = barcodeNumber;
        this.itemSerialNumber = itemSerialNumber;
        this.itemType = itemType;
    }

    public BatchItemsChangeStatusRequest() {
    }
}
