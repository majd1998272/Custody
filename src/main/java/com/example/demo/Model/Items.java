package com.example.demo.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Items", schema = "Custody")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemID", nullable = false)
    private int itemId;
    @Column(name = "InventoryItemID")
    private int inventoryItemId;

    @Column(name = "ItemSerial")
    private String itemSerial;

    @Column(name = "ItemStatusID")
    private int itemStatusId;

    @Column(name = "ItemStatusBy")
    private String itemStatusBy;

    @Column(name = "ItemStatusOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itemStatusOn;

    @Column(name = "ItemDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itemDate;

    @Column(name = "ItemRefNo")
    private String itemRefNo;

    @Column(name = "IsDeleted", columnDefinition = "bit default 0")
    private boolean isDeleted;

    @Column(name = "RequestType")
    private String requestType;

    @Column(name = "BarcodeID")
    private String barcodeId;

    @Column(name = "LocationCode")
    private String locationCode;

    @Column(name = "CategoryId")
    private Integer categoryId;

    @Column(name = "BarcodeNumber")
    private String barcodeNumber;

    @Column(name = "IteamSerialNumber")
    private String itemSerialNumber;

    @Column(name = "ItemTypeID")
    private Integer itemTypeId;
    @Column(name = "Temporary")
    private Boolean temporary;

    public Items(int itemId, int inventoryItemId, String itemSerial, int itemStatusId, String itemStatusBy, Date itemStatusOn, Date itemDate, String itemRefNo, boolean isDeleted, String requestType, String barcodeId, String locationCode, int categoryId, String barcodeNumber, String itemSerialNumber, int itemTypeId, Boolean temporary) {
        this.itemId = itemId;
        this.inventoryItemId = inventoryItemId;
        this.itemSerial = itemSerial;
        this.itemStatusId = itemStatusId;
        this.itemStatusBy = itemStatusBy;
        this.itemStatusOn = itemStatusOn;
        this.itemDate = itemDate;
        this.itemRefNo = itemRefNo;
        this.isDeleted = isDeleted;
        this.requestType = requestType;
        this.barcodeId = barcodeId;
        this.locationCode = locationCode;
        this.categoryId = categoryId;
        this.barcodeNumber = barcodeNumber;
        this.itemSerialNumber = itemSerialNumber;
        this.itemTypeId = itemTypeId;
        this.temporary = temporary;
    }

    public Items() {
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

    public String getItemStatusBy() {
        return itemStatusBy;
    }

    public void setItemStatusBy(String itemStatusBy) {
        this.itemStatusBy = itemStatusBy;
    }

    public Date getItemStatusOn() {
        return itemStatusOn;
    }

    public void setItemStatusOn(Date itemStatusOn) {
        this.itemStatusOn = itemStatusOn;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public Boolean getTemporary() {
        return temporary;
    }

    public void setTemporary(Boolean temporary) {
        this.temporary = temporary;
    }
}


