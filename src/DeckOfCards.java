import java.security.SecureRandom;

public class DeckOfCards {
    private Card[] deck;
    public Card[] hand;
    public Card[] dealerHand;
    private int currentCard;
    private static final int NUMBER_OF_CARDS = 52;
    private static final SecureRandom randomNumbers = new SecureRandom();

    private final Card.Face[] faces = Card.Face.values();
    private final Card.Suit[] suits = Card.Suit.values();

    public DeckOfCards() {

        deck = new Card[NUMBER_OF_CARDS];
        hand = new Card[5];
        dealerHand = new Card[5];
        currentCard = 0;

        int count = 0;
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Face face : Card.Face.values()) {
                deck[count++] = new Card(face, suit);
            }
        }
        shuffle();
    }


    public void shuffle() {
        currentCard = 0;

        for (int i = deck.length - 1; i > 0; i--) {

            int j = randomNumbers.nextInt(i + 1);

            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }


    public void dealInitialHand() {
        for (int i = 0; i < 5; i++) {
            hand[i] = dealCard();
        }
    }

    public void dealInitialHandDealer() {
        for (int i = 0; i < 5; i++) {
            dealerHand[i] = dealCard();
        }
    }

    public void replaceCards(boolean[] cardsToReplace, Card[] s) {
        for (int i = 0; i < 5; i++) {
            if (cardsToReplace[i]) {
                s[i] = dealCard();
            }
        }
    }

    public int evaluateHand(Card[] p) {
        if (hasRoyalFlush(p)) return 10;
        if (hasStraightFlush(p)) return 9;
        if (hasFourOfAKind(p)) return 8;
        if (hasFullHouse(p)) return 7;
        if (hasFlush(p)) return 6;
        if (hasStraight(p)) return 5;
        if (hasThreeOfAKind(p)) return 4;
        if (hasTwoPairs(p)) return 3;
        if (isPar(p)) return 2;

        return 1;
    }

    public boolean isPar(Card[] p){
        for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                if (p[i].getFace().equals(p[j].getFace()))
                    return true;
            }
        }
        return false;
    }

    public boolean hasTwoPairs(Card[] p) {
        int pairCount = 0;
        Card.Face[] checkedFaces = new Card.Face[2];

        outer:
        for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                if (p[i].getFace() == (p[j].getFace())) {
                    for (Card.Face face : checkedFaces) {
                        if (face == p[i].getFace()) {
                            continue outer;
                        }
                    }
                    pairCount++;
                    if (pairCount == 1) {
                        checkedFaces[0] = p[i].getFace();
                    } else {
                        checkedFaces[1] = p[i].getFace();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasThreeOfAKind(Card[] p) {
        for (int i = 0; i < p.length; i++) {
            int count = 1;
            for (int j = i + 1; j < p.length; j++) {
                if (p[i].getFace().equals(p[j].getFace())) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean hasStraight(Card[] p) {
        int[] faceValues = new int[5];
        String[] facesOrder = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };

        // Converte as faces para valores numéricos (0 a 12)
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < facesOrder.length; j++) {
                if (p[i].getFace().equals(facesOrder[j])) {
                    faceValues[i] = j;
                    break;
                }
            }
        }

        // Ordena os valores
        java.util.Arrays.sort(faceValues);

        // Verifica se são consecutivos (ex: 3,4,5,6,7)
        for (int i = 1; i < faceValues.length; i++) {
            if (faceValues[i] != faceValues[i - 1] + 1) {
                return false;
            }
        }
        return true;
    }

    public boolean hasFlush(Card[] p) {
        Enum firstSuit = p[0].getSuit();
        for (Card card : p) {
            if (!card.getSuit().equals(firstSuit)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasFullHouse(Card[] p) {
        return hasThreeOfAKind(p) && isPar(p);
    }

    public boolean hasFourOfAKind(Card[] p) {
        for (int i = 0; i < p.length; i++) {
            int count = 1;
            for (int j = i + 1; j < p.length; j++) {
                if (p[i].getFace().equals(p[j].getFace())) {
                    count++;
                }
            }
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean hasStraightFlush(Card[] p) {
        return hasStraight(p) && hasFlush(p);
    }

    public boolean hasRoyalFlush(Card[] p) {
        if (!hasFlush(p)) return false;

        boolean hasAce = false, hasKing = false, hasQueen = false, hasJack = false, hasTen = false;
        for (Card card : p) {
            switch (card.getFace()) {
                case ACE: hasAce = true; break;
                case KING: hasKing = true; break;
                case QUEEN: hasQueen = true; break;
                case JACK: hasJack = true; break;
                case TEN: hasTen = true; break;
                default: break;

            }
        }

        return hasAce && hasKing && hasQueen && hasJack && hasTen;
    }

    public void printDeck(Card[] p){
        System.out.println("Tem um par? " + isPar(p));
        System.out.println("Tem dois par? " + hasTwoPairs(p));
        System.out.println("Tem trinca? " + hasThreeOfAKind(p));
        System.out.println("Tem sequência ? " + hasStraight(p));
        System.out.println("Tem um flush? " + hasFlush(p));
        System.out.println("Tem um full house? " + hasFullHouse(p));
        System.out.println("Tem uma quadra? " + hasFourOfAKind(p));
        System.out.println("Tem um straight flush? " + hasStraightFlush(p));
        System.out.println("Tem um royal flush? " + hasRoyalFlush(p));
        System.out.println();
    }

    public void showHand(Card[] p) {
        for (Card card : p) {
            System.out.println(card);
        }
    }
    // Distribui uma carta do baralho
    public Card dealCard() {
        // Verifica se ainda há cartas no baralho
        if (currentCard < deck.length) {
            return deck[currentCard++]; // Retorna a carta atual e avança o índice
        } else {
            return null; // Todas as cartas já foram distribuídas
        }
    }
}