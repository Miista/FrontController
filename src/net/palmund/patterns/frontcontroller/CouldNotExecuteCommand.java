package net.palmund.patterns.frontcontroller;

public class CouldNotExecuteCommand extends Exception {
	private static final long serialVersionUID = -5235422858879539453L;

	public CouldNotExecuteCommand() {
		this("CouldNotExecuteCommand");
	}

	public CouldNotExecuteCommand(String message) {
		super(message);
	}
}