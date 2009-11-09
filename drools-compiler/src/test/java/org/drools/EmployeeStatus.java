package org.drools;

import java.util.Date;

public class EmployeeStatus {
    
    private String employeeId;
    private String status;
    private Date startDate;
    private Date endDate;
    
    public EmployeeStatus() {
        super();
    }
    
    public EmployeeStatus(String employeeId,
                          String status,
                          Date startDate,
                          Date endDate) {
        super();
        this.employeeId = employeeId;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
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
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    @Override
    public String toString() {
        return "EmployeeStatus( id="+employeeId+" status="+status+" start="+startDate+" end="+endDate+" )";
    }    

}
