package services;

import utils.FileManager;
import java.io.*;
import java.util.*;

public class Task4Service {

    public void runTask4() {

        String filePath = "data/olympiad_data.txt";

        try {
            List<String> lines = FileManager.readFileLines(filePath);

            System.out.println("Файл: " + filePath);
            System.out.println("Прочитано строк: " + lines.size());

            int participantCount = Integer.parseInt(lines.get(0));
            System.out.println("Количество участников: " + participantCount);

            Map<String, Integer> results = new LinkedHashMap<>();

            for (int i = 1; i <= participantCount; i++) {
                String line = lines.get(i);

                String[] parts = line.trim().split("\\s+");

                String lastName = parts[0];
                String firstName = parts[1];
                int score1 = Integer.parseInt(parts[2]);
                int score2 = Integer.parseInt(parts[3]);
                int score3 = Integer.parseInt(parts[4]);

                int totalScore = score1 + score2 + score3;

                String fullName = lastName + " " + firstName;
                results.put(fullName, totalScore);

                System.out.println("Обработан: " + fullName);
                System.out.println("  Баллы за задания: " + score1 + ", " + score2 + ", " + score3);
                System.out.println("  Общее количество баллов: " + totalScore + "\n");
            }

            int maxScore = Collections.max(results.values());
            System.out.println("Максимальное количество баллов: " + maxScore);

            List<String> winners = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : results.entrySet()) {
                if (entry.getValue() == maxScore) {
                    winners.add(entry.getKey());
                }
            }

            System.out.println("Участники набравшие максимальный результат (" + maxScore + " баллов):");
            for (String winner : winners) {
                System.out.println("  ► " + winner);
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка при парсинге данных: " + e.getMessage());
        }
    }
}