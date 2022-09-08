package com.kainos.ea.controller;

import com.kainos.ea.model.Employee;
import com.kainos.ea.resources.EmployeeService;
import com.kainos.ea.services.SalesEmployeeService;
import com.kainos.ea.util.DatabaseConnector;
import io.swagger.annotations.Api;
import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@Path("/api")
@Api("Engineering Academy Dropwizard API")

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
            e.printStackTrace();
        }
    }
}