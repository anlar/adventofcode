package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Day08P1 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("resources/d08.txt"));

        int[][] trees = new int[lines.size()][];

        for (int i = 0 ; i < lines.size(); i++) {
            trees[i] = new int[lines.get(i).length()];

            for (int k = 0; k < lines.get(i).length(); k++) {
                trees[i][k] = Integer.valueOf(lines.get(i).substring(k, k+1));
            }
        }

        // System.out.println(Arrays.deepToString(trees));

        int visible = (trees.length * 2) +
            (trees[0].length - 2) +
            (trees[trees.length - 1].length - 2);

        for (int i = 1; i < trees.length - 1; i++) {
            for (int k = 1; k < trees[i].length - 1; k++) {
                if (isVisible(trees, i, k)) {
                    visible++;
                }
            }
        }

        System.out.println(visible);
    }

    private static boolean isVisible(int[][] trees, int i, int k) {
        int h = trees[i][k];

        int visibleDirections = 4;

        // System.out.println("H: " + h);

        for (int t = 0; t < k; t++) {
            // System.out.println("left: " + trees[i][t]);

            if (trees[i][t] >= h) {
                visibleDirections--;
                break;
            }
        }

        for (int t = k+1; t < trees[i].length; t++) {
            // System.out.println("right: " + trees[i][t]);

            if (trees[i][t] >= h) {
                visibleDirections--;
                break;
            }
        }

        for (int t = 0; t < i; t++) {
            // System.out.println("up: " + trees[t][k]);

            if (trees[t][k] >= h) {
                visibleDirections--;
                break;
            }
        }

        for (int t = i+1; t < trees.length; t++) {
            // System.out.println("down: " + trees[t][k]);

            if (trees[t][k] >= h) {
                visibleDirections--;
                break;
            }
        }


        return visibleDirections > 0;
    }
}

