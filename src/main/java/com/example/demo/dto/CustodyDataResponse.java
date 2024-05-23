package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CustodyDataResponse {   //30 parametrs
    private int itemCustodyId;
    private int itemId;
    private int inventoryItemId;
    private String itemCode;
    private String itemDescription;
    private String itemSerial;
    private String barcodeId;
    private String referenceNumber;
    private String custodyById;
    private String custodyByUserName;
    private String custodyByFullName;
    private String custodyByEmailAddress;
    private String custodyByDepartment;
    private String custodyByUnit;
    private String custodyBySection;
    private String custodyByLocation;
    private int custodyByDepartmentId;
    private int custodyByUnitId;
    private int custodyBySectionId;
    private int custodyByLocationId;
    private String custodyByAssistantId;
    private String custodyByReportsTo;
    private Date custodyOn;
    private Date endedOn;
    private String requestType;
    private String locationName;
    private String categoryName;
    private String barcodeNumber;
    private String iteamSerialNumber;
    private String itemTypeName;


    public CustodyDataResponse(int itemCustodyId, int itemId, int inventoryItemId, String itemCode, String itemDescription, String itemSerial, String barcodeId, String referenceNumber, String custodyById, String custodyByUserName, String custodyByFullName, String custodyByEmailAddress, String custodyByDepartment, String custodyByUnit, String custodyBySection, String custodyByLocation, int custodyByDepartmentId, int custodyByUnitId, int custodyBySectionId, int custodyByLocationId, String custodyByAssistantId, String custodyByReportsTo, Date custodyOn, Date endedOn, String requestType, String locationName, String categoryName, String barcodeNumber, String iteamSerialNumber, String itemTypeName) {
        this.itemCustodyId = itemCustodyId;
        this.itemId = itemId;
        this.inventoryItemId = inventoryItemId;
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.itemSerial = itemSerial;
        this.barcodeId = barcodeId;
        this.referenceNumber = referenceNumber;
        this.custodyById = custodyById;
        this.custodyByUserName = custodyByUserName;
        this.custodyByFullName = custodyByFullName;
        this.custodyByEmailAddress = custodyByEmailAddress;
        this.custodyByDepartment = custodyByDepartment;
        this.custodyByUnit = custodyByUnit;
        this.custodyBySection = custodyBySection;
        this.custodyByLocation = custodyByLocation;
        this.custodyByDepartmentId = custodyByDepartmentId;
        this.custodyByUnitId = custodyByUnitId;
        this.custodyBySectionId = custodyBySectionId;
        this.custodyByLocationId = custodyByLocationId;
        this.custodyByAssistantId = custodyByAssistantId;
        this.custodyByReportsTo = custodyByReportsTo;
        this.custodyOn = custodyOn;
        this.endedOn = endedOn;
        this.requestType = requestType;
        this.locationName = locationName;
        this.categoryName = categoryName;
        this.barcodeNumber = barcodeNumber;
        this.iteamSerialNumber = iteamSerialNumber;
        this.itemTypeName = itemTypeName;
    }

    public CustodyDataResponse() {
    }

    public int getItemCustodyId() {
        return itemCustodyId;
    }

    public void setItemCustodyId(int itemCustodyId) {
        this.itemCustodyId = itemCustodyId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    public String getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(String barcodeId) {
        this.barcodeId = barcodeId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getCustodyById() {
        return custodyById;
    }

    public void setCustodyById(String custodyById) {
        this.custodyById = custodyById;
    }

    public String getCustodyByUserName() {
        return custodyByUserName;
    }

    public void setCustodyByUserName(String custodyByUserName) {
        this.custodyByUserName = custodyByUserName;
    }

    public String getCustodyByFullName() {
        return custodyByFullName;
    }

    public void setCustodyByFullName(String custodyByFullName) {
        this.custodyByFullName = custodyByFullName;
    }

    public String getCustodyByEmailAddress() {
        return custodyByEmailAddress;
    }

    public void setCustodyByEmailAddress(String custodyByEmailAddress) {
        this.custodyByEmailAddress = custodyByEmailAddress;
    }

    public String getCustodyByDepartment() {
        return custodyByDepartment;
    }

    public void setCustodyByDepartment(String custodyByDepartment) {
        this.custodyByDepartment = custodyByDepartment;
    }

    public String getCustodyByUnit() {
        return custodyByUnit;
    }

    public void setCustodyByUnit(String custodyByUnit) {
        this.custodyByUnit = custodyByUnit;
    }

    public String getCustodyBySection() {
        return custodyBySection;
    }

    public void setCustodyBySection(String custodyBySection) {
        this.custodyBySection = custodyBySection;
    }

    public String getCustodyByLocation() {
        return custodyByLocation;
    }

    public void setCustodyByLocation(String custodyByLocation) {
        this.custodyByLocation = custodyByLocation;
    }

    public int getCustodyByDepartmentId() {
        return custodyByDepartmentId;
    }

    public void setCustodyByDepartmentId(int custodyByDepartmentId) {
        this.custodyByDepartmentId = custodyByDepartmentId;
    }

    public int getCustodyByUnitId() {
        return custodyByUnitId;
    }

    public void setCustodyByUnitId(int custodyByUnitId) {
        this.custodyByUnitId = custodyByUnitId;
    }

    public int getCustodyBySectionId() {
        return custodyBySectionId;
    }

    public void setCustodyBySectionId(int custodyBySectionId) {
        this.custodyBySectionId = custodyBySectionId;
    }

    public int getCustodyByLocationId() {
        return custodyByLocationId;
    }

    public void setCustodyByLocationId(int custodyByLocationId) {
        this.custodyByLocationId = custodyByLocationId;
    }

    public String getCustodyByAssistantId() {
        return custodyByAssistantId;
    }

    public void setCustodyByAssistantId(String custodyByAssistantId) {
        this.custodyByAssistantId = custodyByAssistantId;
    }

    public String getCustodyByReportsTo() {
        return custodyByReportsTo;
    }

    public void setCustodyByReportsTo(String custodyByReportsTo) {
        this.custodyByReportsTo = custodyByReportsTo;
    }

    public Date getCustodyOn() {
        return custodyOn;
    }

    public void setCustodyOn(Date custodyOn) {
        this.custodyOn = custodyOn;
    }

    public Date getEndedOn() {
        return endedOn;
    }

    public void setEndedOn(Date endedOn) {
        this.endedOn = endedOn;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
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

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }
}
