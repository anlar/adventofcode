package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Day10P1 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("resources/d10.txt"));

        int cycle = 1;
        int register = 1;
        int strength = 0;

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
                if (cycle == 20 || (cycle >= 60 && (cycle - 20) % 40 == 0)) {
                    //System.out.println("C: " + cycle);
                    //System.out.println("R: " + register);
                    //System.out.println("+: " + cycle * register);
                    strength += cycle * register;
                }
                cycle++;
            }

            //System.out.println("Add: " + add);
            register += add;
        }

        System.out.println(strength);
    }
}

