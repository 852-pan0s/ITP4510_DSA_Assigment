package ive.dsa.exception;

/**
 * When the the content of text is not all numbers, it occurs.
 * 
 * @author POON Ngai Kuen(180091780)
 * @version 1.0
 *
 */

public class NumberOverFlowException extends RuntimeException {
	// Constructor
	public NumberOverFlowException(String overflowNum, int max) {
		super("Overflow: " + overflowNum + "(Max: " + max + ")");
		// TODO Auto-generated constructor stub
	}

}
