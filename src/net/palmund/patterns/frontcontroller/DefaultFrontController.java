package net.palmund.patterns.frontcontroller;

import java.util.Map;

public class DefaultFrontController implements FrontController<Command> {
	private Map<String, Command> commands;
	
	public DefaultFrontController(Map<String, Command> commands) {
		this.commands = commands;
	}
	
	@Override
	public Command findCommand(String name) throws CommandNotFoundException {
		if (commands.containsKey(name)) {
			return commands.get(name);
		}
		throw new CommandNotFoundException("No command for \""+name+"\" exists.");
	}
}