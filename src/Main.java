import java.util.Scanner;

class TestandoListas {

    public static void main(String[] args) {

        DeckOfCards dealer = new DeckOfCards();
        dealer.dealInitialHand();
        dealer.dealInitialHandDealer();
        Scanner sc = new Scanner(System.in);

        System.out.println("Mão inicial do carteador (no escuro):");

        int cardsToReplace = dealer.evaluateHand(dealer.dealerHand);
        System.out.println("Carteador decidiu substituir " + cardsToReplace + " cartas");

        boolean[] replace = new boolean[5];
        for (int i = 0; i < cardsToReplace; i++) {
            replace[i] = true;
        }

        dealer.replaceCards(replace, dealer.dealerHand);

        System.out.println("Sua mâo:");
        dealer.showHand(dealer.hand);
        System.out.println("Deseja substituir quantas cartas? Selecione 0 para não substituir e 1 para substituir");

        boolean[] replaceHand = new boolean[5];
        for (int i = 0; i < replaceHand.length; i++) {
            System.out.printf("Posição "+i+": ");
            int sc1 = sc.nextInt();

            if (sc1 == 1) {
                replaceHand[i] = true;
            }
            if (sc1 == 0){
                replaceHand[i] = false;
            }
        }

        dealer.replaceCards(replaceHand, dealer.hand);


        System.out.println("Mão final do dealer ☹:");
        System.out.println();
        dealer.showHand(dealer.dealerHand);
        System.out.println();
        System.out.println("Mão final sua ☺ :");
        System.out.println();
        dealer.showHand(dealer.hand);
        System.out.println();


        dealer.printDeck(dealer.dealerHand);
        System.out.println();
        dealer.printDeck(dealer.hand);


        if(dealer.evaluateHand(dealer.dealerHand) > dealer.evaluateHand(dealer.hand)){
            System.out.printf("Dealer wins");
        }
        if (dealer.evaluateHand(dealer.dealerHand) < dealer.evaluateHand(dealer.hand)) {
            System.out.printf("You wins");
        }
        if (dealer.evaluateHand(dealer.dealerHand) == dealer.evaluateHand(dealer.hand)) {
            {
            System.out.printf("Draw");
        }


    }


}}









