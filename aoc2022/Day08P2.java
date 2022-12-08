package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Day08P2 {
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

        int maxScore = 0;

        for (int i = 1; i < trees.length - 1; i++) {
            for (int k = 1; k < trees[i].length - 1; k++) {
                int score = calculateScore(trees, i, k);
                if (score > maxScore) {
                    maxScore = score;
                }
            }
        }

        System.out.println(maxScore);
    }

    private static int calculateScore(int[][] trees, int i, int k) {
        int h = trees[i][k];
        // System.out.println(String.format("H %s %s = %s", i, k, h));

        int score = 1;

        int leftScore = 0;
        for (int t = k - 1; t >= 0; t--) {
            leftScore++;
            if (trees[i][t] >= h) {
                break;
            }
        }
        // System.out.println("Left: " + leftScore);

        int rightScore = 0;
        for (int t = k + 1; t < trees[i].length; t++) {
            rightScore++;
            if (trees[i][t] >= h) {
                break;
            }
        }
        // System.out.println("Right: " + rightScore);

        int upScore = 0;
        for (int t = i - 1; t >= 0; t--) {
            upScore++;
            if (trees[t][k] >= h) {
                break;
            }
        }
        // System.out.println("Up: " + upScore);

        int downScore = 0;
        for (int t = i + 1; t < trees.length; t++) {
            downScore++;
            if (trees[t][k] >= h) {
                break;
            }
        }
        // System.out.println("Down: " + downScore);

        return leftScore * rightScore * upScore * downScore;
    }
}

