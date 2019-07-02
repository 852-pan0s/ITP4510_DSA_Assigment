package ive.dsa.exception;

/**
 * When the input is invalid, it occurs.
 * 
 * @author POON Ngai Kuen(180091780)
 * @version 1.0
 *
 */
public class InvalidInputException extends RuntimeException {
	// Constructor
	public InvalidInputException(String s) {
		super("Inalid string: "+s);
		// TODO Auto-generated constructor stub
	}

}
