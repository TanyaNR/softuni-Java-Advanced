package OOP.O7_ReflectionAndAnnotation.barracksWars_4;

import OOP.O7_ReflectionAndAnnotation.barracksWars_4.interfaces.Repository;
import OOP.O7_ReflectionAndAnnotation.barracksWars_4.interfaces.Runnable;
import OOP.O7_ReflectionAndAnnotation.barracksWars_4.interfaces.UnitFactory;
import OOP.O7_ReflectionAndAnnotation.barracksWars_4.core.Engine;
import OOP.O7_ReflectionAndAnnotation.barracksWars_4.core.factories.UnitFactoryImpl;
import OOP.O7_ReflectionAndAnnotation.barracksWars_4.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
