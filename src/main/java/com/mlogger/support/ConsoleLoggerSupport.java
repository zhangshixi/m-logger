package com.mlogger.support;

import com.mlogger.Logger;

public class ConsoleLoggerSupport implements Logger {

	public ConsoleLoggerSupport(Class<?> clazz) {
	}
	
	@Override
	public boolean isTraceEnabled() {
		return true;
	}
	
	@Override
	public boolean isDebugEnabled() {
		return true;
	}
	
	@Override
	public boolean isInfoEnabled() {
		return true;
	}
	
	@Override
	public boolean isWarnEnabled() {
		return true;
	}
	
	@Override
	public boolean isErrorEnabled() {
		return true;
	}
	
	@Override
	public void trace(String message) {
		System.out.println(message);
	}
	
	@Override
	public void debug(String message) {
		System.out.println(message);
	}
	
	@Override
	public void info(String message) {
		System.out.println(message);
	}
	
	@Override
	public void warn(String message) {
		System.out.println(message);
	}
	
	@Override
	public void error(String message) {
		System.err.println(message);
	}

	@Override
	public void error(String message, Throwable ex) {
		System.err.println(message);
		if (ex != null) {
			ex.printStackTrace(System.err);
		}
	}
	
}
