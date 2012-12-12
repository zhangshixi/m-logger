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
        if (message != null && _logger.isTraceEnabled()) {
            _logger.trace(ReplaceHolder.replaceArgs(message, params));
        }
    }

    public void debug(String message, Object... params) {
        if (message != null && _logger.isDebugEnabled()) {
            _logger.debug(ReplaceHolder.replaceArgs(message, params));
        }
    }

    public void info(String message, Object... params) {
        if (message != null && _logger.isInfoEnabled()) {
            _logger.info(ReplaceHolder.replaceArgs(message, params));
        }
    }

    public void warn(String message, Object... params) {
        if (message != null && _logger.isWarnEnabled()) {
            _logger.warn(ReplaceHolder.replaceArgs(message, params));
        }
    }

    public void error(String message, Object... params) {
        if (message != null && _logger.isErrorEnabled()) {
            _logger.error(ReplaceHolder.replaceArgs(message, params));
        }
    }

}
