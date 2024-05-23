package com.example.demo.Model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ItemsHistory", schema = "Custody")
public class ItemsHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemHistoryID")
    private int itemHistoryId;
    @Column(name = "ItemID")
    private Long itemId;

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

    @Column(name = "RequestType")
    private String requestType;

    public ItemsHistory() {
    }

    public ItemsHistory(int itemHistoryId, Long itemId, int itemStatusId, String itemStatusBy, Date itemStatusOn, Date itemDate, String itemRefNo, String requestType) {
        this.itemHistoryId = itemHistoryId;
        this.itemId = itemId;
        this.itemStatusId = itemStatusId;
        this.itemStatusBy = itemStatusBy;
        this.itemStatusOn = itemStatusOn;
        this.itemDate = itemDate;
        this.itemRefNo = itemRefNo;
        this.requestType = requestType;
    }

    public int getItemHistoryId() {
        return itemHistoryId;
    }

    public void setItemHistoryId(int itemHistoryId) {
        this.itemHistoryId = itemHistoryId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}
