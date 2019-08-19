package lyhyinreitti.algorithms;

import lyhyinreitti.dataStructures.Maze;
import lyhyinreitti.dataStructures.Coordinate;
import lyhyinreitti.dataStructures.Vector;

public abstract class Algorithm {
    
    final Maze maze;
    
    public Algorithm(Maze maze) {
        this.maze = maze;
    }
    
    public abstract Vector<Coordinate> solve();
}
