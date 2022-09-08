package com.kainos.ea.model;

public class Employee {
    private int ID;
    private String Name;
    private String Address;
    private int NiN;
    private int IBAN;
    private double Salary;
    private static final double TAX  = 1.33;

    public double getGrossPay() {
        return this.Salary*TAX;
    }

    public double getGrossPay(double CommissionRate, int TotalSales) {
        return this.Salary*TAX + TotalSales*CommissionRate;
    }
}
