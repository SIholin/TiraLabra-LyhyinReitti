package lyhyinreitti.algorithms;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Node class helps class named BreadthFirstSearch keeps track of nodes where we
 * have visited and the distance from starting node.
 */
class Node {

    int x, y, dist;

    /**
     * Save the information that new Node needs.
     *
     * @param x x coordinate
     * @param y y coordinate
     * @param dist distance from start
     */
    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

/**
 * If possible find shortest route troughout maze and class uses
 * BreadthFirstSearch
 */
public class BreadthFirstSearch {

    /**
     * Size of maze
     */
    private int width;
    private int height;

    /**
     * Maze giving by user
     */
    private int[][] maze;

    /**
     * Possible movements from a cell (previous, next, up and down)
     */
    private int row[] = {-1, 0, 0, 1};
    private int col[] = {0, -1, 1, 0};

   
    /**
     * Constructor of class. It get width, height and maze from main class
     * 
     * @param widht number of columns
     * @param height number of rows
     * @param maze 
     */
    public BreadthFirstSearch(int widht, int height, int[][] maze) {
        this.width = widht;
        this.height = height;
        this.maze = maze;

    }

    /**
     * Do the breadthFirstSearch calculation
     * 
     * @return true if it is possible solve maze and false if not.
     */
    public Boolean BFS() {

        int i = 0;
        int j = 0;
        int x = width - 1;
        int y = height - 1;

        if (maze[i][j] == 0 || maze[x][y] == 0) {
            System.out.println("Labyrintti on mahdoton");
            return false;
        }

        boolean[][] visited = new boolean[width][height];

        Queue<Node> q = new ArrayDeque<>();

        visited[i][j] = true;
        q.add(new Node(i, j, 0));

        int min_dist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node node = q.poll();

            i = node.x;
            j = node.y;
            int dist = node.dist;

            if (i == x && j == y) {
                min_dist = dist;
                break;
            }

            for (int k = 0; k < 4; k++) {
                if (isPossible(visited, i + row[k], j + col[k])) {
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            System.out.print("Lyhyimmän reitin pituus on " + min_dist);
            return true;
        } else {
            System.out.println("Labyrintti on mahdoton");
            return false;
        }

    }

    //Check is it possible to go maze[row][col]. If it is not possible function 
    //retruns false else true. It is not possible if it is already visited or 
    //outside of maze or the value of possible position is 0.
    /**
     * 
     * @param visited
     * @param r
     * @param c
     * @return 
     */
    private boolean isPossible(boolean visited[][], int r, int c) {
        return (r >= 0) && (r < width) && (c >= 0) && (c < height)
                && maze[r][c] == 1 && !visited[r][c];
    }

}
