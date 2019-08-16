package lyhyinreitti.dataStructures;

import lyhyinreitti.algorithms.Coordinate;

/**
 *
 * @author ihqsanna
 * @param <C>
 */
public class MyList<C> {

    private Coordinate[] list;
    private int last;

    public MyList(int sizeOfList) {
        list = new Coordinate[sizeOfList];
        last = 0;
    }

    public void add(Coordinate coordinate) {
        if (last == (list.length - 1)) {
            increaseSize();
        }
        list[last] = coordinate;
        last++;
    }

    public void increaseSize() {
        Coordinate[] newList = new Coordinate[list.length * 2];

        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }

        list = newList;
    }

    public void print() {
        for (int i = 0; i < last; i++) {
            Coordinate c = list[i];
            System.out.println("(" + c.x + "," + c.y + ")");
        }
    }

    public int size() {
        return last;
    }

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
