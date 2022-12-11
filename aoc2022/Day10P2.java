package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Day10P2 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("resources/d10.txt"));

        StringBuilder out = new StringBuilder();

        int cycle = 1;
        int register = 1;

        for (String line: lines) {
            String[] items = line.split(" ");

            int innerCycles = 0;
            int add = 0;

            switch(items[0]) {
                case "noop":
                    innerCycles = 1;
                    add = 0;
                    break;
                case "addx":
                    innerCycles = 2;
                    add = Integer.valueOf(items[1]);
                    break;
            }

            for (int i = 0; i < innerCycles; i++) {
                int row = cycle / 40;
                int col = cycle % 40 - 1;

                if (col == 0) {
                    out.append("\n");
                }

                if (col >= register-1 && col <= register+1) {
                    out.append("#");
                } else {
                    out.append(".");
                }

                cycle++;
            }

            register += add;
        }

        System.out.println(out);
    }
}

