package tangle;


/*
 * print result in text console
 *
 */


public class Table {
    private char[][] table;
    private int cardNumber = 0;

    public Table() {
        table = new char[26][81];
    }


    public void delete() {
        cardNumber = 0;
        for (int i = 1; i <= 25; i++) {
            for (int j = 1; j <= 80; j++) {
                table[i][j] = ' ';
            }
        }
    }

    public void add(String c) {
        cardNumber++;
        char k1 = c.charAt(0);
        char k2 = c.charAt(1);
        char k3 = c.charAt(2);
        char k4 = c.charAt(3);
        char k5 = c.charAt(4);
        char k6 = c.charAt(5);
        char k7 = c.charAt(6);
        char k8 = c.charAt(7);

        if (cardNumber == 1) {
            table[1][2] = k1;
            table[1][3] = k2;
            table[2][1] = k3;
            table[2][4] = k4;
            table[3][1] = k5;
            table[3][4] = k6;
            table[4][2] = k7;
            table[4][3] = k8;
            table[2][2] = '+';
            table[2][3] = '+';
            table[3][2] = '+';
            table[3][3] = '+';
        }

        if (cardNumber == 2) {
            table[1][7] = k1;
            table[1][8] = k2;
            table[2][6] = k3;
            table[2][9] = k4;
            table[3][6] = k5;
            table[3][9] = k6;
            table[4][7] = k7;
            table[4][8] = k8;
            table[2][7] = '+';
            table[2][8] = '+';
            table[3][7] = '+';
            table[3][8] = '+';

        }

        if (cardNumber == 3) {
            table[1][12] = k1;
            table[1][13] = k2;
            table[2][11] = k3;
            table[2][14] = k4;
            table[3][11] = k5;
            table[3][14] = k6;
            table[4][12] = k7;
            table[4][13] = k8;
            table[2][12] = '+';
            table[2][13] = '+';
            table[3][12] = '+';
            table[3][13] = '+';

        }

        if (cardNumber == 4) {
            table[5][2] = k1;
            table[5][3] = k2;
            table[6][1] = k3;
            table[6][4] = k4;
            table[7][1] = k5;
            table[7][4] = k6;
            table[8][2] = k7;
            table[8][3] = k8;
            table[6][2] = '+';
            table[6][3] = '+';
            table[7][2] = '+';
            table[7][3] = '+';

        }

        if (cardNumber == 5) {
            table[5][7] = k1;
            table[5][8] = k2;
            table[6][6] = k3;
            table[6][9] = k4;
            table[7][6] = k5;
            table[7][9] = k6;
            table[8][7] = k7;
            table[8][8] = k8;
            table[6][7] = '+';
            table[6][8] = '+';
            table[7][7] = '+';
            table[7][8] = '+';

        }

        if (cardNumber == 6) {
            table[5][12] = k1;
            table[5][13] = k2;
            table[6][11] = k3;
            table[6][14] = k4;
            table[7][11] = k5;
            table[7][14] = k6;
            table[8][12] = k7;
            table[8][13] = k8;
            table[6][12] = '+';
            table[6][13] = '+';
            table[7][12] = '+';
            table[7][13] = '+';

        }

        if (cardNumber == 7) {
            table[9][2] = k1;
            table[9][3] = k2;
            table[10][1] = k3;
            table[10][4] = k4;
            table[11][1] = k5;
            table[11][4] = k6;
            table[12][2] = k7;
            table[12][3] = k8;
            table[10][2] = '+';
            table[10][3] = '+';
            table[11][2] = '+';
            table[11][3] = '+';

        }

        if (cardNumber == 8) {
            table[9][7] = k1;
            table[9][8] = k2;
            table[10][6] = k3;
            table[10][9] = k4;
            table[11][6] = k5;
            table[11][9] = k6;
            table[12][7] = k7;
            table[12][8] = k8;
            table[10][7] = '+';
            table[10][8] = '+';
            table[11][7] = '+';
            table[11][8] = '+';

        }

        if (cardNumber == 9) {
            table[9][12] = k1;
            table[9][13] = k2;
            table[10][11] = k3;
            table[10][14] = k4;
            table[11][11] = k5;
            table[11][14] = k6;
            table[12][12] = k7;
            table[12][13] = k8;
            table[10][12] = '+';
            table[10][13] = '+';
            table[11][12] = '+';
            table[11][13] = '+';

        }

    }

    public void print() {
        for (int i = 1; i <= 21; i++) {
            for (int j = 1; j <= 70; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }

}


