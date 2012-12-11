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
		tryImplementation(new Runnable() {
			public void run() {
				useSlf4jLogger();
			}
		});
		tryImplementation(new Runnable() {
			public void run() {
				useCommonsLogger();
			}
		});
		tryImplementation(new Runnable() {
			public void run() {
				useLog4jLogger();
			}
		});
		tryImplementation(new Runnable() {
			public void run() {
				useJdk14Logger();
			}
		});
		tryImplementation(new Runnable() {
			public void run() {
				useVirtualLogger();
			}
		});
	}

	public static Logger getLog(Class<?> clazz) {
		try {
			return logConstructor.newInstance(new Object[]{clazz});
		} catch (Throwable t) {
			throw new LoggerException("Error creating logger for class " + clazz + ". Cause: " + t, t);
		}
	}

	public static synchronized void useSlf4jLogger() {
		setImplementation(Slf4jLoggerSupport.class.getName());
	}

	public static synchronized void useCommonsLogger() {
		setImplementation(CommonsLoggerSupport.class.getName());
	}

	public static synchronized void useLog4jLogger() {
		setImplementation(Log4jLoggerSupport.class.getName());
	}

	public static synchronized void useJdk14Logger() {
		setImplementation(Jdk14LoggerSupport.class.getName());
	}

	public static synchronized void useConsoleLogger() {
		setImplementation(ConsoleLoggerSupport.class.getName());
	}

	public static synchronized void useVirtualLogger() {
		setImplementation(VirtualLoggerSupport.class.getName());
	}

	private static void tryImplementation(Runnable runnable) {
		if (logConstructor == null) {
			try {
				runnable.run();
			} catch (Throwable t) {
				// ignore
			}
		}
	}

	private static void setImplementation(String className) {
		try {
			@SuppressWarnings("unchecked")
			Class<? extends Logger> implClass = (Class<? extends Logger>) Class.forName(className);
			Constructor<? extends Logger> candidate = implClass.getConstructor(new Class[]{Class.class});
			Logger logger = candidate.newInstance(new Object[]{LoggerFactory.class});
			logger.debug("Logging initialized using '" + className + "' adapter.");
			logConstructor = candidate;
		} catch (Throwable t) {
			throw new LoggerException("Error setting Logger implementation. Cause: " + t, t);
		}
	}

}
