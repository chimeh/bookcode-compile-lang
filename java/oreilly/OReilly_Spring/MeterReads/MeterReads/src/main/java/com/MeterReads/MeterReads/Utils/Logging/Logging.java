package com.MeterReads.MeterReads.Utils.Logging;

import com.MeterReads.MeterReads.DataObjects.FunctionalInterfaces.ThrowableFunction;
import com.MeterReads.MeterReads.Utils.Timing.MillisTimer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * This is an aspect to do all of the logging for the program. It
 * uses different logging depending on what we are executing. Some
 * just map parameters, others time processes etc.
 */
@Aspect
@Component
public class Logging {

    private Logger logger = Logger.getLogger(getClass().getName());

    /**
     * This provides the logging for any method in the program.
     *
     * @param joinPoint The join point for the method we are intercepting
     *
     * @return The return value for whatever method we are intercepting
     *
     * @throws Throwable Generic throwable from an AOP function
     */
    @Around("execution(* com.MeterReads.MeterReads..*.*(..))")
    public Object allMethodLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        return loggingExecutor("Generic Method", this::genericMethodLogging, joinPoint);
    }

    /**
     * This provides the logging for all of the controllers so we can monitor when
     * calls are made to the API.
     *
     * @param joinPoint The join point for the method we are intercepting
     *
     * @return The return value for whatever method we are intercepting
     *
     * @throws Throwable Generic throwable from an AOP function
     */
    @Around("execution(* com.MeterReads.MeterReads.Controllers..*.*(..))")
    public Object controllerLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        return loggingExecutor("Controller", this::performanceMonitoringLogging, joinPoint);
    }

    /*
    Utilities
     */

    /**
     * This is a logging executor which acts as a wrapper for executing the various loggers
     * defined for different join points.
     *
     * @param loggingName The name we want displayed next to whichever logger we are executing
     * @param loggerFunction The logging function we want to execute
     * @param joinPoint The join point for the method we are intercepting
     *
     * @return The return value for whatever method we are intercepting
     *
     * @throws Throwable Generic throwable from an AOP function
     */
    private Object loggingExecutor(String loggingName, ThrowableFunction<ProceedingJoinPoint, Object> loggerFunction, ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Entering in " + loggingName + " Logging");
        Object returnValue = loggerFunction.apply(joinPoint);
        logger.info("Exiting " + loggingName + " Logging");
        return returnValue;
    }

    /**
     * This is used to log all calls to any methods. It will log the method name, arguments
     * and tell you when you have entered and exited the method, as well as what was returned.
     *
     * @param joinPoint The join point for the method we are intercepting
     *
     * @return The return value for whatever method we are intercepting
     *
     * @throws Throwable Generic throwable from an AOP function
     */
    private Object genericMethodLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArguments = joinPoint.getArgs();

        logger.info("Entering in Method: " + methodName);
        logger.info("Method Arguments: " + Arrays.stream(methodArguments).map(Object::toString).collect(Collectors.joining(", ")));

        Object returnValue = joinPoint.proceed(methodArguments);

        logger.info("Exiting Method: " + methodName);
        logger.info("Method Return Value: " + returnValue.toString());

        return returnValue;
    }

    /**
     * This logger can be called whenever we want to monitor the performance of a process.
     * Perhaps we want to see how long it is taking to make API calls or write to the database.
     * This will then log information around that.
     *
     * @param joinPoint The join point for the method we are intercepting
     *
     * @return The return value for whatever method we are intercepting
     *
     * @throws Throwable Generic throwable from an AOP function
     */
    private Object performanceMonitoringLogging(ProceedingJoinPoint joinPoint) throws Throwable {

        MillisTimer millisTimer = new MillisTimer();
        millisTimer.start();

        Object returnValue = joinPoint.proceed(joinPoint.getArgs());

        millisTimer.finish();

        logger.info("Elapsed Time (ms): " + millisTimer.getTime());

        return returnValue;
    }

}
