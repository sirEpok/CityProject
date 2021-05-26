import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        File file = new File("city.txt");
        Scanner sc;
        try {
            sc = new Scanner(file);

            while (sc.hasNext()) {
                String line = sc.nextLine().trim();
                String[] strings = line.split(";");
                cities.add(new City(Integer.parseInt(strings[0]), strings[1], strings[2], strings[3], Integer.parseInt(strings[4]), Integer.parseInt(strings[5])));
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        Scanner scan = new Scanner(System.in);
        CityService cs = new CityService();
        int x = 0;
        String s ="";

        while (!"61".equals(s)) {
            System.out.println("1. Для вывода списка городов введите 1");
            System.out.println("2. Для вывода отсортированного массива по названию города введите 2");
            System.out.println("3. Для вывода отсортированного массива по области и названия города введите 3");
            System.out.println("4. Для вывода города с максимальным населением введите 4");
            System.out.println("5. Для вывода суммы городов в области введите 5");
            System.out.println("6. Для выхода нажмите 6");
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }

            switch (x) {
                case 1:
                    cs.listOutput(cities);
                    break;
                case 2:
                    cs.sortByName(cities);
                    break;
                case 3:
                    cs.sortByDistrictAndName(cities);
                    break;
                case 4:
                    cs.outputOfTheCityByTheMaximumPopulation(cities);
                    break;
                case 5:
                    cs.sumOfCitiesInTheRegion(cities);
                    break;
                case 6:
                    System.exit(0);
            }
        }
        scan.close();
        System.out.println("До свидания!");
    }
}
