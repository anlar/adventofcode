package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day03P1 {
    public static void main(String[] args) throws IOException {
        List<String> values = Files.readAllLines(Path.of("resources/d03.txt"));

        int sum = 0;

        for (String value: values) {
            char[] left = value.substring(0, value.length() / 2).toCharArray();
            char[] right = value.substring(value.length() / 2, value.length()).toCharArray();

            char common = 0;

            TOP: for (char i: left) {
                for (char k: right) {
                    if (i == k) {
                        common = i;
                        break TOP;
                    }
                }
            }

            sum += score(common);
        }

        System.out.println(sum);
    }

    private static int score(char c) {
        if (Character.isLowerCase(c)) {
            return c - 96;
        } else {
            return c - 38;
        }
    }
}

