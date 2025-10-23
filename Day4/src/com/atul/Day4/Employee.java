package com.atul.Day4;
import java.util.*;
import java.io.*;

class Employee implements Serializable {
    private String empName;
    private int empID;
    private String empRole;
    
    // No-argument constructor
    public Employee() {
        this.empName = "Unknown";
        this.empID = 0;
        this.empRole = "Staff";
    }
    
    public Employee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.empRole = "Staff";
    }

    // Constructor with empID, empName, empRole
    public Employee(int empID, String empName, String empRole) {
        this.empID = empID;
        this.empName = empName;
        this.empRole = empRole;
    }
    
    // Getters and setters
    public int getEmpID() { return empID; }
    public String getEmpName() { return empName; }
    public String getEmpRole() { return empRole; }

    public void setEmpID(int empID) { this.empID = empID; }
    public void setEmpName(String empName) { this.empName = empName; }
    public void setEmpRole(String empRole) { this.empRole = empRole; }

    // Override toString
    public String toString() {
        return "ID: " + empID + ", Name: " + empName + ", Role: " + empRole;
    }
}