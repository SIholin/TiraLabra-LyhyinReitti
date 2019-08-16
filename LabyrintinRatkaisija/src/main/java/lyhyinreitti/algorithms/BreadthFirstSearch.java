package lyhyinreitti.algorithms;

import lyhyinreitti.dataStructures.MyList;

/**
 * If possible, finds the shortest route through the maze using breadth first
 * search
 */
public class BreadthFirstSearch extends Algorithm {

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
    public MyList<Coordinate> solve() {

        int i = 0;
        int j = 0;
        int x = maze.width - 1;
        int y = maze.height - 1;

        if (maze.graph[j][i] == 0 || maze.graph[y][x] == 0) {
            System.out.println("Labyrintti on mahdoton");
            return null;
        }

        Coordinate[][] visited = new Coordinate[maze.height][maze.width];

        MyList<Coordinate> q = new MyList<>(16);

//        visited[i][j] = true;
        Coordinate c = new Coordinate(j, i);
        c.setDistance(0);
        q.add(c);

        int minDist = Integer.MAX_VALUE;

        while (true) {
            Coordinate coordinate = q.poll();
            if (coordinate == null) {
                break;
            }
            i = coordinate.x;
            j = coordinate.y;
            int dist = coordinate.dist;

            if (i == x && j == y) {
                minDist = dist;
                break;
            }

            for (int k = 0; k < 4; k++) {
                if (isPossible(visited, j + row[k], i + col[k])) {
                    visited[j + row[k]][i + col[k]] = coordinate;
                    Coordinate co = new Coordinate(j + row[k], i + col[k]);
                    co.setDistance(dist + 1);
                    q.add(co);

                }
            }

        }
        if (visited[maze.end.y][maze.end.x] == null) {
            return null;
        }

        Coordinate current = visited[maze.end.y][maze.end.x],
                start = maze.start;
        MyList<Coordinate> inversePath = new MyList(10);
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
     * @param visited
     * @param r
     * @param c
     * @return true if possible and false if not
     */
    private boolean isPossible(Coordinate visited[][], int row, int col) {
        Coordinate coordinate = new Coordinate(row, col);
        return (col >= 0) && (col < maze.width) && (row >= 0) && (row < maze.height)
                && maze.at(coordinate) && visited[row][col] == null;
    }

}
