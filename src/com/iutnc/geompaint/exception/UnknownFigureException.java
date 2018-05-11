package com.iutnc.geompaint.exception;

@SuppressWarnings("serial")
public class UnknownFigureException extends Exception {
	
	public UnknownFigureException() {
		super("Unknown Figure");
	}
	
	public UnknownFigureException(String msg) {
		super(msg);
	}
	
}
