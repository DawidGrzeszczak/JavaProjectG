package com.kainos.ea.controller;

import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.dao.SalesEmployeeDao;
import com.kainos.ea.model.InsertEmployee;
import com.kainos.ea.model.SalesEmployee;
import com.kainos.ea.services.EmployeeService;
import com.kainos.ea.services.SalesEmployeeService;
import com.kainos.ea.util.DatabaseConnector;
import io.swagger.annotations.Api;
import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.*;

@Api("JavaProjectG")
@Path("/hr")

public class HR {
    private static EmployeeService employeeService;
    private static SalesEmployeeService salesEmployeeService;

    public HR() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        employeeService = new EmployeeService(new EmployeeDao(), databaseConnector);
        salesEmployeeService = new SalesEmployeeService(new SalesEmployeeDao(), databaseConnector);
    }

    @GET
    @Path("/employee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees() {
        try {
            return Response.ok(employeeService.getEmployees()).build();
        } catch (SQLException | IOException e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }

    @GET
    @Path("/employee/{employeeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("employeeId") int employeeId) {
        try {
            return Response.status(HttpStatus.OK_200).entity(employeeService.getEmployee(employeeId)).build();
        } catch (SQLException | IOException e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }

    @GET
    @Path("/salesEmployee/{salesEmployeeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalesEmployee(@PathParam("salesEmployeeId") int salesEmployeeId){
        try {
            return Response.status(HttpStatus.OK_200).entity(salesEmployeeService.getSalesEmployee(salesEmployeeId)).build();
        } catch (SQLException | IOException e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }

    @POST
    @Path("/employee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(InsertEmployee employee) {
        try {
            int id = employeeService.insertEmployee(employee);
            return Response.status(HttpStatus.CREATED_201).entity(id).build();
        } catch (Exception e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }

    @POST
    @Path("/salesEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSalesEmployee(SalesEmployee salesEmployee) {
        try {
            salesEmployeeService.insertSalesEmployee(salesEmployee);
            return Response.status(HttpStatus.CREATED_201).build();
        } catch (SQLException | IOException e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }



}