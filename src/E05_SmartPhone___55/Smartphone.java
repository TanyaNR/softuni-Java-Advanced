package E05_SmartPhone___55;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable {
    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = new ArrayList<>();
        this.urls = new ArrayList<>();
    }


    @Override
    public String browse() {
        return null;
    }

    @Override
    public String call() {

        return null;
    }
}
