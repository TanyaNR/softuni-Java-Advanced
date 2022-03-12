package OOP.O3_Inheritance.O5_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    public Object getRandomElement() {
        int index = new Random().nextInt(super.size());
        return super.remove(index);

    }
}
