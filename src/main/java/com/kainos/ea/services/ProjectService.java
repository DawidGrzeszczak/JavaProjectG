package com.kainos.ea.services;

import com.kainos.ea.dao.ProjectDao;
import com.kainos.ea.model.Employee;
import com.kainos.ea.model.Project;
import com.kainos.ea.util.DatabaseConnector;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    public ProjectDao projectDao;
    public DatabaseConnector databaseConnector;

    public ProjectService(ProjectDao projectDao, DatabaseConnector databaseConnector) {
        this.projectDao = projectDao;
        this.databaseConnector = databaseConnector;
    }

    public List<Project> getProjects() throws SQLException, IOException {
        return projectDao.getProjects(databaseConnector.getConnection());
    }
}
