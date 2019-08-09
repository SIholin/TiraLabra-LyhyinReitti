package lyhyinreitti.algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Solve the shortest path in the Maze with A* algorithm.
 */
public class AStar extends Algorithm {

    /**
     * Constructor of AStar class.
     * @param maze given maze
     */
    public AStar(Maze maze) {
        super(maze);
    }
    
    /**
     * Do the A* calculation.
     * 
     * @return the path which contains those coordinates which are in the 
     * shortest path or null if it is not possible to solve.
     */
    public ArrayList<Coordinate> solve() {
        
        if (maze.graph[maze.start.x][maze.start.y] == 0 || maze.graph[maze.end.x][maze.end.y] == 0) {
            System.out.println("Labyrintti on mahdoton");
            return null;
        }
        
        Coordinate[][] paths = new Coordinate[maze.width][maze.height];
        PriorityQueue<Estimate> queue = new PriorityQueue();
        queue.add(new Estimate(maze.start, maze.start.distance(maze.end)));

        while (!queue.isEmpty()) {
            Coordinate pos = queue.poll().coordinate;

            if (pos.equals(maze.end)) {
                // finish
                break;
            }

            Coordinate next;

            // left
            next = pos.left();
            if (this.isInside(next)) {
                if (paths[next.x][next.y] == null && maze.at(next)) {
                    paths[next.x][next.y] = pos;
                    queue.add(new Estimate(next, next.distance(maze.end)));
                }
            }

            // right
            next = pos.right();
            if (this.isInside(next)) {
                if (paths[next.x][next.y] == null && maze.at(next)) {
                    paths[next.x][next.y] = pos;
                    queue.add(new Estimate(next, next.distance(maze.end)));
                }
            }

            // up
            next = pos.up();
            if (this.isInside(next)) {
                if (paths[next.x][next.y] == null && maze.at(next)) {
                    paths[next.x][next.y] = pos;
                    queue.add(new Estimate(next, next.distance(maze.end)));
                }

            }

            // down
            next = pos.down();
            if (this.isInside(next)) {
                if (paths[next.x][next.y] == null && maze.at(next)) {
                    paths[next.x][next.y] = pos;
                    queue.add(new Estimate(next, next.distance(maze.end)));
                }
            }
        }

        if (paths[maze.end.x][maze.end.y] == null) {
            return null; // no route found
        }
        
        

        Coordinate current = paths[maze.end.x][maze.end.y],
                start = maze.start;
        ArrayList<Coordinate> inversePath = new ArrayList();
        inversePath.add(maze.end);
        while (!current.equals(start)) {
            inversePath.add(current);
            current = paths[current.x][current.y];
        } 
        inversePath.add(start);
        return inversePath; // todo reverse
    }
    
    /**
     * Check if the given coordinate is inside the maze.
     * @param c coordinate which is checked.
     * @return true if it is inside and false if it is not.
     */
    private boolean isInside(Coordinate c) {
        return c.x >= 0 && c.x < maze.width && c.y >= 0 && c.y < maze.height;
    }
}
