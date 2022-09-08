package com.kainos.ea.controller;

import com.kainos.ea.model.Employee;
import com.kainos.ea.util.DatabaseConnector;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class HR {

    public static DatabaseConnector databaseConnector;

    public static void main(final String[] args) throws SQLException, IOException {
        try {
            Connection c = databaseConnector.getConnection();

            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT * from Employees");
            while (rs.next()) {
                // Retrieve by column name
                System.out.print(", First: " + rs.getString("name"));
            }



        }
        catch (SQLException e) {
            e.printStackTrace(); // Bad practice alert!
        }


    }
}