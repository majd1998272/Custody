package com.example.demo.Model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BatchAddItems")
public class BatchAddItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BatchNumber")
    private int batchNumber;

    @Column(name = "ItemCode")
    private String itemCode;

    @Column(name = "ItemSerial")
    private String itemSerial;

    @Column(name = "BarcodId")
    private String barcodId;

    @Column(name = "LocationCode")
    private String locationCode;

    @Column(name = "ReferenceNo")
    private String referenceNo;

    @Column(name = "EmployeeId")
    private String employeeId;

    @Column(name = "RequestType")
    private String requestType;

    @Column(name = "NewStatusDate")
    @Temporal(TemporalType.DATE)
    private Date newStatusDate;

    @Column(name = "Category")
    private String category;

    @Column(name = "BarcodeNumber")
    private String barcodeNumber;

    @Column(name = "ItemSerialNumber")
    private String itemSerialNumber;

    @Column(name = "ItemType")
    private String itemType;

    @Column(name = "Pending", columnDefinition = "bit default 0")
    private boolean pending;

    @Column(name = "ErrorCode")
    private String errorCode;

    @Column(name = "ErrorDescription")
    private String errorDescription;

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
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

    public String getBarcodId() {
        return barcodId;
    }

    public void setBarcodId(String barcodId) {
        this.barcodId = barcodId;
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

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Date getNewStatusDate() {
        return newStatusDate;
    }

    public void setNewStatusDate(Date newStatusDate) {
        this.newStatusDate = newStatusDate;
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

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
