public class Card {
    private final Face face;
    private final Suit suit;
    
    public enum Face { ACE, DEUCE, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }

    public enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES }

    public Card(Face cardFace, Suit cardSuit) {
        this.face = cardFace;
        this.suit = cardSuit;
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        return face + " of " + suit;
    }
}