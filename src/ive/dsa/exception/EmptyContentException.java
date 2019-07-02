package ive.dsa.exception;

/**
 * When the the content of text file is empty, it occurs.
 * 
 * @author POON Ngai Kuen(180091780)
 * @version 1.0
 *
 */
public class EmptyContentException extends RuntimeException {
	// Constructor
	public EmptyContentException() {
		super("<deck_file> is empty!");
		// TODO Auto-generated constructor stub
	}

}
