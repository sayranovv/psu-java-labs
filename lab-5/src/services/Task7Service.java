package services;

import entities.*;
import utils.FileManager;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Task7Service {

    public void runTask7() {
        runTask7Part1();
        runTask7Part2();
    }

    private void runTask7Part1() {
        System.out.println("─── ЗАДАНИЕ 7.1: POLYLINE ИЗ STREAM ───\n");

        List<Point> points = Arrays.asList(
                new Point(1, 5),
                new Point(3, -2),
                new Point(1, 5),
                new Point(4, 3),
                new Point(2, -1),
                new Point(3, -2),
                new Point(5, 4),
                new Point(2, -1)
        );

        System.out.println("Исходный список точек:");
        for (int i = 0; i < points.size(); i++) {
            System.out.println("  [" + i + "] " + points.get(i));
        }

        System.out.println("\n--- Применяем Stream операции ---\n");
        System.out.println("1. Удаляем дубликаты (distinct)");
        System.out.println("2. Сортируем по координате X (sorted)");
        System.out.println("3. Делаем Y положительным (map с abs)");
        System.out.println("4. Собираем в Polyline (collect)\n");

        List<Point> processedPoints = points.stream()
                .distinct()
                .sorted(Comparator.comparingDouble(Point::getX))
                .map(point -> {
                    if (point.getY() < 0) {
                        point.setY(-point.getY());
                    }
                    return point;
                })
                .collect(Collectors.toList());

        System.out.println("Результат после Stream операций:");
        for (int i = 0; i < processedPoints.size(); i++) {
            System.out.println("  [" + i + "] " + processedPoints.get(i));
        }

        Polyline polyline = new Polyline(processedPoints);
        System.out.println("\n--- Создана Polyline ---\n");
        System.out.println("Результат: " + polyline);
        System.out.println("Количество точек: " + polyline.getPointCount());
    }

    private void runTask7Part2() {
        System.out.println("\n\n─── ЗАДАНИЕ 7.2: ГРУППИРОВКА ЛЮДЕЙ ПО НОМЕРАМ ───\n");

        String filePath = "data/people_data.txt";

        try {
            List<String> lines = FileManager.readFileLines(filePath);

            System.out.println("Исходные данные из файла:");
            for (String line : lines) {
                System.out.println("  " + line);
            }

            System.out.println("\n--- Применяем Stream операции ---\n");
            System.out.println("1. Парсим каждую строку в объект Person");
            System.out.println("2. Приводим имена в формат: первая буква заглавная, остальные маленькие");
            System.out.println("3. Фильтруем людей без номеров (номер != null)");
            System.out.println("4. Группируем по номеру\n");

            Map<Integer, List<String>> groupedByNumber = lines.stream()
                    .filter(line -> !line.trim().isEmpty())
                    .map(line -> {
                        String[] parts = line.split(":");
                        String name = parts[0].trim();

                        String formattedName = name.substring(0, 1).toUpperCase() +
                                name.substring(1).toLowerCase();

                        if (parts.length > 1 && !parts[1].trim().isEmpty()) {
                            return new AbstractMap.SimpleEntry<>(formattedName, Integer.parseInt(parts[1].trim()));
                        } else {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.groupingBy(
                            AbstractMap.SimpleEntry::getValue,
                            Collectors.mapping(
                                    AbstractMap.SimpleEntry::getKey,
                                    Collectors.toList()
                            )
                    ));

            System.out.println("─── РЕЗУЛЬТАТЫ ГРУППИРОВКИ ───\n");

            groupedByNumber.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> {
                        Integer number = entry.getKey();
                        List<String> names = entry.getValue();
                        System.out.println(number + ": " + names);
                    });

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}