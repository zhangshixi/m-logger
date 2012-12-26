package com.mlogger.support;

import com.mlogger.Logger;

public class VirtualLoggerSupport implements Logger {

	public VirtualLoggerSupport(Class<?> clazz) {
	}
	
	@Override
	public boolean isTraceEnabled() {
		return false;
	}

	@Override
	public boolean isDebugEnabled() {
		return false;
	}

	@Override
	public boolean isInfoEnabled() {
		return false;
	}

	@Override
	public boolean isWarnEnabled() {
		return false;
	}

	@Override
	public boolean isErrorEnabled() {
		return false;
	}

	@Override
	public void trace(String message) {
	}

	@Override
	public void debug(String message) {
	}
	
	@Override
	public void info(String message) {
	}
	
	@Override
	public void warn(String message) {
	}
	
	@Override
	public void error(String message) {
	}
	
	@Override
	public void error(String message, Throwable cause) {
	}

}
