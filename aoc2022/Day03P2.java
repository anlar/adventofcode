package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day03P2 {
    public static void main(String[] args) throws IOException {
        List<String> values = Files.readAllLines(Path.of("resources/d03.txt"));

        int sum = 0;

        for (int i = 0; i < values.size(); i = i + 3) {
            char[] a = values.get(i).toCharArray();
            char[] b = values.get(i + 1).toCharArray();
            char[] c = values.get(i + 2).toCharArray();

            TOP: for (char ai: a) {
                for (char bi: b) {
                    for (char ci: c) {
                        if (ai == bi && bi == ci) {
                            sum += score(ai);
                            break TOP;
                        }
                    }
                }
            }
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

