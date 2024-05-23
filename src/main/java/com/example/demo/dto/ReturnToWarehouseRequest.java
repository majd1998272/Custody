package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReturnToWarehouseRequest {
    private int itemId;
    private int statusId;
    private String statusBy;
    private Date date;
    private String refNo;
    private String requestType;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusBy() {
        return statusBy;
    }

    public void setStatusBy(String statusBy) {
        this.statusBy = statusBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public ReturnToWarehouseRequest() {
    }


    public ReturnToWarehouseRequest(int itemId, int statusId, String statusBy, Date date, String refNo, String requestType) {
        this.itemId = itemId;
        this.statusId = statusId;
        this.statusBy = statusBy;
        this.date = date;
        this.refNo = refNo;
        this.requestType = requestType;
    }
}
