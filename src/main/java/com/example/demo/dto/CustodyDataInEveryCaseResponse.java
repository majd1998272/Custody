package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data

public class CustodyDataInEveryCaseResponse {//22 parameters
    private int itemId;
    private String custodian;
    private int inventoryItemId;
    private String itemCode;
    private String itemDescription;
    private String itemSerial;
    private int itemStatusId;
    private String itemStatus;

    public CustodyDataInEveryCaseResponse() {
    }

    private Date itemDate;
    private String itemRefNo;
    private String itemStatusBy;
    private String fullName;
    private Date itemStatusOn;
    private boolean isDeleted;
    private String requestType;
    private String barcodeId;
    private String locationCode;
    private String locationName;
    private String categoryName;
    private String itemTypeName;
    private String barcodeNumber;
    private String iteamSerialNumber;

    public CustodyDataInEveryCaseResponse(int itemId, String custodian, int inventoryItemId, String itemCode, String itemDescription, String itemSerial, int itemStatusId, String itemStatus, Date itemDate, String itemRefNo, String itemStatusBy, String fullName, Date itemStatusOn, boolean isDeleted, String requestType, String barcodeId, String locationCode, String locationName, String categoryName, String itemTypeName, String barcodeNumber, String iteamSerialNumber) {
        this.itemId = itemId;
        this.custodian = custodian;
        this.inventoryItemId = inventoryItemId;
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.itemSerial = itemSerial;
        this.itemStatusId = itemStatusId;
        this.itemStatus = itemStatus;
        this.itemDate = itemDate;
        this.itemRefNo = itemRefNo;
        this.itemStatusBy = itemStatusBy;
        this.fullName = fullName;
        this.itemStatusOn = itemStatusOn;
        this.isDeleted = isDeleted;
        this.requestType = requestType;
        this.barcodeId = barcodeId;
        this.locationCode = locationCode;
        this.locationName = locationName;
        this.categoryName = categoryName;
        this.itemTypeName = itemTypeName;
        this.barcodeNumber = barcodeNumber;
        this.iteamSerialNumber = iteamSerialNumber;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getCustodian() {
        return custodian;
    }

    public void setCustodian(String custodian) {
        this.custodian = custodian;
    }

    public int getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(int inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemSerial() {
        return itemSerial;
    }

    public void setItemSerial(String itemSerial) {
        this.itemSerial = itemSerial;
    }

    public int getItemStatusId() {
        return itemStatusId;
    }

    public void setItemStatusId(int itemStatusId) {
        this.itemStatusId = itemStatusId;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Date getItemDate() {
        return itemDate;
    }

    public void setItemDate(Date itemDate) {
        this.itemDate = itemDate;
    }

    public String getItemRefNo() {
        return itemRefNo;
    }

    public void setItemRefNo(String itemRefNo) {
        this.itemRefNo = itemRefNo;
    }

    public String getItemStatusBy() {
        return itemStatusBy;
    }

    public void setItemStatusBy(String itemStatusBy) {
        this.itemStatusBy = itemStatusBy;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getItemStatusOn() {
        return itemStatusOn;
    }

    public void setItemStatusOn(Date itemStatusOn) {
        this.itemStatusOn = itemStatusOn;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(String barcodeId) {
        this.barcodeId = barcodeId;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    public String getBarcodeNumber() {
        return barcodeNumber;
    }

    public void setBarcodeNumber(String barcodeNumber) {
        this.barcodeNumber = barcodeNumber;
    }

    public String getIteamSerialNumber() {
        return iteamSerialNumber;
    }

    public void setIteamSerialNumber(String iteamSerialNumber) {
        this.iteamSerialNumber = iteamSerialNumber;
    }
}
