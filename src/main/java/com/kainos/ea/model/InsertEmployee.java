package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InsertEmployee {
    private String Name;
    private String Address;
    private String NiN;
    private String IBAN;
    private float Salary;

    @JsonCreator
    public InsertEmployee(
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
}
