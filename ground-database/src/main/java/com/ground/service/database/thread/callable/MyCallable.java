package com.ground.service.database.thread.callable;

import java.util.concurrent.Callable;

/**
 * The executor framework presented in the last chapter works with Runnables.
 * Runnable do not return result.
 * <p>
 * In case you expect your threads to return a computed result you can use
 * java.util.concurrent.Callable. The Callable object allows to return values
 * after completion.
 * </p>
 * <p>
 * The Callable object uses generics to define the type of object which is
 * returned.
 * </p>
 * <p>
 * If you submit a Callable object to an Executor the framework returns an
 * object of type java.util.concurrent.Future.
 * </p>
 * <p>
 * This Future object can be used to check the status of a Callable and to
 * retrieve the result from the Callable.
 * </p>
 * <p>
 * On the Executor you can use the method submit to submit a Callable and to get
 * a future. To retrieve the result of the future use the get() method.
 * </p>
 * 
 * @author kumar
 */
public class MyCallable implements Callable<Long> {
	@Override
	public Long call() throws Exception {
		long sum = 0;
		for (long i = 0; i <= 10; i++) {
			sum += i;
		}
		return sum;
	}

}