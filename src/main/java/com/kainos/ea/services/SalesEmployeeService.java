package com.kainos.ea.services;

import com.kainos.ea.dao.SalesEmployeeDao;
import com.kainos.ea.model.Employee;
import com.kainos.ea.model.SalesEmployee;
import com.kainos.ea.util.DatabaseConnector;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SalesEmployeeService {
    public SalesEmployeeDao salesEmployeeDao;
    public DatabaseConnector databaseConnector;

    public SalesEmployeeService(SalesEmployeeDao salesEmployeeDao, DatabaseConnector databaseConnector) {
        this.salesEmployeeDao = salesEmployeeDao;
        this.databaseConnector = databaseConnector;
    }

    public void insertSalesEmployee(SalesEmployee sEmp1) throws SQLException, IOException {
        salesEmployeeDao.insertSalesEmployee(sEmp1, databaseConnector.getConnection());
    }

    public SalesEmployee getSalesEmployee(int employeeId) throws SQLException, IOException {
        return salesEmployeeDao.getSalesEmployee(employeeId, databaseConnector.getConnection());
    }

    public SalesEmployee getTotalSales() throws SQLException, IOException {
        return salesEmployeeDao.getTotalSales(databaseConnector.getConnection());
    }
}
