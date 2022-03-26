package barracksWars_5;

import barracksWars_5.interfaces.Repository;
import barracksWars_5.interfaces.Runnable;
import barracksWars_5.interfaces.UnitFactory;
import barracksWars_5.core.Engine;
import barracksWars_5.core.factories.UnitFactoryImpl;
import barracksWars_5.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
