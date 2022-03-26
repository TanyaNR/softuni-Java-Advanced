package barracksWars_5.core.factories;

import barracksWars_5.interfaces.Unit;
import barracksWars_5.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		try {
			Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<?> constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			return (Unit) constructor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
