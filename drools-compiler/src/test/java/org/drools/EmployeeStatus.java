package org.drools;

import java.util.Date;

public class EmployeeStatus {
    
    private String employeeId;
    private String status;
    private Date effDate;
    private Date expDate;
    
    public EmployeeStatus() {
        super();
    }
    
    public EmployeeStatus(String employeeId,
                          String status,
                          Date effDate,
                          Date expDate) {
        super();
        this.employeeId = employeeId;
        this.status = status;
        this.effDate = effDate;
        this.expDate = expDate;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getEffDate() {
        return effDate;
    }
    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }
    public Date getExpDate() {
        return expDate;
    }
    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }
    
    @Override
    public String toString() {
        return "EmployeeStatus( id="+employeeId+" status="+status+" effdt="+effDate+" expdt="+expDate+" )";
    }    

}
