package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployee extends Employee{
    private float CommissionRate;
    private int TotalSales;

    public SalesEmployee(float commissionRate, int totalSales, Employee employee) {
        super(employee.getName(), employee.getAddress(), employee.getNiN(), employee.getIBAN(),
                employee.getSalary());
        super.setEmployeeId(employee.getEmployeeId());
        this.setCommissionRate(commissionRate);
        this.setTotalSales(totalSales);
    }

    public float getCommissionRate() { return CommissionRate; }
    public void setCommissionRate(float commissionRate) { CommissionRate = commissionRate; }

    public int getTotalSales() { return TotalSales; }
    public void setTotalSales(int totalSales) { TotalSales = totalSales; }

    @JsonCreator
    public SalesEmployee(
            @JsonProperty("employeeId") int employeeId,
            @JsonProperty("commissionRate") float commissionRate,
            @JsonProperty("totalSales") int totalSales)
    {
        super(employeeId);
        this.setCommissionRate(commissionRate);
        this.setTotalSales(totalSales);
    }

    @Override
    public float calcPay(){ // calculate monthly pay in pence
        return super.calcPay() + Math.round(CommissionRate * TotalSales);
    }

    @Override
    public String toString() {
        return String.format("Sales Employee %d: %,.2f%%. "
                        + "Monthly sales: £%d",
                this.getEmployeeId(), this.getCommissionRate(), this.getTotalSales());
    }

}
