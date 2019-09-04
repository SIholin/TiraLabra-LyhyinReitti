package lyhyinreitti.dataStructures;

/**
 * Own version of ArrayList and ArrayDeque
 */
public class Vector {

    private Coordinate[] list;
    private int last;

    public Vector(int sizeOfList) {
        list = new Coordinate[sizeOfList];
        last = 0;
    }

    /**
     * Adds coordinate to the Coordinate[] list.
     * @param coordinate which is added to list
     */
    public void add(Coordinate coordinate) {
        if (last == (list.length - 1)) {
            increaseSize();
        }
        list[last] = coordinate;
        last++;
    }
    
    /**
     * Increases the size of the list.
     */
    public void increaseSize() {
        Coordinate[] newList = new Coordinate[list.length * 2];

        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }

        list = newList;
    }

    public Coordinate[] getList() {
        return list;
    }
    

    /**
     * Returns how many objects are in array.
     * @return amount of objects
     */
    public int size() {
        return last;
    }

    /**
     *  Deletes head of the queue and returns it.
     * @return c a Coordinate which is deleted from list
     */
    public Coordinate poll() {
        Coordinate c = null;
        Coordinate[] newList = new Coordinate[list.length];

        if (last > 0) {
            for (int i = 0; i < last; i++) {
                newList[i] = list[i + 1];
            }
        }
        last = last -1;
        c = list[0];
        list = newList;
        
        return c;
    }
}
