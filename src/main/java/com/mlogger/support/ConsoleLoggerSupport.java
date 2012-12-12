package com.mlogger.support;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.mlogger.Level;
import com.mlogger.Logger;

public class ConsoleLoggerSupport implements Logger {

    private String _className;
    
	public ConsoleLoggerSupport(Class<?> clazz) {
	    if (clazz != null) {
	        _className = clazz.getName();
	    }
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
		System.out.println(buildMessage(message, Level.TRACE));
	}
	
	@Override
	public void debug(String message) {
		System.out.println(buildMessage(message, Level.DEBUG));
	}
	
	@Override
	public void info(String message) {
		System.out.println(buildMessage(message, Level.INFO));
	}
	
	@Override
	public void warn(String message) {
		System.out.println(buildMessage(message, Level.WARN));
	}
	
	@Override
	public void error(String message) {
		System.err.println(buildMessage(message, Level.ERROR));
	}

	@Override
	public void error(String message, Throwable ex) {
		System.err.println(buildMessage(message, Level.ERROR));
		if (ex != null) {
			ex.printStackTrace(System.err);
		}
	}
	
	// ---- private methods ---------------------------------------------
	private static final DateFormat DATE_FORMAT = 
	        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	private String buildMessage(String message, Level level) {
	    StringBuilder buff = new StringBuilder();
	    buff.append(DATE_FORMAT.format(Calendar.getInstance().getTime()));
	    buff.append(" [");
	    buff.append(Thread.currentThread().getName());
	    buff.append("] ");
	    buff.append(level.name());
	    buff.append(" ");
	    buff.append(_className);
	    buff.append(" - ");
	    buff.append(message);
	    return buff.toString();
	}
	
}
