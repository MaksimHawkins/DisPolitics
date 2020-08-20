package com.dispolitics.server.models;

public class City {

    private Integer id;

    private String name;

    private Integer country;

    private Integer economyAmplifier;
    private Integer defendAmplifier;

    public City() {
    }

    public City(String name, Integer economyAmplifier, Integer defendAmplifier) {
        this.name = name;
        this.economyAmplifier = economyAmplifier;
        this.defendAmplifier = defendAmplifier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEconomyAmplifier() {
        return economyAmplifier;
    }

    public void setEconomyAmplifier(Integer economyAmplifier) {
        this.economyAmplifier = economyAmplifier;
    }

    public Integer getDefendAmplifier() {
        return defendAmplifier;
    }

    public void setDefendAmplifier(Integer defendAmplifier) {
        this.defendAmplifier = defendAmplifier;
    }
}
