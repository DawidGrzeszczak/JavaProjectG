package com.kainos.ea.model;

public class SalesEmployee extends Employee implements Comparable<SalesEmployee>{
    private double CommissionRate;
    private int TotalSales;

    @Override
    public int compareTo(SalesEmployee o) {
        return Float.compare(this.getTotalSales(), o.getTotalSales());
    }

    public int getTotalSales() {
        return TotalSales;
    }

    public void setTotalSales(int totalSales) {
        TotalSales = totalSales;
    }
}
