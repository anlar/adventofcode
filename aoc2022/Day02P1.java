package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Day02P1 {
    public static void main(String[] args) throws IOException {
        List<String> values = Files.readAllLines(Path.of("resources/d02.txt"));

        int total = 0;

        for (String value: values) {
            String opponent = value.substring(0, 1);
            String you = value.substring(2, 3);

            total += score(opponent, you);
            total += score(you);
        }

        System.out.println(total);
    }


    public static int score(String opponent, String you) {
        switch (opponent) {
            case "A":
                switch (you) {
                    case "X": return 3;
                    case "Y": return 6;
                    case "Z": return 0;
                }

                return 0;
            case "B": 
                switch (you) {
                    case "X": return 0;
                    case "Y": return 3;
                    case "Z": return 6;
                }

                return 0;
            case "C": 
                switch (you) {
                    case "X": return 6;
                    case "Y": return 0;
                    case "Z": return 3;
                }

                return 0;
        }

        return 0;
    }

    public static int score(String you) {
        switch (you) {
            case "X": return 1;
            case "Y": return 2;
            case "Z": return 3;
        }

        return 0;
    }
}

