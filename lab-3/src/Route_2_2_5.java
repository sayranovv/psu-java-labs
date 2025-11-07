import java.util.*;

public class Route_2_2_5 {
    private City_2_1_10 start;
    private City_2_1_10 end;

    public Route_2_2_5(City_2_1_10 start, City_2_1_10 end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Начальный и конечный города не могут быть null");
        }

        this.start = start;
        this.end = end;
    }

    public List<City_2_1_10> getPath() {
        Map<City_2_1_10, Integer> distances = new HashMap<>();
        Map<City_2_1_10, City_2_1_10> previous = new HashMap<>();
        PriorityQueue<City_2_1_10> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (City_2_1_10 city : getAllCities(start)) {
            distances.put(city, Integer.MAX_VALUE);
        }

        distances.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            City_2_1_10 current = queue.poll();

            if (current.equals(end)) break;

            for (Map.Entry<City_2_1_10, Integer> entry : current.getPaths().entrySet()) {
                City_2_1_10 neighbor = entry.getKey();
                int cost = entry.getValue();
                int newDist = distances.get(current) + cost;

                if (newDist < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        if (!previous.containsKey(end)) return Collections.emptyList();

        List<City_2_1_10> path = new ArrayList<>();

        for (City_2_1_10 at = end; at != null; at = previous.get(at)) {
            path.add(at);
        }

        Collections.reverse(path);
        return path;
    }

    private Set<City_2_1_10> getAllCities(City_2_1_10 start) {
        Set<City_2_1_10> all = new HashSet<>();
        Queue<City_2_1_10> queue = new LinkedList<>();
        queue.add(start);
        all.add(start);

        while (!queue.isEmpty()) {
            City_2_1_10 current = queue.poll();
            for (City_2_1_10 neighbor : current.getPaths().keySet()) {
                if (all.add(neighbor)) queue.add(neighbor);
            }
        }
        return all;
    }

    @Override
    public String toString() {
        List<City_2_1_10> path = getPath();
        if (path.isEmpty()) return "Путь не найден";
        return String.join(" -> ", path.stream().map(c -> c.toString().split(" -> ")[0]).toList());
    }
}
