package lyhyinreitti.tests;

import lyhyinreitti.dataStructures.Coordinate;
import lyhyinreitti.dataStructures.Estimate;
import lyhyinreitti.dataStructures.MyQueue;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyQueueTest {
    
    MyQueue myQueue;
    
    public MyQueueTest() {
        this.myQueue = new MyQueue(1);
    }
    
    @Test
    public void addEstimateAndIncrease() {
        Estimate first = new Estimate(new Coordinate(0, 1), 3);
        Estimate second = new Estimate(new Coordinate(1, 1), 4);
        Estimate third = new Estimate(new Coordinate(3, 3), 1);
        
        this.myQueue.add(first);
        this.myQueue.add(second);
        this.myQueue.add(third);
        
        assertTrue(this.myQueue.getLast() == 3);
    }
    
    @Test
    public void compareEstimate() {
        Estimate e = new Estimate(new Coordinate(1, 1), 8);
        Estimate est = new Estimate(new Coordinate(2, 6), 6);
        
        assertTrue(e.compareTo(est) == 2);
    }
   
}
