package services;

import utils.FileManager;
import java.io.*;
import java.util.*;

public class Task5Service {

    public void runTask5() {
        String filePath = "data/russian_text.txt";

        try {
            String text = FileManager.readFileAsString(filePath);

            System.out.println(text);

            String lowerText = text.toLowerCase();

            String consonants = "бвгджзйклмнпрстфхцчшщ";

            Map<Character, Set<String>> consonantWords = new TreeMap<>();

            String[] words = lowerText.split("[^а-яЁё]+");

            System.out.println("Найдено слов: " + words.length);
            System.out.println("Слова: " + Arrays.toString(words) + "\n");

            for (String word : words) {
                if (word.isEmpty()) continue;

                for (char ch : word.toCharArray()) {
                    if (consonants.indexOf(ch) >= 0) {
                        if (!consonantWords.containsKey(ch)) {
                            consonantWords.put(ch, new HashSet<>());
                        }

                        consonantWords.get(ch).add(word);
                    }
                }
            }

            List<Character> resultConsonants = new ArrayList<>();

            for (Character consonant : consonantWords.keySet()) {
                Set<String> words_with_consonant = consonantWords.get(consonant);

                if (words_with_consonant.size() == 1) {
                    resultConsonants.add(consonant);
                }
            }

            if (resultConsonants.isEmpty()) {
                System.out.println("Не найдено согласных букв входящих ровно в одно слово");
            } else {
                Collections.sort(resultConsonants);

                System.out.println("Найденные согласные (в алфавитном порядке):");
                for (Character consonant : resultConsonants) {
                    Set<String> wordsSet = consonantWords.get(consonant);
                    String word = wordsSet.iterator().next();
                    System.out.println("  '" + consonant + "' - входит в слово: \"" + word + "\"");
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}