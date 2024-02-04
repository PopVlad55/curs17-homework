package org.fasttackit;

import java.util.List;
import java.util.stream.Collectors;

public class CountryService {
    private final List<Country> countries;

    public CountryService(List<Country> countries){
        this.countries = countries;
    }

    public List<Country> listAllCountries(){
        return countries;
    }

    public List<String> listAllCountryNames(){
        return countries.stream().map(Country::getName).collect(Collectors.toList());
    }

    public String getCapital(String countryName){
        return countries.stream().filter(country -> country.getName().equalsIgnoreCase(countryName))
                .findFirst().map(Country::getCapital).orElse(null);
    }

    public long getPopulation(String countryName){
        return countries.stream().filter(country -> country.getName().equalsIgnoreCase(countryName))
                .findFirst().map(Country::getPopulation).orElse(0);
    }

    public List<Country> getCountriesInContinent(String continent){
        return countries.stream().filter(country -> country.getContinent().equalsIgnoreCase(continent))
                .collect(Collectors.toList());
    }

    public List<String> getCountryNeighbours(String countryName){
        return countries.stream().filter(country -> country.getName().equalsIgnoreCase(countryName))
                .findFirst().map(country -> List.of(country.getNeighbors())).orElse(List.of());
    }

    public List<Country> getCountriesInContinentWithPopLargerThan(String contintent, long population){
        return countries.stream().filter(country -> country.getContinent().equalsIgnoreCase(contintent)
                && country.getPopulation() > population).collect(Collectors.toList());
    }

    public List<Country> getCountriesNEighbourXNotY(String neighbourX, String neighbourY ){
        return countries.stream().filter(country -> List.of(country.getNeighbors()).contains(neighbourX)
                && !List.of(country.getNeighbors()).contains(neighbourY)).collect(Collectors.toList());
    }
}
