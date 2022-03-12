package Advanced.O8_IteratorsAndComparators.E1_E2_ListyIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
    private List<String> datas;
    private int index;

    public ListyIterator(List<String> data) {
        this.datas = data;
        if (data.isEmpty()) {
            this.index = -1;
        } else {
            this.index = 0;
        }
    }

    public List<String> getData() {
        return datas;
    }

    public void setData(List<String> data) {
        this.datas = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean move() {
        if (this.index < getData().size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index < datas.size() - 1;
    }


    public void print() throws Exception {
        if (datas.isEmpty()) {
            throw new Exception("Invalid Operation!");
        } else {
            System.out.println(datas.get(this.index));
        }
    }

    public void printAll() {
        if (datas.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            for (String data : this.datas) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index <= datas.size()-1;
            }

            @Override
            public String next() {
                String data = datas.get(index);
                index++;
                return data;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<String> spliterator() {
        return Iterable.super.spliterator();
    }
}
