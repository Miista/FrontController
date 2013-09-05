package net.palmund.patterns.frontcontroller;

public interface FrontController<T extends Command> {
	T findCommand(String name) throws CommandNotFoundException;
}