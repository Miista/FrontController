package net.palmund.patterns.frontcontroller;

public class CommandNotFoundException extends Exception {
	private static final long serialVersionUID = 3252150274654687824L;
	
	public CommandNotFoundException() {
		this("CommandNotFoundException");
	}

	public CommandNotFoundException(String message) {
		super(message);
	}
}