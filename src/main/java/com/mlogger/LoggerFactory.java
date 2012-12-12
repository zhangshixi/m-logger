package com.mlogger;

import java.lang.reflect.Constructor;

import com.mlogger.support.CommonsLoggerSupport;
import com.mlogger.support.ConsoleLoggerSupport;
import com.mlogger.support.Jdk14LoggerSupport;
import com.mlogger.support.Log4jLoggerSupport;
import com.mlogger.support.Slf4jLoggerSupport;
import com.mlogger.support.VirtualLoggerSupport;

public class LoggerFactory {

    private static Constructor<? extends Logger> logConstructor;

    static {
        tryImplementation(Slf4jLoggerSupport.class);
        tryImplementation(CommonsLoggerSupport.class);
        tryImplementation(Log4jLoggerSupport.class);
        tryImplementation(Jdk14LoggerSupport.class);
        tryImplementation(ConsoleLoggerSupport.class);
        tryImplementation(VirtualLoggerSupport.class);
    }

    public static Logger getLog(Class<?> clazz) {
        try {
            return logConstructor.newInstance(new Object[] { clazz });
        } catch (Throwable t) {
            throw new LoggerException("Error creating logger for class " + clazz + ". Cause: " + t,
                t);
        }
    }

    private synchronized static void tryImplementation(final Class<? extends Logger> loggerClazz) {
        if (logConstructor == null) {
            try {
                logConstructor = getImplementation(loggerClazz);
            } catch (Throwable t) {
                // ignore
            }
        }
    }

    private static Constructor<? extends Logger> getImplementation(Class<? extends Logger> loggerClazz) {
        Constructor<? extends Logger> candidate = null;
        try {
            candidate = loggerClazz.getConstructor(new Class[] { Class.class });
            Logger logger = candidate.newInstance(new Object[] { LoggerFactory.class });
            logger.info("Logging initialized using '" + loggerClazz.getName() + "' adapter.");
        } catch (Throwable t) {
            throw new LoggerException("Error setting Logger implementation. Cause: " + t, t);
        }
        return candidate;
    }

}
