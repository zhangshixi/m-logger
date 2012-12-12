package com.mlogger.support;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Jdk14LoggerSupport implements com.mlogger.Logger {

	private Logger _log;

	public Jdk14LoggerSupport(Class<?> clazz) {
		_log = Logger.getLogger(clazz.getName());
	}
	
	@Override
	public boolean isTraceEnabled() {
		return _log.isLoggable(Level.FINEST);
	}
	
	@Override
	public boolean isDebugEnabled() {
		return _log.isLoggable(Level.FINER);
	}
	
	@Override
	public boolean isInfoEnabled() {
		return _log.isLoggable(Level.FINE);
	}
	
	@Override
	public boolean isWarnEnabled() {
		return _log.isLoggable(Level.WARNING);
	}
	
	@Override
	public boolean isErrorEnabled() {
		return _log.isLoggable(Level.SEVERE);
	}
	
	@Override
	public void trace(String message) {
		_log.log(Level.FINEST, message);
	}
	
	@Override
	public void debug(String message) {
		_log.log(Level.FINER, message);
	}
	
	@Override
	public void info(String message) {
		_log.log(Level.FINE, message);
	}
	
	@Override
	public void warn(String message) {
		_log.log(Level.WARNING, message);
	}
	
	@Override
	public void error(String message) {
		_log.log(Level.SEVERE, message);
	}

	@Override
	public void error(String message, Throwable ex) {
		_log.log(Level.SEVERE, message, ex);
	}
	
}
