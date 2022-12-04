package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Day01P1 {
    public static void main(String[] args) throws IOException {
        List<String> values = Files.readAllLines(Path.of("resources/d01.txt"));

        int maxCal = 0;
        int maxCalRun = 0;

        for (String item: values) {
            if ("".equals(item)) {
                if (maxCalRun > maxCal) {
                    maxCal = maxCalRun;
                }
                maxCalRun = 0;
            } else {
                maxCalRun += Integer.valueOf(item);
            }
        }


        if (maxCalRun > maxCal) {
            maxCal = maxCalRun;
        }

        System.out.println(maxCal);
    }
}

