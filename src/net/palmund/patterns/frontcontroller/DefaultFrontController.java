/*
 * Copyright 2013 (c) S�ren Palmund
 * 
 * Licensed under the License described in LICENSE (the "License"); you may not
 * use this file except in compliance with the License.
 */

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