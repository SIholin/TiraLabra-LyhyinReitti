package lyhyinreitti.algorithms;

import lyhyinreitti.algorithms.BreadthFirstSearch;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BFSTest {

    BreadthFirstSearch bfs;

    public BFSTest() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void unsolableCaseOne() {
        int[][] maze = {
            {0, 1},
            {0, 1},
        };

        bfs = new BreadthFirstSearch(2, 2, maze);
        assertFalse(bfs.BFS());

    }
    
    @Test
    public void solvable() {
        int[][] maze = {
            {1, 1},
            {0, 1},
        };
        
        bfs = new BreadthFirstSearch(2, 2, maze);
        assertTrue(bfs.BFS());
        
    }
    
    @Test
    public void unscolvableCaseTwo() {
        int[][] maze = {
            {1, 0},
            {0, 1},
        };
        
        bfs = new BreadthFirstSearch(2, 2, maze);
        assertFalse(bfs.BFS());
    }
}
