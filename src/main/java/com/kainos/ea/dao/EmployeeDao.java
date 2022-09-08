package com.kainos.ea.dao;

import com.kainos.ea.model.Employee;
import com.kainos.ea.model.InsertEmployee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public int insertEmployee(InsertEmployee emp1, Connection c) throws SQLException {
        String insertEmployeeQuery = "INSERT INTO Employees (Name, Address, NIN, IBAN, Salary) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = c.prepareStatement(insertEmployeeQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setString(1, emp1.getName());
        preparedStmt.setString(2, emp1.getAddress());
        preparedStmt.setString(3, emp1.getNiN());
        preparedStmt.setString(4, emp1.getIBAN());
        preparedStmt.setFloat(5, emp1.getSalary());

        int affectedRows = preparedStmt.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }

        int empNo = 0;

        try (ResultSet rs = preparedStmt.getGeneratedKeys()) {
            if (rs.next()) {
                empNo = rs.getInt(1);
            }
        }

        return empNo;
    }

    public Employee getEmployee(int employeeId, Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT * FROM Employees WHERE EmployeeId = " + employeeId + ";");


        while (rs.next()) {
            Employee employee = new Employee(
                    rs.getString("Name"),
                    rs.getString("Address"),
                    rs.getString("NIN"),
                    rs.getString("IBAN"),
                    rs.getFloat("Salary")
            );

            employee.setEmployeeId(employeeId);
            return employee;
        }
        return null;
    }

    public List<Employee> getEmployees(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT * FROM Employees;");

        List<Employee> emps = new ArrayList<>();

        while (rs.next()) {
            Employee emp = new Employee(
                    rs.getString("Name"),
                    rs.getString("Address"),
                    rs.getString("NIN"),
                    rs.getString("IBAN"),
                    rs.getFloat("Salary")
            );
            emp.setEmployeeId(rs.getInt("EmployeeId"));
            emps.add(emp);
        }
        return emps;
    }
}
