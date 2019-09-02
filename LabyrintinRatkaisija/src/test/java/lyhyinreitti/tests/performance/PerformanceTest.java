package lyhyinreitti.tests.performance;

import java.util.Arrays;
import lyhyinreitti.algorithms.AStar;
import lyhyinreitti.algorithms.BreadthFirstSearch;
import lyhyinreitti.dataStructures.Coordinate;
import lyhyinreitti.dataStructures.Maze;
import org.junit.Test;

public class PerformanceTest {

    private Maze maze;
    private AStar astar;
    private BreadthFirstSearch bfs;
    private Coordinate begin;
    private Coordinate end;
    private int[][] graph;

    public PerformanceTest() {
        this.graph = new int[1000][1000];

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
        formatGraph();
        this.maze.setGraph(graph);
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
        printTime(timesAstar[timesAstar.length / 2] / 1000000000.0 + " sekuntia", "A* algoritmin ",
                "samanlaisessa");
        printSmallestAndBiggest(timesAstar[0] / 1000000000.0 + " sekuntia",
                timesAstar[99] / 1000000000.0 + " sekuntia");

        Arrays.sort(timesBFS);
        printTime(timesBFS[timesBFS.length / 2] / 1000000000.0 + " sekuntia", "leveyssuuntaisenhaku algoritmin ",
                "samanlaisessa");
        printSmallestAndBiggest(timesBFS[0] / 1000000000.0 + " sekuntia",
                timesBFS[99] / 1000000000.0 + " sekuntia");
    }

    @Test
    public void differentMazeTime() {
        int runTimes = 100;
        long[] timesAstar = new long[runTimes];
        long[] timesBFS = new long[runTimes];

        long start, duration;

        for (int i = 0; i < runTimes; i++) {
            formatGraph();
            this.maze.setGraph(graph);
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
        printTime(timesAstar[timesAstar.length / 2] / 1000000000.0 + " sekuntia", "A* algoritmin ",
                "erilaisessa");
        printSmallestAndBiggest(timesAstar[0] / 1000000000.0 + " sekuntia",
                timesAstar[99] / 1000000000.0 + " sekuntia");

        Arrays.sort(timesBFS);
        printTime(timesBFS[timesBFS.length / 2] / 1000000000.0 + " sekuntia", "leveyssuuntaisenhaku "
                + "algoritmin ", "erilaisessa");
        printSmallestAndBiggest(timesBFS[0] / 1000000000.0 + " sekuntia",
                timesBFS[99] / 1000000000.0 + " sekuntia");

    }

    @Test
    public void generateTime() {
        int runTimes = 100;
        long[] timesGenerate = new long[runTimes];

        long start, duration;

        for (int i = 0; i < runTimes; i++) {
            formatGraph();
            this.maze.setGraph(graph);
            start = System.nanoTime();

            this.maze.generate(begin, end);

            duration = System.nanoTime() - start;
            timesGenerate[i] = duration;
        }

        Arrays.sort(timesGenerate);
        printTime(timesGenerate[timesGenerate.length / 2] / 1000000.0
                + " millisekuntia", "labyrintin generoinnin ", "erilaisessa");

        printSmallestAndBiggest(timesGenerate[0]
                / 1000000.0 + " millisekuntia", timesGenerate[99] / 1000000.0
                + " millisekuntia");
    }

    private void formatGraph() {
        for (int[] line : graph) {
            for (int i = 0; i < line.length; i++) {
                line[i] = 1;
            }
        }
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

    @Test
    public void maximSizeOfQueue() {
        formatGraph();
        this.maze.setGraph(graph);
        this.maze.generate(begin, end);

        astar.solve();

        System.out.println("Tällä kertaa A* algortimin maksimi määrä keossa "
                + "saman aikaisesti oli " + astar.getMaxSize());
        System.out.println("");
         bfs.solve();

        System.out.println("Tällä kertaa leveyssuuntainenhaku algortimin maksimi määrä keossa "
                + "saman aikaisesti oli " + bfs.getMaxSize());
        System.out.println("");
    }

    @Test
    public void visitedCells() {
        formatGraph();
        this.maze.setGraph(graph);
        this.maze.generate(begin, end);
        astar.solve();

        System.out.println("Tällä kertaa A* algortimin suorituksen aikana "
                + "vierailtiin " + astar.getVisited() + " solmussa.");
        System.out.println("");
            bfs.solve();

        System.out.println("Tällä kertaa leveyssuuntainenhaku algortimin suorituksen aikana "
                + "vierailtiin " + bfs.getVisits() + " solmussa.");
        System.out.println("");
    }
}
