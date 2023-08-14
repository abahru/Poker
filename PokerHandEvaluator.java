package poker;

public class PokerHandEvaluator {

	public static boolean hasPair(Card[] cards) {
		// Check for pairs of cards with the same rank
		for (int i = 0; i < cards.length - 1; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean hasTwoPair(Card[] cards) {
		// Check for two pairs of cards with different ranks
		int pair = 0;
		int first = -1;
		for (int i = 0; i < cards.length - 1; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					if (first == -1 || cards[i].getValue() != first) {
						pair++;
						first = cards[i].getValue();
					}
					if (pair == 2) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean hasThreeOfAKind(Card[] cards) {
		// Check for three cards with the same rank
		for (int i = 0; i < cards.length - 2; i++) {
			for (int j = i + 1; j < cards.length - 1; j++) {
				for (int k = j + 1; k < cards.length; k++) {
					if (cards[i].getValue() == cards[j].getValue()
							&& cards[j].getValue() == cards[k].getValue()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean hasStraight(Card[] cards) {
		// checks if there is a straight in the cards.
		int count = 0;
		int frequency = 0;
		int maxVal = 5;

		for (int i = 1; i <= 13; i++) {
			frequency = 0;
			for (int j = 0; j < cards.length; j++) {
				if (cards[j].getValue() == i) {
					frequency++;
				}
			}
			if (frequency == 1) {
				count++;
			} else {
				count = 0;
			}
			if (count == maxVal) {
				return true;
			}
		}

		frequency = 0;
		for (int j = 0; j < cards.length; j++) {
			if (cards[j].getValue() == 1) {
				frequency++;
			}
		}
		if (frequency == 1) {
			count = 1;
			for (int i = 10; i <= 13; i++) {
				frequency = 0;
				for (int j = 0; j < cards.length; j++) {
					if (cards[j].getValue() == i) {
						frequency++;
					}
				}
				if (frequency == 1) {
					count++;
				} else {
					count = 0;
				}
				if (count == maxVal) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean hasFlush(Card[] cards) {
		// Count the number of cards with the same suit as the first card
		int count = 0;
		int suit = cards[0].getSuit();
		for (int i = 1; i < cards.length; i++) {
			if (cards[i].getSuit() == suit) {
				count++;
			}
		}
		return count == 4;
	}

	public static boolean hasFullHouse(Card[] cards) {
		// whether the given array of cards has a full house
		int[] values = new int[13];
		for (int i = 0; i < cards.length; i++) {
			values[cards[i].getValue() - 1]++;
		}
		boolean hasThreeOfAKind = false;
		boolean hasPair = false;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == 3) {
				hasThreeOfAKind = true;
			} else if (values[i] == 2) {
				hasPair = true;
			}
		}
		return hasThreeOfAKind && hasPair;
	}

	public static boolean hasFourOfAKind(Card[] cards) {
		// Count the number of cards with each rank and check for four of a kind
		int[] values = new int[13];
		for (Card card : cards) {
			values[card.getValue() - 1]++;
		}
		for (int i = 0; i < 13; i++) {
			if (values[i] == 4) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasStraightFlush(Card[] cards) {
		// Check if the cards have a flush
		if (!hasFlush(cards)) {
			return false;
		}
		// Check if the cards have a straight
		int min = cards[0].getValue();
		int max = cards[0].getValue();
		for (int i = 1; i < cards.length; i++) {
			int value = cards[i].getValue();
			if (value < min) {
				min = value;
			}
			if (value > max) {
				max = value;
			}
		}
		if (max - min != 4) {
			return false;
		}
		return true;
	}
}
