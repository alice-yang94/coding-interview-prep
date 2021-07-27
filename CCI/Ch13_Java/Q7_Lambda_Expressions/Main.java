import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        String[] names = {"China", "Korea", "Japan", "Australia", "New Zealand"};
        String[] continents = {"Asia","Asia","Asia","Australia","Australia"};
        int[] pops = {1,2,3,4,5};
        List<Country> countries = generateCountries(names, continents, pops);

        int totalPopsAsia = getPopulation(countries, "Asia");
        System.out.println(totalPopsAsia == (1+2+3));

        int totalPopsAus = getPopulation(countries, "Australia");
        System.out.println(totalPopsAus == (4+5));

        totalPopsAsia = getPopulationLambda(countries, "Asia");
        System.out.println(totalPopsAsia == (1+2+3));

        totalPopsAus = getPopulationLambda(countries, "Australia");
        System.out.println(totalPopsAus == (4+5));
    }

    private static int getPopulation(List<Country> countries, String continent) {
        /** Computes the total population of a given continent */
        int total = 0;
        for (Country country : countries) {
            total += country.getContinent().equals(continent)? country.getPopulation() : 0;
        }
        return total;
    }

    private static int getPopulationLambda(List<Country> countries, String continent) {
        /** Computes the total population of a given continent 
         * Three Steps:
         * 1. get all countries satisfy the condition (continent match)
         * 2. get all populations from this step 1 countries
         * 3. sum up the populations in step 2
        */
        Stream<Integer> populations = countries.stream().map(
            country -> country.getContinent().equals(continent)? country.getPopulation() : 0
        );
        // if no elements 0, else sum it
        int total = populations.reduce(0, (a,b) -> a + b);
        return total;
    }

    private static List<Country> generateCountries(String[] names, String[] conts, int[] pops) {
        int n  = names.length;
        List<Country> countries = new ArrayList<Country>();
        for (int i = 0; i < n; i++) {
            Country country = new Country(names[i], conts[i], pops[i]);
            countries.add(country);
        }
        return countries;
    }
}
