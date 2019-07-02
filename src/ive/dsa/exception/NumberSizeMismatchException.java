package ive.dsa.exception;

/**
 * When the number of of digits in text file is not enough, it occurs
 * 
 * @author POON Ngai Kuen(180091780)
 * @version 1.0
 *
 */
public class NumberSizeMismatchException extends RuntimeException {
	// Constructor
	public NumberSizeMismatchException(int cuurentSize, int cardSize) {
		super("Out of size range: " + (cuurentSize) + ". (Must be: " + cardSize + " numbers.)");
		// TODO Auto-generated constructor stub
	}
}
