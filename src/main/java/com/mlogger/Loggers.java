package com.mlogger;

import com.mlogger.util.ReplaceHolder;

public class Loggers {

    private Logger _logger;

    public Loggers(Logger logger) {
        if (logger == null) {
            throw new NullPointerException("logger");
        }
        this._logger = logger;
    }

    public static Loggers getLoggers(Class<?> clazz) {
        return new Loggers(LoggerFactory.getLog(clazz));
    }

    public void trace(String message, Object... params) {
        if (_logger.isTraceEnabled()) {
            _logger.trace(doBuildHolderArgsMsg(message, params));
        }
    }

    public void debug(String message, Object... params) {
        if (_logger.isDebugEnabled()) {
            _logger.debug(doBuildHolderArgsMsg(message, params));
        }
    }

    public void info(String message, Object... params) {
        if (_logger.isInfoEnabled()) {
            _logger.info(doBuildHolderArgsMsg(message, params));
        }
    }

    public void warn(String message, Object... params) {
        if (_logger.isWarnEnabled()) {
            _logger.warn(doBuildHolderArgsMsg(message, params));
        }
    }

    public void error(String message, Object... params) {
        if (_logger.isErrorEnabled()) {
            _logger.error(doBuildHolderArgsMsg(message, params));
        }
    }
    
    public void error(String message, Throwable cause, Object... params) {
    	if (_logger.isErrorEnabled()) {
    		_logger.error(doBuildHolderArgsMsg(message, params), cause);
    	}
    }

    /* ---- private methods ---- */
    private String doBuildHolderArgsMsg(String message, Object... params) {
    	return message == null ? null : ReplaceHolder.replaceArgs(message, params);
    }

}
