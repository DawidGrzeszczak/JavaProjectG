package com.kainos.ea.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kainos.ea.model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private int Id;
    private String Name;
//    private String Address;
//    private int NiN;
//    private int IBAN;
//    private double Salary;
//    private Boolean IsSalesEmp;

    public int getId() { return Id; }
    public String  getName() { return Name; }
//    public String  getAddress() { return Address; }
//    public int getNiN() { return NiN; }
//    public int getIBAN() { return IBAN; }
//    public double getSalary() { return Salary; }
//    public Boolean IsSalesEmp() { return IsSalesEmp; }

    public void setName(String name) { this.Name = name; }

    @JsonCreator
    public EmployeeService(
            @JsonProperty("name") String name
    )
    {
        this.setName(name);
    }

    public List<Employee> getEmployees(Connection c) throws SQLException {
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT * "
                        + "FROM Employees;");
        List<Employee> employees = new ArrayList<>();
        while (rs.next()) {
            Employee employee = new Employee(rs.getString("name"));
            employee.setEmployeeId(rs.getInt("employeeId"));
            employees.add(employee);
        }
        return employees;
    }

}
