package lyhyinreitti.ui;

import java.util.Scanner;
import lyhyinreitti.algorithms.AStar;
import lyhyinreitti.algorithms.BreadthFirstSearch;
import lyhyinreitti.dataStructures.Coordinate;
import lyhyinreitti.dataStructures.Maze;
import lyhyinreitti.dataStructures.Vector;

public class Ui {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Anna labyrintin leveys kokonaislukuna");
        int width = wrongInputException(reader);

        System.out.println("\nAnna labyrintin korkeus kokonaislukuna");
        int height = wrongInputException(reader);

        System.out.println("\nSyötätkö labyrintin vai annatko sovelluksen "
                + "generoida sen? 'S' syötä itse ja 'G' ohjelma generoi, jotta "
                + "generointi toimii kunnolla labyrintin koon tulee olla "
                + "vähintään 4X4.");

        int[][] graph = new int[height][width];

        int x = width - 1;
        int y = height - 1;
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(y, x);

        Maze maze = new Maze(graph, width, height, start, end);

        String input = reader.next();
        if (input.equals("S")) {

            System.out.println("\nAnna labyrintti (0 on seinä ja 1 on mahdollinen kulkusuunta)");

            for (int r = 0; r < height; r++) {
                for (int c = 0; c < width; c++) {
                    try {
                        int nextInt = reader.nextInt();
                        if (nextInt == 0 || nextInt == 1) {
                            graph[r][c] = nextInt;
                        } else {
                            System.out.println("Syöttämäsi luku ei ollut 0 tai 1. "
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
            maze.setGraph(graph);
        } else if (input.equals("G")) {
            for(int[] line : graph)
                for(int i = 0; i < line.length; i++)
                    line[i] = 1;
            maze.generate(start, end);
        } else {
            System.out.println("\nAntamasi merkki ei ollut S tai G. Ohjelma "
                    + "suljetaan");
            System.exit(0);
        }

        printGraph(maze);

        System.out.println("\nRatkaistaanko lyhyin reitti leveyssuuntaisella "
                + "haulla vai A* algoritmillä? 'A' = A* ja 'B' = "
                + "leveyssuuntainenhaku");
        String choice = reader.next();
        if (choice.equals("A")) {
            AStar astar = new AStar(maze);
            Vector<Coordinate> cs = astar.solve();
            try {
                System.out.println("\nLyhyimmän reitin siirtymien määrä on " + (cs.size() - 1));
                cs.print();
            } catch (Exception e) {
                System.out.println("\nLabyrintti mahdoton");
            }
        } else if (choice.equals("B")) {
            BreadthFirstSearch bfs = new BreadthFirstSearch(maze);
            Vector<Coordinate> cs = bfs.solve();
            try {
                System.out.println("\nLyhyimmän reitin siirtymien määrä on " + (cs.size() - 1));
                cs.print();
            } catch (Exception e) {
                System.out.println("\nLabyrintti mahdoton");
            }
        } else {
            System.out.println("\nAntamasi merkki ei ollut A tai B. Ohjelma "
                    + "suljetaan");
            System.exit(0);
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

    /**
     * Prints the maze.
     *
     * @param m Maze which will be printed
     */
    public static void printGraph(Maze m) {
        System.out.println("\nLabyrinttisi: ");
        for (int i = 0; i < m.height; i++) {
            printALineOfStart(i, m);
            System.out.println("");
        }
    }

    private static void printALineOfStart(int i, Maze m) {

        for (int y = 0; y < m.width; y++) {
            System.out.print(m.graph[i][y] + " ");
        }
    }

}
