package com.mlogger.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLoggerSupport implements com.mlogger.Logger {

	private Logger _log;

	public Slf4jLoggerSupport(Class<?> clazz) {
		_log = LoggerFactory.getLogger(clazz);
	}
	
	@Override
	public boolean isTraceEnabled() {
		return _log.isTraceEnabled();
	}
	
	@Override
	public boolean isDebugEnabled() {
		return _log.isDebugEnabled();
	}
	
	@Override
	public boolean isInfoEnabled() {
		return _log.isInfoEnabled();
	}
	
	@Override
	public boolean isWarnEnabled() {
		return _log.isWarnEnabled();
	}
	
	@Override
	public boolean isErrorEnabled() {
		return _log.isErrorEnabled();
	}
	
	@Override
	public void trace(String message) {
		_log.trace(message);
	}
	
	@Override
	public void debug(String message) {
		_log.debug(message);
	}
	
	@Override
	public void info(String message) {
		_log.info(message);
	}
	
	@Override
	public void warn(String message) {
		_log.warn(message);
	}
	
	@Override
	public void error(String message) {
		_log.error(message);
	}

	@Override
	public void error(String message, Throwable ex) {
		_log.error(message, ex);
	}

}
