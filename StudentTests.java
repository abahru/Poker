package poker;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTests {

	@Test
	public void testHasPair() {
		Card[] cards = { new Card(2, 0), new Card(3, 1), new Card(6, 3), new Card(6, 2),
				new Card(10, 2) };
		assertTrue(PokerHandEvaluator.hasPair(cards));

		Card[] cards2 = { new Card(2, 0), new Card(3, 1), new Card(6, 3), new Card(7, 2),
				new Card(10, 2) };
		assertFalse(PokerHandEvaluator.hasPair(cards2));
	}

	@Test
	public void testHasTwoPair() {
		Card[] cards = { new Card(2, 0), new Card(2, 1), new Card(6, 3), new Card(6, 2),
				new Card(10, 2) };
		assertTrue(PokerHandEvaluator.hasTwoPair(cards));

		Card[] cards2 = { new Card(2, 0), new Card(2, 1), new Card(2, 3), new Card(6, 2),
				new Card(10, 2) };
		assertFalse(PokerHandEvaluator.hasTwoPair(cards2));
	}

	@Test
	public void testHasThreeOfAKind() {
		Card[] cards1 = { new Card(2, 0), new Card(2, 1), new Card(2, 3), new Card(6, 2),
				new Card(10, 2) };
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(cards1));

		Card[] cards2 = { new Card(2, 0), new Card(2, 1), new Card(6, 3), new Card(6, 2),
				new Card(10, 2) };
		assertFalse(PokerHandEvaluator.hasThreeOfAKind(cards2));
	}

	@Test
	public void testHasStraight() {
		Card[] cards1 = { new Card(2, 0), new Card(3, 1), new Card(4, 3), new Card(5, 2),
				new Card(6, 2) };
		assertTrue(PokerHandEvaluator.hasStraight(cards1));

		Card[] cards3 = { new Card(10, 0), new Card(11, 1), new Card(12, 3),
				new Card(13, 2), new Card(1, 2) };
		assertTrue(PokerHandEvaluator.hasStraight(cards3));

		Card[] cards2 = { new Card(2, 0), new Card(3, 1), new Card(6, 3), new Card(7, 2),
				new Card(10, 2) };
		assertFalse(PokerHandEvaluator.hasStraight(cards2));
	}

	@Test
	public void testHasFlush() {
		Card[] cards = { new Card(2, 0), new Card(4, 0), new Card(6, 0), new Card(8, 0),
				new Card(10, 0) };
		assertTrue(PokerHandEvaluator.hasFlush(cards));
	}

	@Test
	public void testHasFullHouse() {
		Card[] cards = new Card[] { new Card(5, 3), new Card(5, 2), new Card(5, 2),
				new Card(10, 0), new Card(10, 2) };
		assertTrue(PokerHandEvaluator.hasFullHouse(cards));

		Card[] cards2 = new Card[] { new Card(5, 3), new Card(5, 2), new Card(5, 2),
				new Card(10, 0), new Card(3, 2) };
		assertFalse(PokerHandEvaluator.hasFullHouse(cards2));
	}

	@Test
	public void testHasFourOfAKind() {
		Card[] cards = new Card[] { new Card(3, 3), new Card(3, 2), new Card(3, 1),
				new Card(3, 0), new Card(13, 2) };
		assertTrue(PokerHandEvaluator.hasFourOfAKind(cards));
	}

	@Test
	public void testhasStraightFlush() {

		Card[] fiveDeckTrueStraightFlush = { new Card(10, 1), new Card(9, 1),
				new Card(11, 1), new Card(12, 1), new Card(13, 1) };

		Card[] fiveDeckFalseStraightFlush = { new Card(1, 0), new Card(2, 0),
				new Card(3, 1), new Card(4, 0), new Card(7, 0) };

		assertTrue(PokerHandEvaluator.hasStraightFlush(fiveDeckTrueStraightFlush));
		assertFalse(PokerHandEvaluator.hasStraightFlush(fiveDeckFalseStraightFlush));

	}

}