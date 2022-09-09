package com.kainos.ea.services;

import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.model.Employee;
import com.kainos.ea.model.InsertEmployee;
import com.kainos.ea.util.DatabaseConnector;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    public EmployeeDao employeeDao;
    public DatabaseConnector databaseConnector;

    public EmployeeService(EmployeeDao employeeDao, DatabaseConnector databaseConnector) {
        this.employeeDao = employeeDao;
        this.databaseConnector = databaseConnector;
    }

    public int insertEmployee(InsertEmployee employee) throws SQLException, IOException {
        return employeeDao.insertEmployee(employee, databaseConnector.getConnection());
    }

    public Employee getEmployee(int employeeId) throws SQLException, IOException {
        return employeeDao.getEmployee(employeeId, databaseConnector.getConnection());
    }

    public List<Employee> getEmployees() throws SQLException, IOException {
        return employeeDao.getEmployees(databaseConnector.getConnection());
    }

    public List<Employee> getGrossPay() throws SQLException, IOException {
        return employeeDao.getGrossPay(databaseConnector.getConnection());
    }
}
