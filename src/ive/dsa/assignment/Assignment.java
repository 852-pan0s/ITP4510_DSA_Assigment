package ive.dsa.assignment;

import ive.dsa.exception.EmptyMessageException;
import ive.dsa.exception.NoSuchOptionExption;
import ive.dsa.solitaire.Keystream;
import ive.dsa.solitaire.SolitaireTool;

/**
 * It is a class for the assignment. inputArgs[0]: option inputArgs[1]: file
 * name inputArgs[2]: input message
 * 
 * @author POON Ngai Kuen (180091780)
 * @version 1.0
 */
public class Assignment {

	private String[] inputArgs;
	public char[] charMsg;

	// Constructor
	public Assignment(String[] inputArgs) {
		this.inputArgs = inputArgs;
		try {
			String msg = SolitaireTool.deleteSpace(inputArgs[2].toUpperCase());
			SolitaireTool.characterChecker(msg, "alphabet");
			charMsg = SolitaireTool.stringToChar(msg);
		} catch (ArrayIndexOutOfBoundsException e) {
			SolitaireTool.helpMsg();
			throw new EmptyMessageException();
		}
	}

	/**
	 * Intefer for inner class
	 * 
	 * @author POON Ngai Kuen (180091780)
	 *
	 */
	private interface DSA_Assigment {
		void assigmentWork() throws NoSuchOptionExption;
	}

	public void assigementStart() {
		new InterAssignment() {
			@Override
			public void work() {
				new DSA_Assigment() {
					@Override
					public void assigmentWork() throws NoSuchOptionExption {
						String loadedText = SolitaireTool.loadFile(inputArgs[1]); // Load text file
						SolitaireTool.characterChecker(loadedText, "int"); // Check content of the file.
						int[] cardSet = SolitaireTool.stringToInt(loadedText); // Convert to int[]
						// check the card set.
						SolitaireTool.checkCardSet(cardSet,inputArgs[0],charMsg);

						switch (inputArgs[0]) { // check the option of input
						case "keygen":
							Keystream.generateKeystream(cardSet, charMsg, true); // Generate key stream
							//							String s = " [";
//							for(int k : Keystream.keyCode)
//								System.out.print(k+ " ");
//							System.out.println(s+" ]");
//							System.out.println(Keystream.keyCode[1]);
							break;
						case "en":
							SolitaireTool.encryptMsg(cardSet, charMsg); // Use key stream to encrypt
							break;
						case "de":
							SolitaireTool.cardSize = cardSet.length;
							SolitaireTool.decryptMsg(cardSet, charMsg); // Use key stream to decrypt
							break;
						default:
							throw new NoSuchOptionExption();
						}
					}

				}.assigmentWork();
			};
		}.work();

	}

}
