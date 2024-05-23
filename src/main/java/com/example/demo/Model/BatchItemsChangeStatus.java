package com.example.demo.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BatchItemsChangeStatus")
public class BatchItemsChangeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BatchNumber")
    private int batchNumber;


    @Column(name = "ItemSerial")
    private String itemSerial;

    @Column(name = "Reference")
    private String reference;

    @Column(name = "ItemCode")
    private String itemCode;

    @Column(name = "CustodyItemEndDate")
    @Temporal(TemporalType.DATE)
    private Date custodyItemEndDate;

    @Column(name = "NewItemStatus")
    private String newItemStatus;

    @Column(name = "CustodyBy")
    private String custodyBy;

    @Column(name = "RequestType")
    private String requestType;


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

    public String getItemSerial() {
        return itemSerial;
    }

    public void setItemSerial(String itemSerial) {
        this.itemSerial = itemSerial;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Date getCustodyItemEndDate() {
        return custodyItemEndDate;
    }

    public void setCustodyItemEndDate(Date custodyItemEndDate) {
        this.custodyItemEndDate = custodyItemEndDate;
    }

    public String getNewItemStatus() {
        return newItemStatus;
    }

    public void setNewItemStatus(String newItemStatus) {
        this.newItemStatus = newItemStatus;
    }

    public String getCustodyBy() {
        return custodyBy;
    }

    public void setCustodyBy(String custodyBy) {
        this.custodyBy = custodyBy;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BatchItemsChangeStatus() {
    }

    public BatchItemsChangeStatus(int batchNumber, String itemSerial, String reference, String itemCode, Date custodyItemEndDate, String newItemStatus, String custodyBy, String requestType, String barcodeNumber, String itemSerialNumber, String itemType, boolean pending, String errorCode, String errorDescription, int id) {
        this.batchNumber = batchNumber;
        this.itemSerial = itemSerial;
        this.reference = reference;
        this.itemCode = itemCode;
        this.custodyItemEndDate = custodyItemEndDate;
        this.newItemStatus = newItemStatus;
        this.custodyBy = custodyBy;
        this.requestType = requestType;
        this.barcodeNumber = barcodeNumber;
        this.itemSerialNumber = itemSerialNumber;
        this.itemType = itemType;
        this.pending = pending;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.id = id;
    }
}
