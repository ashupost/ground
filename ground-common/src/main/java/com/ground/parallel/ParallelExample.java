package com.ground.parallel;

import java.util.Arrays;
import java.util.List;

public class ParallelExample {

	public static int doubleInt(int x) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("x=" + x);
		return x * 2;

	}

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 5, 4, 3, 6, 7, 8, 9, 10);
		System.out.println(values.parallelStream().mapToInt(ParallelExample::doubleInt).sum());

	}
}
