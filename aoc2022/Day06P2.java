package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.HashSet;

public class Day06P1 {
    public static void main(String[] args) throws IOException {
        String data = Files.readAllLines(Path.of("resources/d06.txt")).get(0);

        int result = 0;
        Set<Character> buf = new HashSet<>();

        for (int i = 13; i < data.length(); i++) {
            String seq = data.substring(i - 13, i + 1);

            buf.clear();

            seq.chars().mapToObj(c -> (char) c).forEach(buf::add);

            if (buf.size() == 14) {
                result = i + 1;
                break;
            }
        }

        System.out.println(result);
    }
}

