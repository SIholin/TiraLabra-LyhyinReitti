package lyhyinreitti.algorithms;

import lyhyinreitti.dataStructures.Maze;
import lyhyinreitti.dataStructures.Coordinate;
import lyhyinreitti.dataStructures.Vector;

/**
 * If possible, finds the shortest route through the maze using breadth first
 * search
 */
public class BreadthFirstSearch extends Algorithm{

    private int maxSize;
    private int visits;
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
        maxSize = -1;
        visits = -1;

    }

    /**
     * Do the breadth first search calculation
     *
     * @return true if it is possible solve the maze and false if not.
     */
    @Override
    public Vector solve() {

        int i = 0;
        int j = 0;
        int x = maze.width - 1;
        int y = maze.height - 1;

        if (maze.graph[j][i] == 0 || maze.graph[y][x] == 0) {
            return null;
        }

        Coordinate[][] visited = new Coordinate[maze.height][maze.width];

        Vector q = new Vector(16);
        maxSize = 1;
        visits = 1;

        Coordinate c = new Coordinate(j, i);
      
        q.add(c);

        while (true) {
            Coordinate coordinate = q.poll();
            if (coordinate == null) {
                break;
            }
            i = coordinate.x;
            j = coordinate.y;
            

            if (i == x && j == y) {
                break;
            }

            for (int k = 0; k < 4; k++) {
                if (isPossible(visited, j + row[k], i + col[k])) {
                    visits ++;
                    visited[j + row[k]][i + col[k]] = coordinate;
                    Coordinate co = new Coordinate(j + row[k], i + col[k]);
                    q.add(co);

                }
            }
            int size = q.size();
            if (size > maxSize) {
                maxSize = size;
            }

        }
        if (visited[maze.end.y][maze.end.x] == null) {
            return null;
        }

        Coordinate current = visited[maze.end.y][maze.end.x],
                start = maze.start;
        Vector inversePath = new Vector(10);
        inversePath.add(maze.end);
        while (!current.equals(start)) {
            inversePath.add(current);
            current = visited[current.y][current.x];
        }
        inversePath.add(start);
        return inversePath; // todo reverse

    }

    /**
     * Check is it possible to go maze[row][col]. If it is not possible function
     * returns false else true. It is not possible if it is already visited or
     * outside of maze or the value of possible position is 0.
     *
     * @param visited saves coordinates where we have visited.
     * @param row index
     * @param col index
     * @return true if possible and false if not
     */
    private boolean isPossible(Coordinate visited[][], int row, int col) {
        Coordinate coordinate = new Coordinate(row, col);
        return (col >= 0) && (col < maze.width) && (row >= 0) && (row < maze.height)
                && maze.at(coordinate) && visited[row][col] == null;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getVisits() {
        return visits;
    }

}
