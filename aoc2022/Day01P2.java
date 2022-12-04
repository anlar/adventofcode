package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Day01P2 {
    public static void main(String[] args) throws IOException {
        List<String> values = Files.readAllLines(Path.of("resources/d01.txt"));

        int[] maxCal = {0, 0, 0};
        int maxCalRun = 0;

        for (String item: values) {
            if ("".equals(item)) {
                update(maxCal, maxCalRun);
                maxCalRun = 0;
            } else {
                maxCalRun += Integer.valueOf(item);
            }
        }

        update(maxCal, maxCalRun);

        System.out.println(Arrays.stream(maxCal).sum());
    }

    private static void update(int[] maxCal, int probe) {
        if (maxCal[0] < probe) {
            maxCal[0] = probe;
            Arrays.sort(maxCal);	
        }
    }
}

