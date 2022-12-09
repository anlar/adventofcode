package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Day09P1 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("resources/d09.txt"));

        int hx = 0, hy = 0, tx = 0, ty = 0;

        Set<String> history = new HashSet<>();
        history.add(tx + ";" + ty);

        for (String line: lines) {
            String[] codes = line.split(" ");
            int moves = Integer.valueOf(codes[1]);

            for (int i = 0; i < moves; i++) {
                switch (codes[0]) {
                    case "U":  hy++; break;
                    case "D":  hy--; break;
                    case "R":  hx++; break;
                    case "L":  hx--; break;
                }

                // move

                if (Math.abs(hx - tx) > 1 || Math.abs(hy - ty) > 1) {

                    if (hy == ty) {
                        if (hx > tx)
                            tx++;
                        else
                            tx--;
                    } else if (hx == tx) {
                        if (hy > ty)
                            ty++;
                        else
                            ty--;
                    } else {

                        if (Math.abs(hx - tx) == 1) {
                            tx = hx;

                            if (hy > ty)
                                ty++;
                            else
                                ty--;

                        } else {
                            ty = hy;

                            if (hx > tx)
                                tx++;
                            else
                                tx--;
                        }

                    }

                }

                history.add(tx + ";" + ty);
            }
        }

        //System.out.println(history);

        System.out.println(history.size());
    }

}

