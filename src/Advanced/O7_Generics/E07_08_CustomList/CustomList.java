package Advanced.O7_Generics.E07_08_CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> {
    private List<T> elements = new ArrayList<>();


    //•	void add(T element)
    public void add(T element) {
        this.elements.add(element);
    }

    //•	T remove(int index)
    public T remove(int index) {
        return elements.remove(index);
    }

    //•	boolean contains(T element)
    public boolean contains(T element) {
        if (this.elements.contains(element)) {
            return true;
        }
        return false;
    }
//•	void swap(int index, int index)
    public void swap(int firstSwapIndex, int secondSwapIndex) {
        T firstSwapElement = this.elements.get(firstSwapIndex);
        T secondSwapElement = this.elements.get(secondSwapIndex);
        this.elements.set(firstSwapIndex, secondSwapElement);
        this.elements.set(secondSwapIndex, firstSwapElement);
    }
//•	int countGreaterThan(T element)
        public int countGreatThan (T element) {
            int count = 0;
            for (T elementInList : elements) {
                if (elementInList.compareTo(element) > 0) {
                    count ++;
                }
            }
            return count;
        }
//•	T getMax()
        public T getMax() {
           return Collections.max(this.elements);
        }
//•	T getMin()
        public T getMin() {
            return Collections.min(this.elements);
        }

        public void print () {
            for (T element : this.elements) {
                System.out.println(element);
            }
        }

    public void sort() {
       Collections.sort(this.elements);
    }
}
