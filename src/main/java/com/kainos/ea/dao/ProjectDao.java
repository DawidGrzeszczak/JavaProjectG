package com.kainos.ea.dao;

import com.kainos.ea.model.Employee;
import com.kainos.ea.model.Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {



    public Project getProject(int projectId, Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT * FROM Projects WHERE ProjectId = " + projectId + ";");


        while (rs.next()) {
            Project proj = new Project(
                    rs.getInt("EmployeeId"),
                    rs.getString("Name")
            );

            proj.setProjectId(projectId);
            return proj;
        }
        return null;
    }
    public List<Project> getProjects(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT * FROM Projects;");

        List<Project> projs = new ArrayList<>();

        while (rs.next()) {
            Project proj = new Project(
                    rs.getInt("EmployeeId"),
                    rs.getString("Name")
            );
            proj.setProjectId(rs.getInt("ProjectId"));
            projs.add(proj);
        }
        return projs;
    }
}
