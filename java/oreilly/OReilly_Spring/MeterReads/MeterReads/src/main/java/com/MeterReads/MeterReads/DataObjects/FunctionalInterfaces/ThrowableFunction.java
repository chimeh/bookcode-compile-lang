package com.MeterReads.MeterReads.DataObjects.FunctionalInterfaces;

/**
 * This is a functional interface so we can execute lambda functions
 * that throw exceptions
 *
 * @param <T> Argument type
 * @param <R> Return type
 */
@FunctionalInterface
public interface ThrowableFunction<T, R> {
    public R apply(T arg) throws Throwable;
}
