
package lyhyinreitti.tests;

import lyhyinreitti.dataStructures.Coordinate;
import lyhyinreitti.dataStructures.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MyListTest {
    Vector myList;
    
    public MyListTest() {
        this.myList = new Vector(1);
    }
    
    @Test
    public void addCoordinate() {
        Coordinate first = new Coordinate(1,1);
        this.myList.add(first);
        Coordinate second = new Coordinate(2,1);
        this.myList.add(second);
        Coordinate third = new Coordinate(2,2);
        this.myList.add(third);
        
        assertTrue(this.myList.size() == 3);
        
    }
    
  
}
