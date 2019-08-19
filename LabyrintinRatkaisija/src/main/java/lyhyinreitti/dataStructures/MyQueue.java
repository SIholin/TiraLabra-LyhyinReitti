package lyhyinreitti.dataStructures;

public class MyQueue<C> {

    private Estimate[] queue;
    private int last;

    public MyQueue(int size) {
        queue = new Estimate[size];
        last = 0;
    }

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
    }

    public void increaseSize() {
        Estimate[] newQueue = new Estimate[queue.length * 2];

        for (int i = 0; i < queue.length; i++) {
            newQueue[i] = queue[i];
        }

        queue = newQueue;
    }
}
