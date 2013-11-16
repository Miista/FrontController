/*
 * Copyright 2013 (c) S¿ren Palmund
 * 
 * Licensed under the License described in LICENSE (the "License"); you may not
 * use this file except in compliance with the License.
 */

package net.palmund.patterns.frontcontroller;

public interface FrontController<T extends Command> {
	T findCommand(String name) throws CommandNotFoundException;
}