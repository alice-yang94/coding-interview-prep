public class Country {
    
    String name;
    String continent;
    int population;

    public Country(String name, String continent, int population) {
        this.name = name;
        this.continent = continent;
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public int getPopulation() {
        return population;
    }
}
