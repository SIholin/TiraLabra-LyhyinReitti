package lyhyinreitti.algorithms;

import lyhyinreitti.dataStructures.Maze;
import lyhyinreitti.dataStructures.Vector;

/**
 * Abstract class for AStar and BreadthFIrstSearch classes. Tells must have 
 * methods and variables.
 */
public abstract class Algorithm {
    
    final Maze maze;
    
    public Algorithm(Maze maze) {
        this.maze = maze;
    }
    
    public abstract Vector solve();
}
