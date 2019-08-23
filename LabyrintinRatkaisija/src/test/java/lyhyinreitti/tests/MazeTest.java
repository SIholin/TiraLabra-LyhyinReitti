package lyhyinreitti.tests;

import lyhyinreitti.dataStructures.Coordinate;
import lyhyinreitti.dataStructures.Maze;
import org.junit.Test;
import static org.junit.Assert.*;

public class MazeTest {

    private Maze maze;
    private Maze second;
    private Coordinate start;
    private Coordinate end;

    public MazeTest() {
        int[][] g = new int[10][10];
        start = new Coordinate(0, 0);
        end = new Coordinate(9, 9);
        maze = new Maze(g, 10, 10, start, end);
        int[][] graph = {
            {0, 1},
            {0, 1},};
        Coordinate e = new Coordinate(1, 1);
        second = new Maze(graph, 2, 2, start, end);

    }

    @Test
    public void generateMaze() {

        maze.generate(start, end);

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                assertTrue(maze.graph[y][x] == 1 || maze.graph[y][x] == 0);
            }
        }
    }

    @Test
    public void setGraphWorks() {
        int[][] gr = {
            {1, 1},
            {1, 1},};
        this.second.setGraph(gr);
        assertTrue(this.second.graph[0][0] == 1);
        assertTrue(this.second.graph[0][1] == 1);
        assertTrue(this.second.graph[1][0] == 1);
        assertTrue(this.second.graph[1][1] == 1);

    }

}
