package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Employee {
    private int EmployeeId;
    private String Name;

    public Employee(String name) {
        setName(name);
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

//    private String Address;
//    private int NiN;
//    private int IBAN;
//    private double Salary;
//    private static final double TAX  = 1.33;

//    public double getGrossPay() {
//        return this.Salary*TAX;
//    }
//
//    public double getGrossPay(double CommissionRate, int TotalSales) {
//        return this.Salary*TAX + TotalSales*CommissionRate;
//    }
}
