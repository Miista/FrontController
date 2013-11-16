/*
 * Copyright 2013 (c) S¿ren Palmund
 * 
 * Licensed under the License described in LICENSE (the "License"); you may not
 * use this file except in compliance with the License.
 */

package net.palmund.patterns.frontcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	String execute(HttpServletRequest request, HttpServletResponse response) throws CouldNotExecuteCommand;
}