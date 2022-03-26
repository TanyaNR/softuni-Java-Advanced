package OOP.O7_ReflectionAndAnnotation.barracksWars_3;

import OOP.O7_ReflectionAndAnnotation.barracksWars_3.interfaces.Repository;
import OOP.O7_ReflectionAndAnnotation.barracksWars_3.interfaces.Runnable;
import OOP.O7_ReflectionAndAnnotation.barracksWars_3.interfaces.UnitFactory;
import OOP.O7_ReflectionAndAnnotation.barracksWars_3.core.Engine;
import OOP.O7_ReflectionAndAnnotation.barracksWars_3.core.factories.UnitFactoryImpl;
import OOP.O7_ReflectionAndAnnotation.barracksWars_3.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
