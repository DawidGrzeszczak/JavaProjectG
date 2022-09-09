package com.kainos.ea.controller;

import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.dao.ProjectDao;
import com.kainos.ea.model.SalesEmployee;
import com.kainos.ea.services.EmployeeService;
import com.kainos.ea.services.ProjectService;
import com.kainos.ea.services.SalesEmployeeService;
import com.kainos.ea.util.DatabaseConnector;
import io.swagger.annotations.Api;
import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

@Api("JavaProjectG")
@Path("/talentmanager")
public class TalentManager {
    private static ProjectService projectService;

    public TalentManager() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        projectService = new ProjectService(new ProjectDao(), databaseConnector);
    }

    @GET
    @Path("/projects")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjects() {
        try {
            return Response.ok(projectService.getProjects()).build();
        } catch (SQLException | IOException e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }

    @GET
    @Path("/project/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProject(@PathParam("projectId") int projectId) {
        try {
            return Response.status(HttpStatus.OK_200).entity(projectService.getProject(projectId)).build();
        } catch (SQLException | IOException e) {
            System.out.println(e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }
}
