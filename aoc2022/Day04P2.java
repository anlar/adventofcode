package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Arrays;

public class Day04P2 {
    public static void main(String[] args) throws IOException {
        List<String> values = Files.readAllLines(Path.of("resources/d04.txt"));

        int total = 0;

        for (String value: values) {
            String[] sections = value.split(",");

            Integer[] s1 = Arrays.stream(sections[0].split("-"))
                .map(Integer::valueOf).toArray(Integer[]::new);

            Integer[] s2 = Arrays.stream(sections[1].split("-"))
                .map(Integer::valueOf).toArray(Integer[]::new);

            if (
                    (s1[0] >= s2[0] && s1[0] <= s2[1]) ||
                    (s1[1] >= s2[0] && s1[1] <= s2[1]) ||
                    (s2[0] >= s1[0] && s2[0] <= s1[1]) ||
                    (s2[1] >= s1[0] && s2[1] <= s1[1])
               ) {
                total++;
               }
        }


        System.out.println(total);
    }
}

