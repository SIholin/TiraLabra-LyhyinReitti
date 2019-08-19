package lyhyinreitti.tests;



import lyhyinreitti.dataStructures.Coordinate;
import lyhyinreitti.dataStructures.Coordinate;
import lyhyinreitti.dataStructures.Maze;
import lyhyinreitti.dataStructures.Maze;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GeneratorTest {
    private Maze maze;
    public GeneratorTest() {
        
        
    }
    
    @Test
    public void generateMaze() {
        int[][] g = new int[10][10];
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(9, 9);
        maze = new Maze(g, 10, 10, start, end);
        
        maze.generate(start, end);
        
        for(int y = 0; y < 10; y ++) {
            for(int x = 0; x < 10; x ++) {
               assertTrue(maze.graph[y][x] == 1 || maze.graph[y][x] == 0);
            }
        }
    }
    
   
}
