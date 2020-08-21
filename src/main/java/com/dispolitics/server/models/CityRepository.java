package com.dispolitics.server.models;


import java.util.List;

public interface CityRepository {

    public List<City> getAllCities();

    public void addCity(String name, int country);

}
