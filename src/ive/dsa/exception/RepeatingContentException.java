package ive.dsa.exception;

/**
 * When the number of text file is repeating, it occurs
 * 
 * @author POON Ngai Kuen(180091780)
 * @version 1.0
 *
 */
public class RepeatingContentException extends RuntimeException {
	// Constructor
	public RepeatingContentException(int repeatNum) {
		super("Each digit cannot repeat! (Repeating: " + repeatNum + ")");
		// TODO Auto-generated constructor stub
	}

	// Constructor
	public RepeatingContentException(String repeatNum) {
		super("Each digit cannot repeat! (Repeating: " + repeatNum + ")");
		// TODO Auto-generated constructor stub
	}

}
