package com.example.demo.Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="Employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeId", nullable = false)
    private String employeeId;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Column(name = "Mobile")
    private String mobile;
    @Column(name = "AssistantId")
    private String assistantId;
    @Column(name = "JobId")
    private int jobId;
    @Column(name = "PositionId")
    private int positionId;
    @Column(name = "ReportsTo")
    private String reportsTo;
    @Column(name = "DepartmentId")
    private int departmentId;
    @Column(name = "UnitId")
    private int unitId;
    @Column(name = "SectionId")
    private int sectionId;
    @Column(name = "LocationId")
    private int locationId;
    @Column(name = "IsDeleted")
    private boolean isDeleted;
    @Column(name = "StrPositionId")
    private String strPositionId;
    @Column(name = "HireDate")
    private Date hireDate;
    @Column(name = "EndOfServiceOn")
    private Date endOfServiceOn;
    @Column(name = "ClosingBalance")
    private BigDecimal closingBalance;
    @Column(name = "ActualTerminationDate")
    private Date actualTerminationDate;
    @Column(name = "Qualification")
    private String qualification;
    @Column(name = "NationalityCode")
    private String nationalityCode;
    @Column(name = "Del")
    private boolean del;
    @Column(name = "SeqId")
    private int seqId;
    @Column(name = "IsVirtual")
    private boolean isVirtual;
    @Column(name = "IsDeletedVC")
    private boolean isDeletedVC;

    public Employees() {
    }

    public Employees(String employeeId, String userName, String firstName, String lastName, String emailAddress, String mobile, String assistantId, int jobId, int positionId, String reportsTo, int departmentId, int unitId, int sectionId, int locationId, boolean isDeleted, String strPositionId, Date hireDate, Date endOfServiceOn, BigDecimal closingBalance, Date actualTerminationDate, String qualification, String nationalityCode, boolean del, int seqId, boolean isVirtual, boolean isDeletedVC) {
        this.employeeId = employeeId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.mobile = mobile;
        this.assistantId = assistantId;
        this.jobId = jobId;
        this.positionId = positionId;
        this.reportsTo = reportsTo;
        this.departmentId = departmentId;
        this.unitId = unitId;
        this.sectionId = sectionId;
        this.locationId = locationId;
        this.isDeleted = isDeleted;
        this.strPositionId = strPositionId;
        this.hireDate = hireDate;
        this.endOfServiceOn = endOfServiceOn;
        this.closingBalance = closingBalance;
        this.actualTerminationDate = actualTerminationDate;
        this.qualification = qualification;
        this.nationalityCode = nationalityCode;
        this.del = del;
        this.seqId = seqId;
        this.isVirtual = isVirtual;
        this.isDeletedVC = isDeletedVC;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(String assistantId) {
        this.assistantId = assistantId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getStrPositionId() {
        return strPositionId;
    }

    public void setStrPositionId(String strPositionId) {
        this.strPositionId = strPositionId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getEndOfServiceOn() {
        return endOfServiceOn;
    }

    public void setEndOfServiceOn(Date endOfServiceOn) {
        this.endOfServiceOn = endOfServiceOn;
    }

    public BigDecimal getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(BigDecimal closingBalance) {
        this.closingBalance = closingBalance;
    }

    public Date getActualTerminationDate() {
        return actualTerminationDate;
    }

    public void setActualTerminationDate(Date actualTerminationDate) {
        this.actualTerminationDate = actualTerminationDate;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }

    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    public boolean isVirtual() {
        return isVirtual;
    }

    public void setVirtual(boolean virtual) {
        isVirtual = virtual;
    }

    public boolean isDeletedVC() {
        return isDeletedVC;
    }

    public void setDeletedVC(boolean deletedVC) {
        isDeletedVC = deletedVC;
    }
}
