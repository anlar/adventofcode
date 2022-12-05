package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Day05P2 {
    public static void main(String[] args) throws IOException {
        List<String> values = Files.readAllLines(Path.of("resources/d05.txt"));

        List<Deque> queues = new ArrayList<>();

        boolean firstPart = true;

        for (String line: values) {
            if (firstPart) {

                if (line.startsWith(" 1")) {
                    firstPart = false;
                    continue;
                }

                int i = 0;
                boolean keep = true;

                while (keep) {
                    int pos = 1 + i * 4;

                    if (line.length() >= pos) {

                        char item = line.charAt(pos);
                        if (pos != ' ') {
                            add(queues, i, item);
                        }

                        pos = 1 + i * 4;
                        i++;
                    } else {
                        keep = false;
                    }
                }
            } else {
                if (line.length() == 0) {
                    continue;
                } else {
                    String[] codes = line.split(" ");

                    int steps = Integer.valueOf(codes[1]);
                    int from = Integer.valueOf(codes[3]) - 1;
                    int to = Integer.valueOf(codes[5]) - 1;

                    Deque<Character> tmp = new ArrayDeque<>();

                    for (int step = 0; step < steps; step++) {
                        char ch = (Character) queues.get(from).removeFirst();
                        tmp.addFirst(ch);
                    }

                    for (Character ch: tmp) {
                        queues.get(to).addFirst(ch);
                    }
                }
            }
        }

        for (Deque queue: queues) {
            System.out.print(queue.getFirst());
        }
    }

    public static void add(List<Deque> queues, int index, char item) {
        if (queues.size() < index+1) {
            queues.add(new ArrayDeque<Character>());
        }

        if (item != ' ' ) {
            queues.get(index).addLast(item);
        }
    }
}

