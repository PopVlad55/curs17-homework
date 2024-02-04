package org.fasttackit;

import lombok.Data;

@Data
public class Country {
    private static int nextId = 1;
    private int id;
    private String name;
    private String capital;
    private int population;
    private double area;
    private String continent;
    private String[] neighbors;

    public Country(String name, String capital, int population, double area, String continent, String[] neighbors) {
        this.id = nextId++;
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbors = neighbors;
    }
}
