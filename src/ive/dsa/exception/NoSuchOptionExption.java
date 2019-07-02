package ive.dsa.exception;

/**
 * When there is no such opetion, it occurs.
 * 
 * @author POON Ngai Kuen(180091780)
 * @version 1.0
 */

public class NoSuchOptionExption extends RuntimeException {
	// Constructor
	public NoSuchOptionExption() {
		super("Usage: <keygen | en | de> <deck_file> <message_string>");
		// TODO Auto-generated constructor stub
	}

}
