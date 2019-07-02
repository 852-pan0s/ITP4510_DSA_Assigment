import ive.dsa.assignment.Assignment;
import ive.dsa.solitaire.SolitaireTool;

/**
 * This is the main program of assignment.
 * 
 * @author POON Ngai Kuen (180091780)
 * @version 1.0
 */

public class SolitaireEncryption {

	public static void main(String[] args) {
		// set max value of loading content of the text file.
		SolitaireTool.setCardSize(28);
		
		// Set joker for triple cut, first argument = jokerA, second = jokerB
		SolitaireTool.setJoker(27, 28);

		// Lone one line in the text file only?
		SolitaireTool.loadOneLineOnly = true;

		// Allow repeating digits.
		SolitaireTool.allowRepeatingDigits = false;

		// Create Object Assignment
		Assignment a = new Assignment(args);
		a.assigementStart();
	}

}
