package com.task.service.exceptions;

public class ResourseNotFoundException extends RuntimeException {
	public ResourseNotFoundException(String msg) {
		super(msg);
	}
}
