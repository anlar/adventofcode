package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class Day07P1 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("resources/d07.txt"));

        Node root = new Node();
        root.name = "/";
        root.type = "dir";

        Node cursor = root;

        for (String line: lines) {
            String[] parts = line.split(" ");

            if (line.startsWith("$")) {
                if ("cd".equals(parts[1])) {
                    if ("..".equals(parts[2])) {
                        cursor = cursor.parent;
                    } else {
                        String target = parts[2];
                        for (Node node: cursor.children) {
                            if (target.equals(node.name)) {
                                cursor = node;
                                break;
                            }
                        }
                    }
                }
            } else {
                Node node = new Node();
                node.parent = cursor;
                node.name = parts[1];

                if ("dir".equals(parts[0])) {
                    node.type = "dir";
                } else {
                    node.type = "file";
                    node.size = Long.valueOf(parts[0]);
                }

                cursor.children.add(node);
            }
        }

        sum(root);

        List<Node> filteredDirs = new ArrayList<>();
        findDirs(root, filteredDirs, 100000);

        long sum = filteredDirs.stream().mapToLong(x -> x.size).sum();
        System.out.println(sum);
    }

    private static long sum(Node node) {
        if (node.children.size() > 0) {
            long sum = 0;

            for (Node child: node.children) {
                sum += sum(child);
            }

            node.size = sum;

            return sum;
        } else {
            return node.size;
        }
    }

    private static void findDirs(Node node, List<Node> dirs, long limit) {
        if ("dir".equals(node.type)) {
            if (node.size < limit) {
                dirs.add(node);
            }

            for (Node child: node.children) {
                findDirs(child, dirs, limit);
            }
        }
    }
}

class Node {
    String name;
    String type;
    long size;
    Node parent;
    List<Node> children = new ArrayList<>();;

    public String toString() {
        String indent = "  ";
        return type + " " + name + " " + size + print(children, indent);
    }

    public String toString(String indent) {
        return type + " " + name + " " + size + print(children, indent);
    }

    private String print(List<Node> nodes, String indent) {
        StringBuilder sb = new StringBuilder();

        for (Node node: nodes) {
            sb.append("\n");
            sb.append(indent);
            sb.append(node.toString(indent + "  "));
        }

        return sb.toString();
    }
}

