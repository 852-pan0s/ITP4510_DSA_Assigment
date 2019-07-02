package ive.dsa.exception;

/**
 * When the card set do not include two jokers, it occurs..
 * 
 * @author POON Ngai Kuen(180091780)
 * @version 1.0
 */

public class JokerMissingException extends RuntimeException {
	public JokerMissingException() {
		super("The card set is missing two jokers!");
		// TODO Auto-generated constructor stub
	}

	public JokerMissingException(String missJocker) {
		super("The card set is missing " + missJocker + "!");
		// TODO Auto-generated constructor stub
	}

}
