package ive.dsa.solitaire;

/**
 * It is a abstract class for how to generate a key.
 * 
 * @author POON Ngai Kuen (180091780)
 * @version 1.0
 */

public abstract class Key extends Solitaire implements GenerateKey {

	public Key(int[] cardSet) {
		super(cardSet);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void swapJokerA() {
		ll.swapNextItem(SolitaireTool.jokerA);
	}

	@Override
	public void jokerB_MoveBackTwo() {
		ll.moveBackTwo(SolitaireTool.jokerB);
	}

	@Override
	public void tripleCut() {
		ll.swapListedSetItem(SolitaireTool.jokerA, SolitaireTool.jokerB);
	}

	@Override
	public void moveCardSetToLastCardBefore() {
		ll.insertToTailBefore(SolitaireTool.jokerA);
	}

	@Override
	public Object generateKeystreamValue() {
		return ll.getItemByHead(SolitaireTool.jokerA);
	}
}
