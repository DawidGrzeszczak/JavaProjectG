package com.kainos.ea.controller;

import com.kainos.ea.model.SalesEmployee;
import com.kainos.ea.services.EmployeeService;
import com.kainos.ea.services.SalesEmployeeService;
import io.swagger.annotations.Api;
import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

@Api("JavaProjectG")
@Path("/talentmanager")
public class TalentManager {
    private static EmployeeService employeeService;
    private static SalesEmployeeService salesEmployeeService;

    public TalentManager() {


    }

    @POST
    @Path("/project")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProject(SalesEmployee salesEmployee) {
        try {
            salesEmployeeService.insertSalesEmployee(salesEmployee);
            return Response.status(HttpStatus.CREATED_201).build();
        } catch (SQLException | IOException e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }
}
