package lyhyinreitti.dataStructures;

/**
 * 
 * Own version of PriorityQueue class.
 * @param <C>
 */
public class MyQueue<C> {

    private Estimate[] queue;
    private int last;

    public MyQueue(int size) {
        queue = new Estimate[size];
        last = 0;
    }
    /**
     * Adds estimate to the Estimate[] queue. After this the queue is correct 
     * order estimate with smallest estimate is first and highest is last. 
     * @param estimate which is added to the queue.
     */
    public void add(Estimate estimate) {
        if (last == (queue.length - 1)) {
            increaseSize();

        }
        queue[last] = estimate;

        if (last > 0) {
            for (int i = last - 1; i >= 0; i--) {
                Estimate current = queue[i];
                Estimate erlier = queue[i + 1];
                if (current.estimate > erlier.estimate) {
                    queue[i] = erlier;
                    queue[i + 1] = current;
                    break;
                }
            }
        }
        last ++;
    }

    /**
     * Increases the size of the list.
     */
    public void increaseSize() {
        Estimate[] newQueue = new Estimate[queue.length * 2];

        for (int i = 0; i < queue.length; i++) {
            newQueue[i] = queue[i];
        }

        queue = newQueue;
    }
    
    /**
     * Return and remove first one from the queue.
     * @return estimate with smallest estimate.
     */
    public Estimate poll() {
        Estimate e = null;
        Estimate[] newQueue = new Estimate[queue.length];
        
        if (last > 0) {
            for(int i = 0; i < last; i ++) {
                newQueue[i] = queue[i +1]; 
            }
        }
        last--;
        e = queue[0];
        queue = newQueue;
        
        return e;
    }

    public int getLast() {
        return last;
    }
    
        
    
}
