package lyhyinreitti.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

public class AStarTest {

    AStar astar;
    Maze maze;
    Maze unsolvableMaze;
    Maze solvableMaze;
    Maze solvable;

    public AStarTest() {
        int[][] graph = {
            {0, 1},
            {0, 1},};

        int[][] g = {
            {1, 0},
            {0, 1},};

        int[][] m = {
            {1, 0},
            {1, 1},};

        int[][] gr = {
            {1, 1, 1},
            {0, 0, 1},
            {0, 0, 1},};

        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(1, 1);
        Coordinate e = new Coordinate(2, 2);
        maze = new Maze(graph, 2, 2, start, end);
        unsolvableMaze = new Maze(g, 2, 2, start, end);
        solvableMaze = new Maze(m, 2, 2, start, end);
        solvable = new Maze(gr, 3, 3, start, e);
    }

    @Test
    public void unsolableCaseOne() {

        astar = new AStar(maze);
        assertNull(astar.solve());

    }

    @Test
    public void solvable() {

        astar = new AStar(solvableMaze);
        assertTrue(astar.solve().size() == 3);

    }

    @Test
    public void unscolvableCaseTwo() {

        astar = new AStar(unsolvableMaze);
        assertNull(astar.solve());
    }

    @Test
    public void scolvableCaseThree() {

        astar = new AStar(solvable);
        assertTrue(astar.solve().size() == 5);
    }

}
