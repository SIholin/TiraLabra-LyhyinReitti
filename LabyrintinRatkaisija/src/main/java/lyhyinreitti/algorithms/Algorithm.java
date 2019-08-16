package lyhyinreitti.algorithms;

import java.util.ArrayList;
import lyhyinreitti.dataStructures.MyList;

public abstract class Algorithm {
    
    final Maze maze;
    
    public Algorithm(Maze maze) {
        this.maze = maze;
    }
    
    public abstract MyList<Coordinate> solve();
}
