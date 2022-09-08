package com.kainos.ea.controller;

import com.kainos.ea.services.EmployeeService;
import com.kainos.ea.services.SalesEmployeeService;
import io.swagger.annotations.Api;

import javax.ws.rs.Path;

@Api("JavaProjectG")
@Path("/finance")
public class FinanceMember {
    private static EmployeeService employeeService;
    private static SalesEmployeeService salesEmployeeService;

    public FinanceMember() {

    }
}
