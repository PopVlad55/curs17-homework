package org.fasttackit;

import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String filePath = Objects.requireNonNull(Main.class.getClassLoader().getResource("countries.txt")).getPath();
        CountryReader countryReader = new CountryReader(filePath);
        CountryService countryService = countryReader.getCountryService();

        List<Country> allCountries = countryService.listAllCountries();
        System.out.println("All country: ");
        for (Country country : allCountries) {
            System.out.println(country.getName());

        }

        List<String> allCountryNames = countryService.listAllCountryNames();
        System.out.println("\nAll country names:");
        for(String name : allCountryNames){
            System.out.println(name);
        }

        String capitalOfTurkey = countryService.getCapital("Turkey");
        System.out.println("\nThe capital of Turkey is: " + capitalOfTurkey);

        long populationOfChina = countryService.getPopulation("China");
        System.out.println("\nThe population of China is: " + populationOfChina);

        List<Country> countriesInEurope = countryService.getCountriesInContinent("Europe");
        System.out.println("\nCountries in Europe:");
        for (Country country : countriesInEurope) {
            System.out.println(country.getName());
        }

        List<String> neighboursOfItaly = countryService.getCountryNeighbours("Italy");
        System.out.println("\nNeighbours of Italy:");
        for(String neighbour : neighboursOfItaly){
            System.out.println(neighbour);
        }

        List<Country> populationLargerThanCountruesInAsia = countryService.getCountriesInContinentWithPopLargerThan("Asia", 22222222);
        System.out.println("\nPopulation in asia larger than 22222222:");
        for(Country country : populationLargerThanCountruesInAsia){
            System.out.println(country.getName() + ": " + country.getPopulation());
        }

        List<Country> neighborXButNotY = countryService.getCountriesNEighbourXNotY("IND", "CHI");
        System.out.println("\nCountries that have neighbours India but not China:");
        for (Country country : neighborXButNotY){
            System.out.println(country.getName());
        }

    }
}
