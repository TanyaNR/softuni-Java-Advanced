package OOP.O3_Inheritance.O6_StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        int index = this.data.size() - 1;
        String data = this.data.get(index);
        this.data.remove(data);
        return data;
    };

    public String peek() {
        int index = this.data.size() - 1;
        String data = this.data.get(index);
        return data;
    };

    public boolean isEmpty() {
        return this.data.isEmpty();
    };
}
