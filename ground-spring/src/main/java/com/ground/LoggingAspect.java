package com.ground;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.util.StopWatch;


/**
 * Aspect's central LoggingAspect manager SPI.
 * Allows for retrieving named {@link HelloWorldService} regions.
 * <p>Defined in @Bean Application Configuration file {@link ApplicationConfiguration#loggingAspect} for to make spring enable.</p>
 *
 * @author kumar
 */
@Aspect
public class LoggingAspect {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	@Around("execution(* com.ground.common.constants.HelloService.getName(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object returnValue = null;
		System.out.println("logAround() is running!");
		System.out.println("hijacked method : "
				+ joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : "
				+ Arrays.toString(joinPoint.getArgs()));

		System.out.println("Around before is running!");
		returnValue = joinPoint.proceed(); // continue on the intercepted method
		System.out.println("Around after is running!");

		System.out.println("******");
		return returnValue;
	}

	@Around("@annotation(com.ground.Loggable)")
	public Object myAroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw = new StopWatch(getClass().getSimpleName());
		Object returnValue = null;
		try {
			Marker notifyAdmin = MarkerFactory.getMarker("NOTIFY_ADMIN");

			LOGGER.info(notifyAdmin, "{} with agrument {}:", pjp, Arrays.toString(pjp.getArgs()));
			LOGGER.info("{}, {},  {},  {},  agrument:", pjp.getKind(),	pjp.toLongString(), pjp.toString(), pjp.getStaticPart());

			sw.start(pjp.getSignature().getName());
			returnValue = pjp.proceed();
		} catch (Throwable throwable) {
			LOGGER.error("error in LoggingAspect", throwable);

		} // this is place where actual method execution happens
		finally {
			sw.stop();
			LOGGER.info("{}", sw.prettyPrint());
		}
		return returnValue;
	}

}