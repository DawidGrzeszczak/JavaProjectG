package com.kainos.ea.services;

import com.kainos.ea.dao.CityDao;
import com.kainos.ea.model.City;
import com.kainos.ea.model.Employee;
import com.kainos.ea.util.DatabaseConnector;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CityService {
    public CityDao cityDao;
    public DatabaseConnector databaseConnector;

    public CityService(CityDao cityDao, DatabaseConnector databaseConnector) {
        this.cityDao = cityDao;
        this.databaseConnector = databaseConnector;
    }

    public List<City> getCities() throws SQLException, IOException {
        return cityDao.getCities(databaseConnector.getConnection());
    }
}
