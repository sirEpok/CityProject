import java.util.List;
import java.util.Map;

public interface CityServiceInterface {
    public List<City> listOutput(List<City> cities);

    public List<City> sortByName(List<City> cities);

    public List<City> sortByDistrictAndName(List<City> cities);

    public int outputOfTheCityByTheMaximumPopulation(List<City> cities);

    public Map<String, Integer> sumOfCitiesInTheRegion(List<City> cities);
}
