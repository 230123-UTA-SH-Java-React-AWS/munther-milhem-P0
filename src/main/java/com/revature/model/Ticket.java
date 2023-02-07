package com.revature.model;



public class Ticket {

    private String empId;
    private int amount;
    boolean status;
    private String description;

    public Ticket(){
        empId = null;
        amount = 0;
        status = "pending" != null;

    }


    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    ;
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    
    public String getDescription() {
        return description;
    }
    
    
}
