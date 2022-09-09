package com.kainos.ea.dao;

import com.kainos.ea.model.Employee;
import com.kainos.ea.model.SalesEmployee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesEmployeeDao {
    public void insertSalesEmployee(SalesEmployee sEmp1, Connection c) throws SQLException {
        String insertSalesEmployeeQuery = "INSERT INTO SalesEmployees (EmployeeId, CommissionRate, TotalValue) VALUES (?, ?, ?)";
        PreparedStatement preparedStmt = c.prepareStatement(insertSalesEmployeeQuery);
        preparedStmt = c.prepareStatement(insertSalesEmployeeQuery);
        preparedStmt.setInt(1, sEmp1.getEmployeeId());
        preparedStmt.setFloat(2, sEmp1.getCommissionRate());
        preparedStmt.setInt(3, sEmp1.getTotalSales());
        preparedStmt.executeUpdate();
    }

    public SalesEmployee getSalesEmployee(int employeeId, Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT * FROM SalesEmployees WHERE EmployeeId = " + employeeId + ";");


        while (rs.next()) {
            return new SalesEmployee(
                    rs.getInt("EmployeeId"),
                    rs.getFloat("CommissionRate"),
                    rs.getInt("TotalValue"));
        }
        return null;
    }

    public SalesEmployee getTotalSales(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT * FROM SalesEmployees WHERE TotalValue*CommissionRate = (SELECT MAX(TotalValue * CommissionRate FROM SalesEmployees);");

        while (rs.next()) {
            return new SalesEmployee(
                    rs.getInt("EmployeeId"),
                    rs.getFloat("CommissionRate"),
                    rs.getInt("TotalValue"));
        }
        return null;
    }
}
