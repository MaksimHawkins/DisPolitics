package com.dispolitics.server.models;

import org.hibernate.annotations.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String name;
    private Integer economyAmplifier;
    private Integer defendAmplifier;

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
