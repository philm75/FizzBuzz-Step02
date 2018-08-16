package com.equalexperts.fb;

import java.util.stream.IntStream;

/**
 * Description - "FizzBuzz" program - Step 2.
 */
public class FizzBuzz {

	/**
	 * Minimum range value.
	 */
	private final int minRange;
	
	/**
	 * Maximum range value.
	 */
	private final int maxRange;
	
	/**
	 * Exception messages.
	 */
	private static final String MIN_RANGE_ERROR = "Minimum Range must be 0 or greater - %s";
	private static final String MAX_RANGE_ERROR = "Maximum Range must be greater than the Minimum Range - %s";
	
	/**
	 * Output messages.
	 */
	private static final String FIZZ = "fizz";
	private static final String BUZZ = "buzz";
	private static final String LUCKY = "lucky";
	
	/**
	 * @param minRange
	 * @param maxRange
	 */
	public FizzBuzz(int minRange, int maxRange) {
        if (minRange < 0) {
            throw new IllegalArgumentException(String.format(MIN_RANGE_ERROR, String.valueOf(minRange)));
        }
        if (minRange > maxRange) {
            throw new IllegalArgumentException(String.format(MAX_RANGE_ERROR, String.valueOf(maxRange)));
        }
		this.minRange = minRange;
		this.maxRange = maxRange;
	}
	
	public void run() {
		IntStream.rangeClosed(minRange, maxRange).forEach(number -> {
			print(number);
		});
	}
	
	private void print(Integer value) {		
		boolean isDivisableByThree = (value % 3 == 0);
		boolean isDivisableByFive = (value % 5 == 0);
		boolean isDivisableByFifteen = (value % 15 == 0);
		boolean containsAThree = String.valueOf(value).contains("3");

		if (containsAThree) {
			System.out.print(LUCKY);
		} else if (isDivisableByFifteen) {
			System.out.print(FIZZ);
			System.out.print(BUZZ);
		} else if (isDivisableByFive) {
			System.out.print(BUZZ);			
		} else if (isDivisableByThree) {
			System.out.print(FIZZ);			
		} else {
			System.out.print(value);			
		}
		
		if (value.intValue() < maxRange) {
			System.out.print(" ");			
		}		
	}
	
	/**
	 * Program entry point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FizzBuzz fizzBuzz = new FizzBuzz(1, 20);
		fizzBuzz.run();
		System.out.println("");
		fizzBuzz.run();
	}
}