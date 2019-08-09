package lyhyinreitti.ui;

import java.util.ArrayList;
import java.util.Scanner;
import lyhyinreitti.algorithms.AStar;
import lyhyinreitti.algorithms.BreadthFirstSearch;
import lyhyinreitti.algorithms.Coordinate;
import lyhyinreitti.algorithms.Maze;

public class Ui {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Anna labyrintin leveys kokonaislukuna");
        int width = wrongInputException(reader);

        System.out.println("\nAnna labyrintin korkeus kokonaislukuna");
        int height = wrongInputException(reader);

        System.out.println("\nAnna labyrintti (0 on seinä ja 1 on mahdollinen kulkusuunta)");

        int[][] graph = new int[width][height];
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                try {
                    int input = reader.nextInt();
                    if (input == 0 || input == 1) {
                        graph[c][r] = input;
                    } else {
                        System.out.println("Syöttämäsi merkki ei ollut 0 tai 1. "
                                + "Syötä luku uudestaan.");
                        c--;
                    }

                } catch (Exception e) {
                    System.out.println("Syöttämäsi merkki ei ollut kokonaisluku"
                            + ". Ohjelma suljetaan.");
                    System.exit(0);
                }
            }
        }
        int x = width - 1;
        int y = height - 1;

        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(x, y);

        Maze maze = new Maze(graph, width, height, start, end);
        maze.printGraph();

        System.out.println("\nRatkaistaanko lyhyin reitti leveyssuuntaisella "
                + "haulla vai A* algoritmillä? 'A' = A* ja 'B' = "
                + "leveyssuuntainenhaku");
        String choice = reader.next();
        if (choice.equals("A")) {
            AStar astar = new AStar(maze);
            ArrayList<Coordinate> cs = astar.solve();
            try {
                System.out.println("\nLyhyimmän reitin siirtymien määrä on " + (cs.size() -1));
            } catch (Exception e) {
                System.out.println("\nLabyrintti mahdotn");
            }
        } else if (choice.equals("B")) {
            BreadthFirstSearch bfs = new BreadthFirstSearch(maze);
            bfs.solve();
        } else {
            System.out.println("\nAntamasi merkki ei ollut A tai B. Ohjelma "
                    + "suljetaan");
        }

    }

    private static int wrongInputException(Scanner reader) {
        int i = -1;
        try {
            i = reader.nextInt();
        } catch (Exception e) {
            System.out.println("Syöttämäsi merkki ei ollut kokonaisluku. "
                    + "Ohjelma suljetaan.");
            System.exit(0);
        };
        return i;
    }

}
