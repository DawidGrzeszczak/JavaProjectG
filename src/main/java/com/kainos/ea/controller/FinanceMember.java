package com.kainos.ea.controller;

import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.dao.SalesEmployeeDao;
import com.kainos.ea.services.EmployeeService;
import com.kainos.ea.services.SalesEmployeeService;
import com.kainos.ea.util.DatabaseConnector;
import io.swagger.annotations.Api;
import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

@Api("JavaProjectG")
@Path("/finance")
public class FinanceMember {
    private static EmployeeService employeeService;
    private static SalesEmployeeService salesEmployeeService;

    public FinanceMember() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        employeeService = new EmployeeService(new EmployeeDao(), databaseConnector);
        salesEmployeeService = new SalesEmployeeService(new SalesEmployeeDao(), databaseConnector);
    }

    @GET
    @Path("/grosspay")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGrossPay() {
        try {
            return Response.ok(employeeService.getGrossPay()).build();
        } catch (SQLException | IOException e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }
}
