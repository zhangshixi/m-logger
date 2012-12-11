package com.mlogger.support;

import ch.qos.logback.classic.Logger;

public class LogbackLoggerSupport implements com.mlogger.Logger {

	private Logger log;
	
	public LogbackLoggerSupport(Class<?> clazz) {
		// TODO:
	}
	
	@Override
	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

	@Override
	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}

	@Override
	public boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}

	@Override
	public boolean isWarnEnabled() {
		return log.isWarnEnabled();
	}

	@Override
	public boolean isErrorEnabled() {
		return isErrorEnabled();
	}

	@Override
	public void trace(String message) {
		log.trace(message);
	}

	@Override
	public void debug(String message) {
		log.debug(message);
	}

	@Override
	public void info(String message) {
		log.info(message);
	}

	@Override
	public void warn(String message) {
		log.warn(message);
	}

	@Override
	public void error(String message) {
		log.error(message);
	}

	@Override
	public void error(String message, Throwable ex) {
		log.error(message, ex);
	}

}
