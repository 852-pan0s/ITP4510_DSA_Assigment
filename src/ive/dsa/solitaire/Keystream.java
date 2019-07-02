package ive.dsa.solitaire;

/**
 * Generate key stream.
 * 
 * @author POON Ngai Kuen (180091780)
 * @version 1.0
 */
public class Keystream extends Key {
	public static int[] keyCode;

	public Keystream(int[] cardSet) {
		super(cardSet);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Generate a key stream
	 * 
	 * @param cardSet
	 * @param charMsg
	 * @param showMsg SolitaireTool.keygen();
	 */
	public static void generateKeystream(int[] cardSet, char[] charMsg, boolean showMsg) {
		GenerateKey gk = new Keystream(cardSet);
		keyCode = new int[charMsg.length];
		int keyNo = 0;
		int keyLength = charMsg.length;
		// each character will generate a key.
		while (keyLength > 0) {
			// Downcasting
			Keystream k = (Keystream) gk;
			int step = 1;
			k.swapJokerA();
			// Display step for generating the key stream?
			if (showMsg) {
				System.out.printf("S%d: ", step++);
				k.printCardSet();
			}

			k.jokerB_MoveBackTwo();
			// Display step for generating the key stream?
			if (showMsg) {
				System.out.printf("S%d: ", step++);
				k.printCardSet();
			}

			k.tripleCut();
			// Display step for generating the key stream?
			if (showMsg) {
				System.out.printf("S%d: ", step++);
				k.printCardSet();
			}

			k.moveCardSetToLastCardBefore();
			// Display step for generating the key stream?
			if (showMsg) {
				System.out.printf("S%d: ", step++);
				k.printCardSet();
			}

			if (k.generateKeystreamValue() == null) {
				if (showMsg)
					System.out.println("Joker: Key skipped");
				continue;
			} else {
				int key = (int) k.generateKeystreamValue();
				if (SolitaireTool.isValidKeyValue(key)) {
					if (showMsg) {
						System.out.printf("Key %d: " + key + "\n", ++keyNo);
						keyCode[keyNo - 1] = key;
					} else
						keyCode[keyNo++] = key;
					keyLength--;
				} else if (showMsg)
					System.out.println("Joker: Key skipped");
			}
		}
		if (showMsg)
			printKey();
	}

	public static void printKey() {
		String s = "[ ";
		for (int i : Keystream.keyCode)
			s += i + " ";
		System.out.println("Keystream values: " + s + "]");
	}

}
