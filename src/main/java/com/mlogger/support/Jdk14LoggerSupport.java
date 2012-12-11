package com.mlogger.support;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Jdk14LoggerSupport implements com.mlogger.Logger {

	private Logger log;

	public Jdk14LoggerSupport(Class<?> clazz) {
		log = Logger.getLogger(clazz.getName());
	}
	
	@Override
	public boolean isTraceEnabled() {
		return log.isLoggable(Level.FINEST);
	}
	
	@Override
	public boolean isDebugEnabled() {
		return log.isLoggable(Level.FINER);
	}
	
	@Override
	public boolean isInfoEnabled() {
		return log.isLoggable(Level.FINE);
	}
	
	@Override
	public boolean isWarnEnabled() {
		return log.isLoggable(Level.WARNING);
	}
	
	@Override
	public boolean isErrorEnabled() {
		return log.isLoggable(Level.SEVERE);
	}
	
	@Override
	public void trace(String message) {
		log.log(Level.FINEST, message);
	}
	
	@Override
	public void debug(String message) {
		log.log(Level.FINER, message);
	}
	
	@Override
	public void info(String message) {
		log.log(Level.FINE, message);
	}
	
	@Override
	public void warn(String message) {
		log.log(Level.WARNING, message);
	}
	
	@Override
	public void error(String message) {
		log.log(Level.SEVERE, message);
	}

	@Override
	public void error(String message, Throwable ex) {
		log.log(Level.SEVERE, message, ex);
	}
	
}
