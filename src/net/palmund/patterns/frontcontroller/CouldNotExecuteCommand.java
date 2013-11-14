/*
 * Copyright 2013 (C) S¿ren Palmund
 * 
 * Licensed under the License described in LICENSE (the "License"); you may not
 * use this file except in compliance with the License.
 */

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