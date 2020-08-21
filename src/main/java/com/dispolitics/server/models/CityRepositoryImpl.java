package com.dispolitics.server.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class CityRepositoryImpl implements CityRepository {

    private final Sql2o sql2o;

    public CityRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

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

    @Override
    public void addCity(String name, int country) {
        String sql = "INSERT INTO city (name, country) VALUES (:name, :country);";

        int i;
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("country", country).executeUpdate();
        }
    }


}
