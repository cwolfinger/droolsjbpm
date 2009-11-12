package org.drools;

import java.util.Date;

public class Coverage {
    
    private String employeeId;
    private String type;
    private Date effDate;
    private Date expDate;
    
    public Coverage() {
        super();
    }
    
    public Coverage(String employeeId,
                    String type,
                    Date effDate,
                    Date end) {
        super();
        this.employeeId = employeeId;
        this.type = type;
        this.effDate = effDate;
        this.expDate = end;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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
        return "Coverage( id="+employeeId+" type="+type+" effdt="+effDate+" expdt="+expDate+" )";
    }

}
