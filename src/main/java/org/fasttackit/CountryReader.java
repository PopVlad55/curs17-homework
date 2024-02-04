package org.fasttackit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountryReader {
    private final CountryService countryService;

    public CountryReader(String filePath) {
        List<Country> countries = readCountriesFromFile(filePath);
        this.countryService = new CountryService(countries);
    }

    private List<Country> readCountriesFromFile(String filePath) {
        List<Country> countries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data.length >= 5) {
                    String name = data[0];
                    String capital = data[1];
                    int population = Integer.parseInt(data[2]);
                    double area = Double.parseDouble(data[3]);
                    String continent = data[4];

                    String[] neighbors = new String[0];
                    if (data.length > 5) {
                        neighbors = data[5].split("~");
                    }

                    Country country = new Country(name, capital, population, area, continent, neighbors);
                    countries.add(country);
                } else {
                    System.err.println("Error");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public CountryService getCountryService() {
        return countryService;
    }
}