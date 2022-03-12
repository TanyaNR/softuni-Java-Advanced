package Advanced.O7_Generics.E01_02_03_04_05_06_GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>>  {
    private List<T> elements;


    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T text) {
        elements.add(text);
    }


    @Override
    public String toString () {
        StringBuilder builder = new StringBuilder();
        for (T element : this.elements) {
            builder.append(element.getClass().getName() + ": ").append(element).append("\n");
        }
        return builder.toString();
    }

    public void swapElement(int firstSwapIndex, int secondSwapIndex) {
        T firstSwapElement = this.elements.get(firstSwapIndex);
        T secondSwapElement = this.elements.get(secondSwapIndex);
        this.elements.set(firstSwapIndex, secondSwapElement);
        this.elements.set(secondSwapIndex, firstSwapElement);
    }

    public int countGreatThan(T element) {
        int count = 0;
        for (T elementInList : this.elements) {
            if (elementInList.compareTo(element) > 0) {
                count ++;
            }
        }
        return count;
    }
}
