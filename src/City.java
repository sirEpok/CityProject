import java.util.Comparator;

class City {
    private int idCity;
    private String name;
    private String region;
    private String district;
    private int population;
    private int foundation;

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getFoundation() {
        return foundation;
    }

    public void setFoundation(int foundation) {
        this.foundation = foundation;
    }

    public City(int idCity, String name, String region, String district, int population, int foundation) {
        this.idCity = idCity;
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }

    public static final Comparator<City> COMPARE_BY_NAME = new Comparator<City>() {
        @Override
        public int compare(City lhs, City rhs) {
            return lhs.getName().compareTo(rhs.getName());
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (idCity != city.idCity) return false;
        if (population != city.population) return false;
        if (foundation != city.foundation) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (region != null ? !region.equals(city.region) : city.region != null) return false;
        return district != null ? district.equals(city.district) : city.district == null;
    }

    @Override
    public int hashCode() {
        int result = idCity;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + population;
        result = 31 * result + foundation;
        return result;
    }
}
