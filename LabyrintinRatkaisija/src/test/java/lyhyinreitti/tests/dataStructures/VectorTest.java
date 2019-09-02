
package lyhyinreitti.tests.dataStructures;

import lyhyinreitti.dataStructures.Coordinate;
import lyhyinreitti.dataStructures.Vector;
import org.junit.Test;
import static org.junit.Assert.*;


public class VectorTest {
    Vector myList;
    
    public VectorTest() {
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
    
    @Test
    public void getListTest() {
        this.myList.add(new Coordinate(1, 1));
        Coordinate[] cs = this.myList.getList();
        assertTrue(cs[0].equals(new Coordinate(1,1)));
    }
    
  
}
