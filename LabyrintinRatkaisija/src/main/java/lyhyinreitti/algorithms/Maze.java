package lyhyinreitti.algorithms;

import java.util.Random;

/**
 * Contains important information about the maze.
 */
public class Maze {

    public int[][] graph;
    public final int width;
    public final int height;
    public final Coordinate start;
    public final Coordinate end;

    /**
     * Constructor of Maze class
     *
     * @param graph the maze
     * @param width width of the maze
     * @param height height of the maze
     * @param start coordinate where the start is
     * @param end coordinate where the goal is
     */
    public Maze(
            int[][] graph,
            int width,
            int height,
            Coordinate start,
            Coordinate end
    ) {
        this.graph = graph;
        this.width = width;
        this.height = height;
        this.start = start;
        this.end = end;
    }

    /**
     * Check if given coordinate contains 1.
     *
     * @param c Coordinate which is checked
     * @return true if coordinate contains 1 and false if not
     */
    public boolean at(Coordinate c) {
        return graph[c.x][c.y] == 1;
    }

    
//    private boolean isInside(Coordinate c) {
//        return c.x >= 0 && c.x < width && c.y >= 0 && c.y < height;
//    }

    /**
     * Generates random maze
     *
     * @param ul upper left cell
     * @param dr down right cell
     */
    public void generate(Coordinate ul, Coordinate dr) {
        Random rng = new Random();
        boolean vertical = rng.nextBoolean(); // vertical/horizontal line

        int min, max;
        if (vertical) {
            min = ul.x;
            max = dr.x;
        } else {
            min = ul.y; // meneekö oikein päin
            max = dr.y;
        }

        if ((dr.x - ul.x <= 2) && (dr.y - ul.y <= 2) || min >= max) {
            graph[0][0] = 1;
            graph[height -1][width-1] = 1;
            return;
        }

        int split = min + rng.nextInt(max - min + 1);
       
        if (vertical) { // draw lines

            for (int i = ul.y; i <= dr.y; i++) {
                int cell = graph[i][split];
                if (cell != 1) {
                    graph[i][split] = 0;
                }
                
            }

            int r = rng.nextInt(dr.y - ul.y + 1) + ul.y;

            graph[r][split] = 1;

            // make a hole
           

            Coordinate leftbox, rightbox;
            leftbox = new Coordinate(dr.y, split);
            rightbox = new Coordinate(ul.y, split);

            generate(ul, leftbox);
            generate(rightbox, dr);
        } else {
            for (int i = ul.x; i <= dr.x; i++) {
                int cell = graph[split][i];
                if (cell != 1) {
                    graph[split][i] = 0;
                }
              
            }
            int r = rng.nextInt(dr.x - ul.x + 1) + ul.x;

            graph[split][r] = 1;

            // make a hole
         
            Coordinate downBox, upperBox;
            upperBox = new Coordinate(split, dr.x);
            downBox = new Coordinate(split, ul.x);

            generate(ul, upperBox);
            generate(downBox, dr);

        }

        // call generate on both sides of the line
    }

    public void setGraph(int[][] graph) {
        this.graph = graph;
    }

}
