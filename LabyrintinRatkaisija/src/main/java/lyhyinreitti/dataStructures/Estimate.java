package lyhyinreitti.dataStructures;

import lyhyinreitti.dataStructures.Coordinate;

/**
 * Helps A* compare which coordinate has lowest estimate 
 */
public class Estimate implements Comparable<Estimate>{
    public final Coordinate coordinate;
    public final int estimate;
    
    /**
     * Constructor of Estimate class.
     * @param coordinate 
     * @param estimate 
     */
    public Estimate(Coordinate coordinate, int estimate) {
        this.coordinate = coordinate;
        this.estimate = estimate;
    }

    /**
     * Compare two estimates.
     * @param o estimate which is compared current estimate.
     * @return difference between estimates
     */
    @Override
    public int compareTo(Estimate o) {
        return this.estimate - o.estimate;
    }
}
