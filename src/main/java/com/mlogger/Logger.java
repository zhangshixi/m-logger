package com.mlogger;

public interface Logger {

	public boolean isTraceEnabled();
	
	public boolean isDebugEnabled();
	
	public boolean isInfoEnabled();
	
	public boolean isWarnEnabled();
	
	public boolean isErrorEnabled();
	
	public void trace(String message);
	
	public void debug(String message);
	
	public void info(String message);
	
	public void warn(String message);

	public void error(String message);

	public void error(String message, Throwable ex);

}
