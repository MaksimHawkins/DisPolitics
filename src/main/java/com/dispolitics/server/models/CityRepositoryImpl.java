package com.dispolitics.server.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class CityRepositoryImpl implements CityRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<City> getAllCities() {
        String sql = "SELECT * FROM city;";

        try (Connection con = sql2o.open()){
            return con.createQuery(sql).executeAndFetch(City.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
