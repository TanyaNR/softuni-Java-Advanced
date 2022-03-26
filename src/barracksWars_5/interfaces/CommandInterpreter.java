package barracksWars_5.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
