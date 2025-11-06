import java.util.HashMap;
import java.util.Map;

public class City {

    private final String name;
    private final Map<City, Integer> paths;

    public City(String name) {
        this.name = name;
        this.paths = new HashMap<>();
    }

    public City(String name, Map<City, Integer> initialPaths) {
        this.name = name;
        this.paths = new HashMap<>(initialPaths);

        for (Map.Entry<City, Integer> entry : initialPaths.entrySet()) {
            addPath(entry.getKey(), entry.getValue());
        }
    }

    public void addPath(City city, int cost) {
        if (city == null) {
            throw new IllegalArgumentException("Город не может быть null");
        }

        if (city == this) {
            throw new IllegalArgumentException("Нельзя соединить город сам с собой");
        }

        if (cost <= 0) {
            throw new IllegalArgumentException("Стоимость дороги должна быть положительной");
        }

        if (paths.containsKey(city)) {
            System.out.println("Между " + name + " и " + city.name + " уже есть дорога!");
            return;
        }

        paths.put(city, cost);

        // обратная связь
        if (!city.paths.containsKey(this)) {
            city.paths.put(this, cost);
        }
    }

    public void removePath(City city) {
        if (city == null) return;

        paths.remove(city);
        city.paths.remove(this);
    }

    public Map<City, Integer> getPaths() {
        return Map.copyOf(paths);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" -> ");

        for (Map.Entry<City, Integer> entry : paths.entrySet()) {
            sb.append(entry.getKey().name).append(":").append(entry.getValue()).append(" ");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City other)) return false;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
