package OOP.O7_ReflectionAndAnnotation.barracksWars_4.models.units;

public class Gunner extends AbstractUnit{

    private static final int GUNNER_HEALTH = 20;
    private static final int GUNNER_DAMAGE = 20;

    protected Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
}
