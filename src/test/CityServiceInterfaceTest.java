import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityServiceInterfaceTest extends TestCase {

    List<City> expected;
    List<City> actual;
    CityServiceInterface cityService = new CityService();

    @Before
    public void setUp() throws Exception {
        actual = Arrays.asList(new City(1, "Адыгейск", "Адыгея", "Южный", 12248, 1973)
                , new City(2, "Майкоп", "Адыгея", "Южный", 144246, 1857)
                , new City(3, "Горно-Алтайск", "Алтай", "Сибирский", 56928, 1830)
                , new City(4, "Абаза", "Хакасия", "Сибирский", 17111, 1867)
                , new City(5, "Абакан", "Хакасия", "Сибирский", 165183, 1931)
                , new City(6, "Абдулино", "Оренбургская область", "Приволжский", 20663, 1795)
        );
    }

    @Test
    public void testListOutput() {
        expected = Arrays.asList(new City(1, "Адыгейск", "Адыгея", "Южный", 12248, 1973)
                , new City(2, "Майкоп", "Адыгея", "Южный", 144246, 1857)
                , new City(3, "Горно-Алтайск", "Алтай", "Сибирский", 56928, 1830)
                , new City(4, "Абаза", "Хакасия", "Сибирский", 17111, 1867)
                , new City(5, "Абакан", "Хакасия", "Сибирский", 165183, 1931)
                , new City(6, "Абдулино", "Оренбургская область", "Приволжский", 20663, 1795)
        );
        Assert.assertEquals(expected, cityService.listOutput(actual));
    }

    @Test
    public void testSortByName() {
        expected = Arrays.asList(new City(4, "Абаза", "Хакасия", "Сибирский", 17111, 1867)
                , new City(5, "Абакан", "Хакасия", "Сибирский", 165183, 1931)
                , new City(6, "Абдулино", "Оренбургская область", "Приволжский", 20663, 1795)
                , new City(1, "Адыгейск", "Адыгея", "Южный", 12248, 1973)
                , new City(3, "Горно-Алтайск", "Алтай", "Сибирский", 56928, 1830)
                , new City(2, "Майкоп", "Адыгея", "Южный", 144246, 1857)
        );
        Assert.assertEquals(expected, cityService.sortByName(actual));
    }

    @Test
    public void testSortByDistrictAndName() {
        expected = Arrays.asList(new City(6, "Абдулино", "Оренбургская область", "Приволжский", 20663, 1795)
                , new City(4, "Абаза", "Хакасия", "Сибирский", 17111, 1867)
                , new City(5, "Абакан", "Хакасия", "Сибирский", 165183, 1931)
                , new City(3, "Горно-Алтайск", "Алтай", "Сибирский", 56928, 1830)
                , new City(1, "Адыгейск", "Адыгея", "Южный", 12248, 1973)
                , new City(2, "Майкоп", "Адыгея", "Южный", 144246, 1857)
        );
        Assert.assertEquals(expected, cityService.sortByDistrictAndName(actual));
    }

    @Test
    public void testOutputOfTheCityByTheMaximumPopulation() {
        int expectedInteger = 165183;
        Assert.assertEquals(expectedInteger, cityService.outputOfTheCityByTheMaximumPopulation(actual));
    }

    @Test
    public void testSumOfCitiesInTheRegion() {
        Map<String , Integer> map = new HashMap<>();

        map.put("Хакасия", 2);
        map.put("Оренбургская область", 1);
        map.put("Адыгея", 2);
        map.put("Алтай", 1);

        Assert.assertEquals(map, cityService.sumOfCitiesInTheRegion(actual));
    }
}