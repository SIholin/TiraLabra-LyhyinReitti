package lyhyinreitti.tests.algorithms;

import lyhyinreitti.algorithms.BreadthFirstSearch;
import lyhyinreitti.dataStructures.Coordinate;
import lyhyinreitti.dataStructures.Maze;
import org.junit.Test;
import static org.junit.Assert.*;

public class BFSTest {

    BreadthFirstSearch bfs;
    Maze maze;
    Maze unsolvableMaze;
    Maze solvableMaze;

    public BFSTest() {
        int[][] graph = {
            {0, 1},
            {0, 1},};

        int[][] g = {
            {1, 0},
            {0, 1},};

        int[][] m = {
            {1, 0},
            {1, 1},};

        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(1, 1);
        maze = new Maze(graph, 2, 2, start, end);
        unsolvableMaze = new Maze(g, 2, 2, start, end);
        solvableMaze = new Maze(m, 2, 2, start, end);
    }

    @Test
    public void unsolableCaseOne() {

        bfs = new BreadthFirstSearch(maze);
        assertNull(bfs.solve());

    }

    @Test
    public void solvable() {

        bfs = new BreadthFirstSearch(solvableMaze);
        assertTrue(bfs.solve().size() == 3);

    }

    @Test
    public void unscolvableCaseTwo() {

        bfs = new BreadthFirstSearch(unsolvableMaze);
        assertNull(bfs.solve());
    }

    @Test
    public void getMaxSizeQueueWorks() {
        bfs = new BreadthFirstSearch(unsolvableMaze);
        assertTrue(bfs.getMaxSize() == -1);
    }

    @Test
    public void getVisitsWorks() {
        bfs = new BreadthFirstSearch(unsolvableMaze);
        assertTrue(bfs.getVisits() == -1);
    }
}
