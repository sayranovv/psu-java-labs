package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class FileManager {

    public static List<String> readFileLines(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    public static boolean fileExists(String filePath) {
        return Files.exists(Paths.get(filePath));
    }

    public static void createFile(String filePath, List<String> content) throws IOException {
        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent());
        Files.write(path, content, StandardCharsets.UTF_8);
    }

    public static String readFileAsString(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
    }
}