package lyhyinreitti.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import javafx.util.Pair;

/**
 * If possible, finds the shortest route through the maze using
 * breadth first search
 */
public class BreadthFirstSearch extends Algorithm{

    private ArrayList<Pair<Integer, Integer>> solution;

    /**
     * Possible movements from a cell (previous, next, up and down)
     */
    private int row[] = {-1, 0, 0, 1};
    private int col[] = {0, -1, 1, 0};

   
    /**
     * Constructor of class. It gets width, height and maze from main class
     * 
     * @param maze 
     */
    public BreadthFirstSearch(Maze maze) {
        super(maze);

    }

    /**
     * Do the breadth first search calculation
     * 
     * @return true if it is possible solve the maze and false if not.
     */
    @Override
    public ArrayList<Coordinate> solve() {

        int i = 0;
        int j = 0;
        int x = maze.width - 1;
        int y = maze.height - 1;

        if (maze.graph[i][j] == 0 || maze.graph[x][y] == 0) {
            System.out.println("Labyrintti on mahdoton");
            return null;
        }

        boolean[][] visited = new boolean[maze.width][maze.height];
        ArrayList<Coordinate> path = new ArrayList<>();
        Queue<Coordinate> q = new ArrayDeque<>();

        visited[i][j] = true;
        Coordinate c = new Coordinate(i, j);
        c.setDistance(0);
        q.add(c);
        path.add(c);

        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Coordinate coordinate = q.poll();

            i = coordinate.x;
            j = coordinate.y;
            int dist = coordinate.dist;

            if (i == x && j == y) {
                minDist = dist;
                break;
            }

            for (int k = 0; k < 4; k++) {
                if (isPossible(visited, i + row[k], j + col[k])) {
                    visited[i + row[k]][j + col[k]] = true;
                    Coordinate co = new Coordinate(i + row[k], j + col[k]);
                    co.setDistance(dist + 1);
                    q.add(co);
                    path.add(co);
                }
            }
        }

        if (minDist != Integer.MAX_VALUE) {
            System.out.print("Lyhyimmän reitin siirtymien määrä on " + minDist);
            return path;
        } else {
            System.out.println("Labyrintti on mahdoton");
            return null;
        }

    }

    /** Check is it possible to go maze[row][col]. If it is not possible function 
    * returns false else true. It is not possible if it is already visited or 
    * outside of maze or the value of possible position is 0.
     * 
     * @param visited
     * @param r
     * @param c
     * @return true if possible and false if not
     */
    private boolean isPossible(boolean visited[][], int r, int c) {
        Coordinate coordinate = new Coordinate(r, c);
        return (r >= 0) && (r < maze.width) && (c >= 0) && (c < maze.height)
                && maze.at(coordinate) && !visited[r][c];
    }

}
