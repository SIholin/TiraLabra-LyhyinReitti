package lyhyinreitti.dataStructures;

/**
 * Own version of Random class.
 */
public class Random {

    private long status;
    private long index;

    public Random(long status, long index) {

        this.status = 0;
        this.index = 2 * index + 1;
        nextInt();
        this.status += status;
        nextInt();
    }

    /**
     * Returns random int value between 0 and max value.
     *
     * @param max value
     * @return random int value
     */
    public int getRandomInt(int max) {

        int bits, randomInt;
        do {
            bits = nextInt() >>> 1;
            randomInt = bits % max;

        } while (bits - randomInt + (max - 1) < 0);
        return randomInt;        
    }

    /**
     * Helps getRandomInt method. 
     *
     * @return int value of rotation.
     */
    private int nextInt() {
        long oldStatus = status;
        int shiftedStatus = (int) (((oldStatus >>> 15) ^ oldStatus));
        int distance = (int) (oldStatus >>> 34);
        status = (int) (oldStatus * 5940410294853729438L + index);
        return Integer.rotateRight(shiftedStatus, distance);

    }

    /**
     * Returns random boolean value.
     * 
     * @return true if random int is even and false if not.
     */
    public boolean getRandomBoolean() {
        return getRandomInt(20) % 2 == 0;
        
        
    }

}
