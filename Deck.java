package poker;

public class Deck {

	private Card[] cards;

	public Deck() {
		// Create a new array of 52 Card objects
		this.cards = new Card[52];
		// Initialize index to 0
		int index = 0;
		// Loop through each of the 4 suits
		for (int suit = 0; suit < 4; suit++) {
			// Loop through each of the 13 card values
			for (int value = 1; value <= 13; value++) {
				// Create a new Card object with the current suit and value
				// then add it to the cards array at the current index
				this.cards[index] = new Card(value, suit);
				// increment the index
				index++;
			}
		}
	}

	public Deck(Deck other) {
		// Create a new array of Card objects with the same length as the cards array of
		// the other Deck object
		cards = new Card[other.cards.length];
		// Copy each Card object from the other Deck object's cards array into the new
		// cards array
		for (int i = 0; i < other.cards.length; i++) {
			cards[i] = other.cards[i];
		}
	}

	public Card getCardAt(int position) {
		// Returns the Card object at the specified position in the cards array
		return cards[position];
	}

	public int getNumCards() {
		// Returns the number of cards in the deck
		return cards.length;
	}

	public void shuffle() {
		// Create a new array of Card objects with the same length as the cards array
		Card[] shuffled = new Card[cards.length];
		// Determine the midpoint of the cards array
		int midpoint = 0;
		if (shuffled.length % 2 == 0) {
			midpoint = cards.length / 2;

		} else {
			midpoint = cards.length / 2 + 1;
		}
		// Interleave the cards from the two halves of the cards array
		for (int i = 0; i < shuffled.length; i++) {
			if (i % 2 == 0) {
				shuffled[i] = cards[i / 2];
			} else {
				shuffled[i] = cards[midpoint + i / 2];
			}
		}
		// Replace the cards array with the shuffled array
		cards = shuffled;

	}

	public void cut(int position) {
		// Create a temporary array to hold the cards before the position
		Card[] temp = new Card[position];
		// Copy the cards before the position into the temporary array
		for (int i = 0; i < position; i++) {
			temp[i] = cards[i];
		}
		// Move the cards after the position to the beginning of the cards array
		for (int i = position; i < cards.length; i++) {
			cards[i - position] = cards[i];
		}
		// Move the cards in the temporary array to the end of the cards array
		for (int i = 0; i < position; i++) {
			cards[cards.length - position + i] = temp[i];
		}
	}

	public Card[] deal(int numCards) {
		// Create a new array to hold the dealt cards
		Card[] dealt = new Card[numCards];
		// Create a new array to hold the remaining cards in the deck
		Card[] smaller = new Card[cards.length - numCards];
		// Copy the first numCards cards from the deck into the dealt array
		for (int i = 0; i < numCards; i++) {
			dealt[i] = cards[i];
		}
		// Copy the remaining cards from the deck into the smaller array
		for (int i = 0; i < smaller.length; i++) {
			smaller[i] = cards[numCards + i];
		}
		// Set the cards array to the smaller array, effectively removing the dealt
		// cards from the deck
		cards = smaller;
		// Return the array of dealt cards
		return dealt;
	}

}
