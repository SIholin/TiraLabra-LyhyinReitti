package lyhyinreitti.algorithms;

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
    
    /**
     * Prints the maze.
     */
    public void printGraph() {
        System.out.println("\nAntamasi labyrintti: ");
        for (int i = 0; i < this.height; i++) {
            printALineOfStart(i);
            System.out.println("");
        }
    }

    private void printALineOfStart(int i) {

        for (int y = 0; y < this.width; y++) {
            System.out.print(this.graph[y][i] + " ");
        }
    }
   

}
