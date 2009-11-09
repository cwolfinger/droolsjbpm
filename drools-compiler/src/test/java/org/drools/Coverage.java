package org.drools;

import java.util.Date;

public class Coverage {
    
    private String employeeId;
    private String type;
    private Date start;
    private Date end;
    
    public Coverage() {
        super();
    }
    
    public Coverage(String employeeId,
                    String type,
                    Date start,
                    Date end) {
        super();
        this.employeeId = employeeId;
        this.type = type;
        this.start = start;
        this.end = end;
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
    public Date getStart() {
        return start;
    }
    public void setStart(Date start) {
        this.start = start;
    }
    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }
    
    @Override
    public String toString() {
        return "Coverage( id="+employeeId+" type="+type+" start="+start+" end="+end+" )";
    }

}
