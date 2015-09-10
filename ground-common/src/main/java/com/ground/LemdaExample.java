package com.ground;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LemdaExample {

	public static boolean isGreater3(int number) {

		System.out.println(" isGreater3 = " + number);
		return number > 3;
	}

	public static boolean isEven(int number) {
		System.out.println(" isEven = " + number);
		return number % 2 == 0;
	}

	public static int doubleIt(int number) {
		System.out.println(" doubleIt = " + number);
		return number * 2;
	}

	public static void main(String[] arg) {
		List<Integer> values = Arrays.asList(3, 2, 5, 7, 1, 8, 6, 4, 9, 10);

		Objects.requireNonNull(values);
		// Predicate<Integer> isGreater3 = number -> number > 3;
		Function<Integer, Predicate<Integer>> isGreater = pivot -> number -> number > 3;
		final Stream<Integer> temp = values.stream().filter(isGreater.apply(3)).filter(LemdaExample::isEven).map(LemdaExample::doubleIt);
		System.out.println(temp.findFirst().get());
		System.out.println("over");
	}

}
