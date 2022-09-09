package com.kainos.ea.controller;


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
@Path("/manager")

public class Manager {

    private static SalesEmployeeService salesEmployeeService;

    public Manager() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        salesEmployeeService = new SalesEmployeeService(new SalesEmployeeDao(), databaseConnector);
    }

    @GET
    @Path("/totalsales")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalSales() {
        try {
            return Response.ok(salesEmployeeService.getTotalSales()).build();
        } catch (SQLException | IOException e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }
}
