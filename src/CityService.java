import java.util.*;
import java.util.stream.Collectors;

class CityService implements CityServiceInterface {
    public List<City> listOutput(List<City> cities) {
        for (City city : cities) {
            System.out.println(city);
        }
        return cities;
    }

    public List<City> sortByName(List<City> cities) {
        List<City> sortCities = new ArrayList<>();
        sortCities.addAll(0, cities);
        Collections.sort(sortCities, City.COMPARE_BY_NAME);
        for (City city:sortCities) {
            System.out.println(city);
        }
        return sortCities;
    }

    public List<City> sortByDistrictAndName(List<City> cities) {
         List<City> sortCities = new ArrayList<>();
         sortCities.addAll(0, cities);
         sortCities = sortCities.stream()
                .sorted(Comparator.comparing(City::getName))
                .collect(Collectors.groupingBy(City::getDistrict))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
         for (City city:sortCities) {
             System.out.println(city);
         }
         return sortCities;
    }

    public int outputOfTheCityByTheMaximumPopulation(List<City> cities) {
        City[] cityArr = cities.toArray(new City[0]);
        City temp = cityArr[0];
        int index = 0;
        for (int i = 0; i < cityArr.length; i++){
            if (temp.getPopulation() < cityArr[i].getPopulation()) {
                temp = cityArr[i];
                index = i;
            }
        }
        System.out.println(new String("[" +index + "] = " + temp.getPopulation()));
        return temp.getPopulation();
    }

    public Map<String, Integer> sumOfCitiesInTheRegion(List<City> cities) {
        Map<String, Integer> map = cities.stream().collect(Collectors.toMap(City::getRegion, city -> 1,Integer::sum));
        map.entrySet().forEach(stringIntegerEntry -> {
            System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue());
        });
        return map;
    }
}
