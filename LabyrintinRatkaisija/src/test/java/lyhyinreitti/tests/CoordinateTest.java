package lyhyinreitti.tests;

import lyhyinreitti.dataStructures.Coordinate;
import lyhyinreitti.dataStructures.Coordinate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoordinateTest {

    private Coordinate coordinate;

    public CoordinateTest() {
        this.coordinate = new Coordinate(1, 2);
    }

    @Test
    public void isEquals() {

        Coordinate c = new Coordinate(1, 2);

        assertTrue(coordinate.equals(c));
    }

    @Test
    public void isNotEqualsYIsWrong() {

        Coordinate c = new Coordinate(1, 0);
        
        assertFalse(coordinate.equals(c));
    }
    
    @Test
    public void isNotEqualsXIsWrong() {

        Coordinate c = new Coordinate(4, 2);
        
        assertFalse(coordinate.equals(c));
    }
    
    @Test
    public void isNotEqualsIsNull() {

        Coordinate c = null;
        
        assertFalse(coordinate.equals(c));
    }
    
    @Test
    public void isNotEqualsWrongClass() {

        int c = 1;
        
        assertFalse(coordinate.equals(c));
    }
    
     @Test
    public void isCurrentCoordinate() {
        assertTrue(coordinate.equals(coordinate));
    }
    

    @Test
    public void returnsDown() {
        Coordinate down = new Coordinate(0, 2);
        assertTrue(coordinate.down().equals(down));
    }

    @Test
    public void returnsUp() {
        Coordinate up = new Coordinate(2, 2);
        assertTrue(coordinate.up().equals(up));
    }
    
    @Test
    public void returnsRight(){
        Coordinate right = new Coordinate(1, 3);
        assertTrue(coordinate.right().equals(right));
    }
    
    @Test
    public void returnsLeft(){
        Coordinate left = new Coordinate(1, 1);
        assertTrue(coordinate.left().equals(left));
    }
    
    @Test
    public void setDistanceWorks() {
        coordinate.setDistance(4);
        assertTrue(coordinate.dist == 4);
    }

}
