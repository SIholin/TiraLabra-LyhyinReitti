
package lyhyinreitti.tests.dataStructures;

import lyhyinreitti.dataStructures.Random;
import org.junit.Test;


public class RandomTest {
    
    private Random random;
    
    public RandomTest() {
        random = new Random(System.nanoTime(), 
                System.identityHashCode(RandomTest.class)); 
    }
    
     @Test 
    public void randomIntWorks() {
        System.out.println("Satunnainen numero 1000 on " + random.getRandomInt(1000) + "\n");
         
    }
    
    @Test
    public void randomBooleanWorks() {
        System.out.println("Satunnaine totuusarvo on " + random.getRandomBoolean());
        
    }
}
