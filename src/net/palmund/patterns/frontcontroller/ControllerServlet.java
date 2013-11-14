/*
 * Copyright 2013 (C) S¿ren Palmund
 * 
 * Licensed under the License described in LICENSE (the "License"); you may not
 * use this file except in compliance with the License.
 */

package net.palmund.patterns.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String PARAMETER_NAME;

	private FrontController<Command> frontController;

	public ControllerServlet(String parameterName, FrontController<Command> frontController) {
		this.frontController = frontController;
		this.PARAMETER_NAME = parameterName;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter(PARAMETER_NAME);
		Command command = null;
		try {
			command = frontController.findCommand(key);
		} catch (CommandNotFoundException e) {
			onCommandNotFound(e, request, response);
		}
		executeCommand(command, request, response);
	}

	private void executeCommand(Command command, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (isSessionAuthorized(request, response) || isSessionAuthorizeAttempt(command)) {
			try {
				String target = command.execute(request, response);
				RequestDispatcher dispatcher = request.getRequestDispatcher(target);
				dispatcher.forward(request, response);
			} catch (CouldNotExecuteCommand e) {
				onCouldNotExecuteCommand(e, request, response);
			}
		} else {
			onSessionNotAuthorized(request, response);
		}
	}

	/**
	 * Answers whether the current request is an authorization attempt.
	 * Returns <code>true</code> by default to allow all requests to pass
	 * through.
	 * 
	 * @param command
	 * @return <code>true</code> if the request is an attempt to log in
	 */
	private boolean isSessionAuthorizeAttempt(Command command) {
		return true;
	}

	/**
	 * Answers whether the session is already authorized.
	 * Returns <code>true</code> by default to allow all requests to pass
	 * through.
	 * 
	 * @param request
	 * @param response
	 * @return <code>true</code> if the session is authorized
	 */
	private boolean isSessionAuthorized(HttpServletRequest request,
			HttpServletResponse response) {
		return true;
	}

	protected void onCouldNotExecuteCommand(CouldNotExecuteCommand e, HttpServletRequest request, HttpServletResponse response) {

	}

	protected void onCommandNotFound(CommandNotFoundException e, HttpServletRequest request, HttpServletResponse response) {

	}

	protected void onSessionNotAuthorized(HttpServletRequest request, HttpServletResponse response) {

	}

	/**
	 * Returns the name of the first responder. In other words the name of the
	 * {@link Command} to be executed when a client loads the application for the
	 * first time
	 * 
	 * @return
	 */
	protected String getNameOfFirstResponder() {
		return "index";
	}
}