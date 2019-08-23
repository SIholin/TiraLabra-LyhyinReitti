package lyhyinreitti.tests;

import java.util.Arrays;
import lyhyinreitti.algorithms.AStar;
import lyhyinreitti.algorithms.BreadthFirstSearch;
import lyhyinreitti.dataStructures.Coordinate;
import lyhyinreitti.dataStructures.Maze;
import org.junit.Test;
import static org.junit.Assert.*;

public class PerformanceTest {

    private Maze maze;
    private AStar astar;
    private BreadthFirstSearch bfs;
    private Coordinate begin;
    private Coordinate end;

    public PerformanceTest() {
        int[][] graph = new int[1000][1000];

        begin = new Coordinate(0, 0);
        end = new Coordinate(999, 999);

        this.maze = new Maze(graph, 1000, 1000, begin, end);
        astar = new AStar(maze);
        bfs = new BreadthFirstSearch(maze);
    }

    @Test
    public void sameMazeTime() {
        int runTimes = 100;
        long[] timesAstar = new long[runTimes];
        long[] timesBFS = new long[runTimes];
        this.maze.generate(begin, end);
        long start, duration;

        for (int i = 0; i < runTimes; i++) {
            start = System.nanoTime();
            astar.solve();
            duration = System.nanoTime() - start;
            timesAstar[i] = duration;

            start = System.nanoTime();
            bfs.solve();
            duration = System.nanoTime() - start;
            timesBFS[i] = duration;
        }

        Arrays.sort(timesAstar);
        printTime(timesAstar[timesAstar.length / 2] / 1000.0 + " mikrosekuntia", "A*",
                "samanlaisessa");
        printSmallestAndBiggest(timesAstar[0] / 1000.0 + " mikrosekuntia", 
                timesAstar[99] / 1000.0 + " mikrosekuntia");

        Arrays.sort(timesBFS);
        printTime(timesBFS[timesBFS.length / 2] / 1000.0 + " mikrosekuntia", "leveyssuuntaisenhaku",
                "samanlaisessa");
        printSmallestAndBiggest(timesBFS[0] / 1000.0 + " mikrosekuntia", 
                timesBFS[99] / 1000.0 + " mikrosekuntia");
    }

    @Test
    public void differentMazeTime() {
        int runTimes = 100;
        long[] timesAstar = new long[runTimes];
        long[] timesBFS = new long[runTimes];

        long start, duration;

        for (int i = 0; i < runTimes; i++) {
            this.maze.generate(begin, end);

            start = System.nanoTime();
            astar.solve();
            duration = System.nanoTime() - start;
            timesAstar[i] = duration;

            start = System.nanoTime();
            bfs.solve();
            duration = System.nanoTime() - start;
            timesBFS[i] = duration;
        }

        Arrays.sort(timesAstar);
        printTime(timesAstar[timesAstar.length / 2] / 1000.0 + " mikrosekuntia", "A* algoritmin ",
                "erilaisessa");
        printSmallestAndBiggest(timesAstar[0] / 1000.0 + " mikrosekuntia",
                timesAstar[99] / 1000.0 + " mikrosekuntia");
        

        Arrays.sort(timesBFS);
        printTime(timesBFS[timesBFS.length / 2] / 1000.0 + " mikrosekuntia", "leveyssuuntaisenhaku "
                + "algoritmin ", "erilaisessa");
        printSmallestAndBiggest(timesBFS[0] / 1000.0 + " mikrosekuntia", 
                timesBFS[99] / 1000.0 + " mikrosekuntia");

    }

   

    @Test
    public void generateTime() {
        int runTimes = 100;
        long[] timesGenerate = new long[runTimes];

        long start, duration;

        for (int i = 0; i < runTimes; i++) {
            start = System.nanoTime();
            this.maze.generate(begin, end);
            duration = System.nanoTime() - start;
            timesGenerate[i] = duration;
        }

        Arrays.sort(timesGenerate);
        printTime(timesGenerate[timesGenerate.length / 2] / 1000000.0 
                + " millisekuntia", "labyrintin generoinnin ", "erilaisessa");

        printSmallestAndBiggest(timesGenerate[0] / 
                1000000.0 + " millisekuntia", timesGenerate[99] / 1000000.0
                + " millisekuntia");
    }
    
    private void printTime(String millis, String algo, String type) {
        System.out.println("Tällä kertaa " + algo + "suoritusajan mediaani "
                + "1000x1000 kokoisessa, joka toisto kerralla " + type 
                + " labyrintissä 100 kertaa toistettuna oli " + millis);
    }
    
    private void printSmallestAndBiggest(String smallest, String biggest) {
        System.out.println("Pienin kulunut aika " + smallest + " ja suurin "
                + "kulunut aika " + biggest);
        System.out.println("");
    }

}
