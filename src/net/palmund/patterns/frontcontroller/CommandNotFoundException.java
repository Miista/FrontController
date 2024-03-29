/*
 * Copyright 2013 (c) S�ren Palmund
 * 
 * Licensed under the License described in LICENSE (the "License"); you may not
 * use this file except in compliance with the License.
 */

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