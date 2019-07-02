package ive.dsa.solitaire;

/**
 * It is interface for Keystream. You can know all the method of this interface.
 * 
 * @author POON Ngai Kuen (180091780)
 * @version 1.0
 */

public interface InterKeystream {
	/**
	 * Swap JockerA which is after it.
	 * 
	 * @param swap
	 */
	void swapJokerA();

	/**
	 * Place jokerB to after two cards.
	 * 
	 * @param card
	 */
	void jokerB_MoveBackTwo();

	/**
	 * This method will cut the card set to three. Set jokerA and jokerB value, it
	 * will use them to choose card set. The cards which are after the first joker
	 * will be cardSetA The cards which are between the first joker and the second
	 * joker will be cardSetB (include jokerA and jockerB) The cards which are after
	 * the second joker will be cardSetC Then, cardSetC will swap with cardSetA
	 * 
	 * @param jokerA
	 * @param jokerB
	 */
	void tripleCut();

	/**
	 * Generate Keystream from the cardSet
	 * 
	 * @param jokerA
	 * @return
	 */
	Object generateKeystreamValue();

	/*
	 * Choose last card value and use the value as the range of choosing card. The
	 * chosen cards will be place before the last card.
	 */
	void moveCardSetToLastCardBefore();
}
