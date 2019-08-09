package lyhyinreitti.algorithms;

/**
 * Coordinates of the maze.
 */
public class Coordinate {
    
    public final int x, y;
    public int dist;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        this.dist = -1;
    }
    
    /**
    * Returns the coordinate that is left side of the current coordinate.
    */
    public Coordinate left(){
        return new Coordinate(x - 1, y);
    }
    
    public void setDistance(int dist) {
        this.dist = dist;
    }
    /**
    * Returns the coordinate that is right side of the current coordinate.
    */
    public Coordinate right(){
        return new Coordinate(x + 1, y);
    }
    
    /**
    * Returns the coordinate above the current coordinate.
    */
    public Coordinate up(){
        return new Coordinate(x, y + 1);
    }
    
    /**
    * Returns the coordinate below the current coordinate.
    */
    public Coordinate down(){
        return new Coordinate(x, y - 1);
    }
    
    /**
     * Solve which is the heuristic value for current coordination
     * 
     * @param other The other coordinate which the current coordinate is 
     * compared.
     * @return current coordinates heuristic value. 
     */
    public int distance(Coordinate other) {
        return Math.abs(x - other.x) + Math.abs(y - other.y);
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
