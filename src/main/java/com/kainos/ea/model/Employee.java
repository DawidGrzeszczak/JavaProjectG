package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Employee implements Comparable<Employee>, Serializable {
    private int EmployeeId;
    private String Name;
    private String Address;
    private String NiN;
    private String IBAN;
    private float Salary;


    public int getEmployeeId() { return EmployeeId; }
    public void setEmployeeId(int employeeId) { EmployeeId = employeeId; }

    public String getName() { return Name; }
    public void setName(String name) { Name = name; }

    public String getAddress() { return Address; }
    public void setAddress(String address) { Address = address; }

    public String getNiN() { return NiN; }
    public void setNiN(String niN) { NiN = niN; }

    public String getIBAN() { return IBAN; }
    public void setIBAN(String IBAN) { this.IBAN = IBAN; }

    public float getSalary() { return Salary; }
    public void setSalary(float salary) { Salary = salary; }

    public Employee(int employeeId) {
        setEmployeeId(employeeId);
    }

    @JsonCreator
    public Employee(
            @JsonProperty("name") String name,
            @JsonProperty("address") String address,
            @JsonProperty("NiN") String NiN,
            @JsonProperty("IBAN") String IBAN,
            @JsonProperty("salary") float salary)
    {
        this.setName(name);
        this.setAddress(address);
        this.setNiN(NiN);
        this.setIBAN(IBAN);
        this.setSalary(salary);
    }

    public float calcPay(){
        return getSalary() / 12;
    }
    public double getNetPay() {
        return Salary*0.75;
    }
    public double getNetPay(double CommissionRate, int TotalSales) {
        return this.Salary*0.75 + TotalSales*CommissionRate;
    }
    @Override
    public String toString() {
        return String.format("Employee %d: %s, £%,.2f. "
                        + "Monthly gross pay: £%,.2f.",
                this.getEmployeeId(), this.getName(), this.getSalary()/100.0, this.calcPay()/100.0);
    }

    @Override
    public int compareTo(Employee o) {
        return getSalary() > o.getSalary() ? 1 : -1;
    }
}
