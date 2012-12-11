package com.mlogger.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mlogger.Logger;

public class CommonsLoggerSupport implements Logger {

	private Log log;

	public CommonsLoggerSupport(Class<?> clazz) {
		log = LogFactory.getLog(clazz);
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
		return log.isErrorEnabled();
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
		log.debug(message);
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
