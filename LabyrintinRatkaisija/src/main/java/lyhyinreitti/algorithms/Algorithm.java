/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyhyinreitti.algorithms;

import java.util.ArrayList;

/**
 *
 * @author ihqsanna
 */
public abstract class Algorithm {
    
    final Maze maze;
    
    public Algorithm(Maze maze) {
        this.maze = maze;
    }
    
    public abstract ArrayList<Coordinate> solve();
}
