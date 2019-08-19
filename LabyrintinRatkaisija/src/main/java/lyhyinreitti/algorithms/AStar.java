package lyhyinreitti.algorithms;

import lyhyinreitti.dataStructures.Maze;
import lyhyinreitti.dataStructures.Estimate;
import lyhyinreitti.dataStructures.Coordinate;
import java.util.PriorityQueue;
import lyhyinreitti.dataStructures.Vector;

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
    @Override
    public Vector<Coordinate> solve() {
        
        if (maze.graph[maze.start.y][maze.start.x] == 0 || 
                maze.graph[maze.end.y][maze.end.x] == 0) {
            System.out.println("Labyrintti on mahdoton");
            return null;
        }
        
        Coordinate[][] paths = new Coordinate[maze.height][maze.width];
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
                if (paths[next.y][next.x] == null && maze.at(next)) {
                    paths[next.y][next.x] = pos;
                    queue.add(new Estimate(next, next.distance(maze.end)));
                }
            }

            // right
            next = pos.right();
            if (this.isInside(next)) {
                if (paths[next.y][next.x] == null && maze.at(next)) {
                    paths[next.y][next.x] = pos;
                    queue.add(new Estimate(next, next.distance(maze.end)));
                }
            }

            // up
            next = pos.up();
            if (this.isInside(next)) {
                if (paths[next.y][next.x] == null && maze.at(next)) {
                    paths[next.y][next.x] = pos;
                    queue.add(new Estimate(next, next.distance(maze.end)));
                }

            }

            // down
            next = pos.down();
            if (this.isInside(next)) {
                if (paths[next.y][next.x] == null && maze.at(next)) {
                    paths[next.y][next.x] = pos;
                    queue.add(new Estimate(next, next.distance(maze.end)));
                }
            }
        }

        if (paths[maze.end.y][maze.end.x] == null) {
            return null; // no route found
        }
        
        

        Coordinate current = paths[maze.end.y][maze.end.x],
                start = maze.start;
        Vector<Coordinate> inversePath = new Vector(10);
        inversePath.add(maze.end);
        while (!current.equals(start)) {
            inversePath.add(current);
            current = paths[current.y][current.x];
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
