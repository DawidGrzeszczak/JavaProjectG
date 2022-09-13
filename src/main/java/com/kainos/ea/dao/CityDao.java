package com.kainos.ea.dao;

import com.kainos.ea.model.City;
import com.kainos.ea.model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDao {
    public List<City> getCities(Connection c) throws SQLException {
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT * FROM world_KewinA.city where CountryCode = \"GBR\";");

        List<City> cities = new ArrayList<>();

        while (rs.next()) {
            City city = new City(
                    rs.getInt("ID"),
                    rs.getString("Name"),
                    rs.getString("CountryCode"),
                    rs.getString("District"),
                    rs.getInt("Population")
            );
            city.setID(rs.getInt("ID"));
            cities.add(city);
        }
        return cities;
    }
}
