package com.example.demo.Model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ItemsCustody", schema = "Custody")
public class ItemsCustody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemCustodyID")
    private int itemCustodyId;

    @Column(name = "ItemID")
    private int itemId;

    @Column(name = "CustodyBy")
    private String custodyBy;

    @Column(name = "CustodyOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date custodyOn;

    @Column(name = "ReferenceNumber")
    private String referenceNumber;

    @Column(name = "EndedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endedOn;

    @Column(name = "RequestType")
    private String requestType;

    public ItemsCustody() {
    }

    public ItemsCustody(int itemCustodyId, int itemId, String custodyBy, Date custodyOn, String referenceNumber, Date endedOn, String requestType) {
        this.itemCustodyId = itemCustodyId;
        this.itemId = itemId;
        this.custodyBy = custodyBy;
        this.custodyOn = custodyOn;
        this.referenceNumber = referenceNumber;
        this.endedOn = endedOn;
        this.requestType = requestType;
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

    public String getCustodyBy() {
        return custodyBy;
    }

    public void setCustodyBy(String custodyBy) {
        this.custodyBy = custodyBy;
    }

    public Date getCustodyOn() {
        return custodyOn;
    }

    public void setCustodyOn(Date custodyOn) {
        this.custodyOn = custodyOn;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
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
}
