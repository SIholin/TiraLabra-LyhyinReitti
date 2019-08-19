package lyhyinreitti.dataStructures;

/**
 * Coordinates of the maze.
 */
public class Coordinate {
    
    public final int x, y;
    public int dist;
    
    public Coordinate(int y, int x) {
        this.x = x;
        this.y = y;
        this.dist = -1;
    }
    
    /**
    * Returns the coordinate that is left side of the current coordinate.
    */
    public Coordinate left(){
        return new Coordinate(y, x -1);
    }
    
    public void setDistance(int dist) {
        this.dist = dist;
    }
    /**
    * Returns the coordinate that is right side of the current coordinate.
    */
    public Coordinate right(){
        return new Coordinate(y, x + 1);
    }
    
    /**
    * Returns the coordinate above the current coordinate.
    */
    public Coordinate up(){
        return new Coordinate(y + 1, x);
    }
    
    /**
    * Returns the coordinate below the current coordinate.
    */
    public Coordinate down(){
        return new Coordinate(y - 1, x);
    }
    
    /**
     * Solve which is the heuristic value for current coordination
     * 
     * @param other The other coordinate which the current coordinate is 
     * compared.
     * @return current coordinates heuristic value. 
     */
    public int distance(Coordinate other) {
        return Math.abs(y - other.y) + Math.abs(x - other.x);
    }
    
    /**
     * Check if the two coordinates are equals. 
     * @param obj given Coordinate.
     * @return true if they are same and false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordinate other = (Coordinate) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
    
}
