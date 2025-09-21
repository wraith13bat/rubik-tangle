package tangle;


/*
 * A card properties
 *       0   1
 *      +-----+
 *    7 |     | 2
 *      |     |
 *    6 |     | 3
 *      +-----+
 *       5   4
 *
 * K : blue
 * Z : green
 * P : red
 * S : yellow
 *
 *
 */


public class Card {
    private String[] cardFront = { "0", "0", "0", "0", "0", "0", "0", "0" };
    private String[] cardBack = { "0", "0", "0", "0", "0", "0", "0", "0" };

    //set card front
    public void setCardFront(String c0, String c1, String c2, String c3, String c4, String c5, String c6, String c7) {
        cardFront[0] = c0;
        cardFront[1] = c1;
        cardFront[2] = c2;
        cardFront[3] = c3;
        cardFront[4] = c4;
        cardFront[5] = c5;
        cardFront[6] = c6;
        cardFront[7] = c7;
    }

    //set card back
    public void setCardBack(String c0, String c1, String c2, String c3, String c4, String c5, String c6, String c7) {
        cardBack[0] = c0;
        cardBack[1] = c1;
        cardBack[2] = c2;
        cardBack[3] = c3;
        cardBack[4] = c4;
        cardBack[5] = c5;
        cardBack[6] = c6;
        cardBack[7] = c7;
    }

    //flip the card
    public void flipCard() {
        for (int i = 0; i <= 7; i++) {
            String tmp = cardFront[i];
            cardFront[i] = cardBack[i];
            cardBack[i] = tmp;
        }
    }

    //rotate the card
    public void rotateCard() {
        String tmp0 = cardFront[0];
        String tmp1 = cardFront[1];
        cardFront[0] = cardFront[6];
        cardFront[1] = cardFront[7];
        cardFront[6] = cardFront[4];
        cardFront[7] = cardFront[5];
        cardFront[4] = cardFront[2];
        cardFront[5] = cardFront[3];
        cardFront[2] = tmp0;
        cardFront[3] = tmp1;

        /*tmp0 = cardBack[0];
        tmp1 = cardBack[1];
        cardBack[0] = cardBack[2];
        cardBack[1] = cardBack[3];
        cardBack[2] = cardBack[4];
        cardBack[3] = cardBack[5];
        cardBack[4] = cardBack[6];
        cardBack[5] = cardBack[7];
        cardBack[6] = tmp0;
        cardBack[7] = tmp1;*/

    }

    //print colours of front of card
    public String printCard() {
        return (cardFront[0] + cardFront[1] + cardFront[2] + cardFront[3] + cardFront[4] + cardFront[5] + cardFront[6] +
                cardFront[7]);
    }


    //return colour of front of card, order by 01726354
    public String returnCard() {
        return (cardFront[0] + cardFront[1] + cardFront[7] + cardFront[2] + cardFront[6] + cardFront[3] + cardFront[5] +
                cardFront[4]);
    }


    //return n-th colour of front of card
    public String getCard(int n) {
        return (cardFront[n]);
    }

}


