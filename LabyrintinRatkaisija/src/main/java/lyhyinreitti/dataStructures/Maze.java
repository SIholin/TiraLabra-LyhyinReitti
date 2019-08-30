package lyhyinreitti.dataStructures;

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
        return graph[c.y][c.x] == 1;
    }
    
    /**
     * Checks if next line will be vertical or horizontal.
     * 
     * @param w sectors width
     * @param h sectors height
     * @return true if next line will be vertical and false if horizontal
     */
    private boolean isNextVertical(int w, int h) {
        if(w > h)
            return true;
        else if (w < h)
            return false;
        else
            return new Random(System.nanoTime(), System.identityHashCode(Maze.class)).getRandomBoolean();
    }

    /**
     * Generates random maze
     *
     * @param ul upper left cell
     * @param dr down right cell
     */
    public void generate(Coordinate ul, Coordinate dr) {
        Random rng = new Random(System.nanoTime(), System.identityHashCode(Maze.class));
        int width = dr.x - ul.x;
        int height = dr.y - ul.y;
        
        boolean vertical = isNextVertical(width, height);

        int min, max;
        if (vertical) {
            min = ul.x;
            max = dr.x;
        } else {
            min = ul.y;
            max = dr.y;
        }

        if (max - min < 2) return;

        int split = min + 1 + rng.getRandomInt(max - min - 1); // [min+1, max-1]
       
        Coordinate box1, box2;
        if (vertical) {
            if(height < 2) return;

            for (int i = ul.y; i <= dr.y; i++)
                graph[i][split] = 0;

            int r = ul.y + rng.getRandomInt(height);

            graph[r][split] = 1;
            graph[r+1][split] = 1;

            box1 = new Coordinate(dr.y, split - 1);
            box2 = new Coordinate(ul.y, split + 1);
        } else {
            if(width < 2) return;
            
            for (int i = ul.x; i <= dr.x; i++) 
                graph[split][i] = 0;
            
            int r = rng.getRandomInt(width) + ul.x;

            graph[split][r] = 1;
            graph[split][r+1] = 1;

            box1 = new Coordinate(split - 1, dr.x);
            box2 = new Coordinate(split + 1, ul.x);
        }

        generate(ul, box1);
        generate(box2, dr);
    }

    public void setGraph(int[][] graph) {
        this.graph = graph;
    }
}
