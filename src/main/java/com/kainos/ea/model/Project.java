package com.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {
    private int ProjectId;
    private int EmployeeId;
    private String Name;

    public Project(String name) {
        setName(name);
    }

    public Project(int employeeId, String name) {
        setEmployeeId(employeeId);
        setName(name);
    }

    public int getProjectId() { return ProjectId; }
    public void setProjectId(int projectId) { ProjectId = projectId; }

    public int getEmployeeId() { return EmployeeId; }
    public void setEmployeeId(int employeeId) { EmployeeId = employeeId; }

    public String getName() { return Name; }
    public void setName(String name) { Name = name; }

    @JsonCreator
    public Project(
            @JsonProperty("Name") String name,
            @JsonProperty("employeeId") int employeeId)
    {
        this.setEmployeeId(employeeId);
        this.setName(name);
    }
}
