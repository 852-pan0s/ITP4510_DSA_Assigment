package ive.dsa.solitaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import ive.dsa.exception.EmptyContentException;
import ive.dsa.exception.EmptyMessageException;
import ive.dsa.exception.InvalidInputException;
import ive.dsa.exception.JokerMissingException;
import ive.dsa.exception.NumberOverFlowException;
import ive.dsa.exception.NumberSizeMismatchException;
import ive.dsa.exception.RepeatingContentException;

/**
 * Tool for Solitaire, Almost all static method so that it can be accessed more
 * conveniently
 * 
 * @author POON Ngai Kuen (180091780)
 * @version 1.0
 */

public class SolitaireTool {
	// The size of loading card, it requires the size of it must equals to.
	public static int cardSize = 28;
	// Set the jokerA value.
	public static Object jokerA = 27;
	// Set the jokerB value.
	public static Object jokerB = 28;
	public static boolean loadOneLineOnly = true;
	public static boolean allowRepeatingDigits;

	public static void setJoker(int jokerA, int jokerB) {
		SolitaireTool.jokerA = (Object) jokerA;
		SolitaireTool.jokerB = (Object) jokerB;
	}

	public static void setJokerA(int jokerA) {
		SolitaireTool.jokerA = (Object) jokerA;
	}

	public static void setJokerB(int jokerB) {
		SolitaireTool.jokerB = (Object) jokerB;
	}

	public static void setCardSize(int cardSize) {
		SolitaireTool.cardSize = cardSize;
	}

	/**
	 * Check the array of integer. Return false when checking is fail.
	 * 
	 * @param cardSet
	 * @throws RepeatingContentException
	 * @throws NumberSizeMismatchException
	 * @throws NumberOverFlowException
	 */
	public static void checkCardSet(int[] cardSet, String option, char[] charMsg) throws RepeatingContentException, NumberSizeMismatchException,
			NumberOverFlowException, JokerMissingException {
		if(option.equals("de")) {
			if (cardSet.length < charMsg.length) {
				throw new NumberSizeMismatchException(cardSet.length, charMsg.length);
			}
			return;
		}
		if (cardSet.length != cardSize) {
			throw new NumberSizeMismatchException(cardSet.length, cardSize);
		}
		String invalid = "";
		int[] sortCardSet = new int[cardSize];

		// check each digit that must less than cardSize, if it is more than
		// cardSize, the invalid will store it.
		// It will also check whether two jokers in the card set.
		String[] jokerCheck = { "Joker A", "Joker B" };
		for (int i = 0; i < sortCardSet.length; i++) {
			if (cardSet[i] > cardSize) {
				invalid += "\"" + cardSet[i] + "\", ";
			}
			if (cardSet[i] == (int) jokerA) {
				jokerCheck[0] = "";
			}

			if (cardSet[i] == (int) jokerB) {
				jokerCheck[1] = "";
			}
			sortCardSet[i] = cardSet[i];
		}
		int joA = jokerCheck[0].length();
		int joB = jokerCheck[1].length();
		if (joA + joB > 10)
			throw new JokerMissingException();
		else if (joA == 0 && joB != 0)
			throw new JokerMissingException(jokerCheck[1]);
		else if (joB == 0 && joA != 0)
			throw new JokerMissingException(jokerCheck[0]);
		if (invalid.length() > 0) {
			throw new NumberOverFlowException(invalid.substring(0, invalid.length() - 2), cardSize);
		}

		invalid = "";
		Arrays.sort(sortCardSet);
		for (int i = 0; i < sortCardSet.length - 1; i++) {
			if (sortCardSet[i] == sortCardSet[i + 1]) {
				invalid += "\"" + sortCardSet[i] + "\", ";
			}
		}
		if (invalid.length() > 0 && !allowRepeatingDigits) {
			throw new RepeatingContentException(invalid.substring(0, invalid.length() - 2));
		}
		sortCardSet = null;
	}

	/**
	 * Check each character of string, if there is an invalid character, it occur
	 * exception.
	 * 
	 * @param string
	 * @param type
	 * @throws InvalidInputException
	 */
	public static void characterChecker(String string, String type) throws InvalidInputException {
		String invalid = "";
		for (int j = 0; j < string.length(); j++)
			// check space
			if (string.charAt(j) != 32)
				// check invalid characters
				if (!isInteger(string.charAt(j)) && type.equals("int")
						|| (!isAlphabet(string.charAt(j)) && type.equals("alphabet")))
					invalid += "\"" + string.charAt(j) + "\", ";

		if (invalid.length() > 0) {
			if (invalid.length() > 0) {
				System.out.println("Usage: <keyegn|en|dn> <deck_file(digits only)> <message_string(alphabets only)>");
				throw new InvalidInputException(invalid.substring(0, invalid.length() - 2));
			}
		}
	}

	/**
	 * Change string to char[]
	 * 
	 * @param msg
	 * @return
	 * @throws EmptyMessageException
	 */
	public static char[] stringToChar(String msg) throws EmptyMessageException {
		try {
			char[] alphabet = new char[msg.length()];
			for (int i = 0; i < alphabet.length; i++) {
//				System.out.printf((temp.charAt(i) + 0) + " Add:" + " (\"%c\")\n", temp.charAt(i));
				alphabet[i] = msg.charAt(i);
			}
			if (alphabet.length - 1 > 0) // check the length of alphabet.
				return alphabet;
			else
				throw new EmptyMessageException();
		} catch (ArrayIndexOutOfBoundsException e) {
			helpMsg();
			throw new EmptyMessageException();
		}
	}

	/**
	 * Remove all space in the string.
	 * 
	 * @param msg
	 * @return
	 */
	public static String deleteSpace(String msg) {
		String temp = "";
		for (int i = 0; i < msg.length(); i++) {
			// check space
			if (msg.charAt(i) != 32) {
				temp += msg.charAt(i);
			}
		}
		return temp;
	}

	/**
	 * check the alphabet, that must be 'A' to 'Z' & 'a' to 'z'
	 * 
	 * @param alphabet
	 * @return
	 */
	public static boolean isAlphabet(char character) {
		return (character >= 65 && character <= 90) || (character >= 97 && character <= 122);
	}

	/**
	 * check the digits, that must be '0' to '9'
	 * 
	 * @param character
	 * @return
	 */
	public static boolean isInteger(char character) {
		return (character >= 48 && character <= 57);
	}

	/**
	 * Compare the key value and joker.
	 * 
	 * @param key
	 * @return
	 */
	public static boolean isValidKeyValue(int key) {
		if (key >= (int) jokerA)
			return false;
		return true;
	}

	/**
	 * the string convert to int[] by using ' ' to detect each integer.
	 * 
	 * @param string
	 * @return
	 * @throws EmptyContentException
	 * @throws NumberSizeMismatchException
	 */
	public static int[] stringToInt(String inString) throws EmptyContentException {
		String string = deleteDuplicateSpace(inString);
		int[] collectInt = new int[getStrinSize(string)];
		try {
			String temp = ""; // Set a temporary string.
			int idx = 0; // Index of stored integer
			for (int i = 0; i < string.length(); i++) {
				// Check space
				if (string.charAt(i) != ' ') {
					temp += string.charAt(i); // Add the string to temp
				} else {
					collectInt[idx++] = Integer.parseInt(temp); // temp to integer
					temp = ""; // reset temp
				}
			}
			collectInt[idx] = Integer.parseInt(temp);
		} catch (StringIndexOutOfBoundsException e) {
			throw new EmptyContentException();
		}
		return collectInt;
	}

	/**
	 * Get the total number of the string, using ' ' to determine a string.
	 * 
	 * @param s
	 * @return
	 */
	public static int getStrinSize(String s) {
		int length = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				length++;
			}
		}
		return length;
	}

	/**
	 * Delete all the duplicate spaces and last space in a string.
	 * 
	 * @param s
	 * @return
	 */
	public static String deleteDuplicateSpace(String s) {
		String temp = "";
		for (int i = getSkipHeadSpaceNum(s); i < s.length() - 1; i++) {
			// Don't not scan last space.
			if (i == s.length() && s.charAt(i) == 32) {
				break;
			}
			// Skip all double spaces between digits and digits.
			if (i < s.length() - 1 && s.charAt(i) == 32 && s.charAt(i + 1) == 32) {
				continue;
			}
			temp += s.charAt(i);
		}
		return temp;
	}

	/**
	 * count how many numbers that skip spaces before a string.
	 * 
	 * @param s
	 * @return
	 * @throws EmptyContentException
	 */
	public static int getSkipHeadSpaceNum(String s) throws EmptyContentException {
		int i = 0;
		// Skip all spaces that on the start..
		try {
			while (s.charAt(i) == ' ') {
				i++;
			}
			return i;
		} catch (StringIndexOutOfBoundsException e) {
			throw new EmptyContentException();
		}
	}

	/**
	 * Convert the alphabet to integer. Format: A=1, B=2 and so on.
	 * 
	 * @param alphabet
	 * @return
	 */
	public static int charToInt(char alphabet) {
		return alphabet - 64;
	}

	/**
	 * Read the file first line, and return a String
	 * 
	 * @param fileName
	 * @return
	 * @throws EmptyContentException
	 */
	public static String loadFile(String fileName) throws EmptyContentException {
		try {
			Scanner sc = new Scanner(new File(fileName));
			String cardSet = "";
			while (sc.hasNextLine()) {
				cardSet += sc.nextLine() + " ";
				if (loadOneLineOnly) {
					sc.close();
					return cardSet;
				}
			}
			sc.close();
			return cardSet;
		} catch (FileNotFoundException e) {
			helpMsg("nofile");
			System.exit(0);
		}
		return "";
	}

	/**
	 * Help message displays when some errors occurs.
	 * 
	 * @param type
	 */
	public static void helpMsg(String type) {
		switch (type) {
		case "nofile":
			System.out.println("File Not found!");
			break;
		}
		helpMsg();
	}

	/**
	 * Help message displays when some errors occurs.
	 */
	public static void helpMsg() {
		System.out.println("Usage: <option> <deck_file> <message_string>");

	}

	/**
	 * Decrypt the message by using the key stream.
	 * 
	 * @param cardSet
	 * @param msg
	 */
	public static void decryptMsg(int[] cardSet, char[] msg) {
		int[] keyCode = loadPassWord(cardSet);
		char[] decryptMsg = new char[msg.length];
		for (int i = 0; i < msg.length; i++) {
			char c = msg[i];
			// if the value is not more than 26, it will plus 26.
			int add = 0;
			while((charToInt(c)+add - keyCode[i]) <= 0) {
				add+=26;
			}
			int decrypt = (charToInt(c) - keyCode[i]) <= 0 ? ((charToInt(c) - keyCode[i])) + add
					: (charToInt(c) - keyCode[i]);
			decryptMsg[i] = (char) (decrypt + 64); // change the integer to character.
			System.out.printf("%c\t%d\t%d\t%d\t%c\n", c, charToInt(c), keyCode[i], decrypt, decryptMsg[i]);
		}
		System.out.print("Decrypted message: ");
		for (char c : decryptMsg) {
			System.out.print(c);
		}
	}

	/**
	 * Encrypt the message by using the key stream.
	 * 
	 * @param cardSet
	 * @param msg
	 */
	public static void encryptMsg(int[] cardSet, char[] msg) {
		Keystream.generateKeystream(cardSet, msg, false);
		char[] encryptMsg = new char[msg.length];
		for (int i = 0; i < msg.length; i++) {
			char c = msg[i];
			// more than 26 will get the remainder of dividing 26.
			int encrypt = (charToInt(c) + Keystream.keyCode[i]) > 26 ? (charToInt(c) + Keystream.keyCode[i]) % 26
					: (charToInt(c) + Keystream.keyCode[i]);
			encryptMsg[i] = (char) (encrypt + 64); // change the integer to character.
			System.out.printf("%c\t%d\t%d\t%d\t%c\n", c, charToInt(c), Keystream.keyCode[i], encrypt, encryptMsg[i]);
		}
		System.out.print("Encrypted message: ");
		for (char c : encryptMsg) {
			System.out.print(c);
		}
	}
	
	public static int[] loadPassWord(int[] cardSet) {
		int[] password = new int[cardSet.length];
		for(int i =0; i<password.length; i++) {
			password[i] = cardSet[i];
		}
		return password;
	}

}
