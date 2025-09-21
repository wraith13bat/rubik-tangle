package tangle;

/*
 * searching solve in other thread
 *
 */


public class Solve implements Runnable {
    protected static boolean stopRequested = false;

    @Override
    public void run() {

        Table t;
        t = new Table();

        long count = 0;
        Layout.variation.setText(Long.toString(count));

        outerloop:
        for (

        int i1 = 1; i1 <= 9; i1++) {
            for (int f1 = 1; f1 <= 2; f1++) {
                Layout.card[i1].flipCard();
                for (int r1 = 1; r1 <= 4; r1++) {
                    Layout.card[i1].rotateCard();
                    Layout.delete();
                    count++;
                    Layout.variation.setText(Long.toString(count));
                    //Layout.berak(1, Layout.k[i1].printKartya());
                    Layout.put(1, i1);
                    if (stopRequested) {
                        break outerloop;
                    }
                    ;
                    for (int i2 = 1; i2 <= 9; i2++) {
                        if (i1 == i2) {
                            continue;
                        }
                        ;
                        for (int f2 = 1; f2 <= 2; f2++) {
                            Layout.card[i2].flipCard();
                            for (int r2 = 1; r2 <= 4; r2++) {
                                Layout.card[i2].rotateCard();
                                count++;
                                Layout.variation.setText(Long.toString(count));
                                Layout.put(2, i2);
                                if (stopRequested) {
                                    break outerloop;
                                }
                                ;
                                if (!Layout.card[i1].getCard(2).equals(Layout.card[i2].getCard(7))) {
                                    continue;
                                }
                                if (!Layout.card[i1].getCard(3).equals(Layout.card[i2].getCard(6))) {
                                    continue;
                                }
                                for (int i3 = 1; i3 <= 9; i3++) {
                                    if (i1 == i3 || i2 == i3) {
                                        continue;
                                    }
                                    ;
                                    for (int f3 = 1; f3 <= 2; f3++) {
                                        Layout.card[i3].flipCard();
                                        for (int r3 = 1; r3 <= 4; r3++) {
                                            Layout.card[i3].rotateCard();
                                            count++;
                                            Layout.variation.setText(Long.toString(count));
                                            Layout.put(3, i3);
                                            if (stopRequested) {
                                                break outerloop;
                                            }
                                            ;
                                            if (!Layout.card[i2].getCard(2).equals(Layout.card[i3].getCard(7))) {
                                                continue;
                                            }
                                            if (!Layout.card[i2].getCard(3).equals(Layout.card[i3].getCard(6))) {
                                                continue;
                                            }
                                            for (int i4 = 1; i4 <= 9; i4++) {
                                                if (i1 == i4 || i2 == i4 || i3 == i4) {
                                                    continue;
                                                }
                                                ;
                                                for (int f4 = 1; f4 <= 2; f4++) {
                                                    Layout.card[i4].flipCard();
                                                    for (int r4 = 1; r4 <= 4; r4++) {
                                                        Layout.card[i4].rotateCard();
                                                        count++;
                                                        Layout.variation.setText(Long.toString(count));
                                                        Layout.put(4, i4);
                                                        if (stopRequested) {
                                                            break outerloop;
                                                        }
                                                        ;
                                                        if (!Layout.card[i1].getCard(5).equals(Layout.card[i4].getCard(0))) {
                                                            continue;
                                                        }
                                                        if (!Layout.card[i1].getCard(4).equals(Layout.card[i4].getCard(1))) {
                                                            continue;
                                                        }
                                                        for (int i5 = 1; i5 <= 9; i5++) {
                                                            if (i1 == i5 || i2 == i5 || i3 == i5 || i4 == i5) {
                                                                continue;
                                                            }
                                                            ;

                                                            for (int f5 = 1; f5 <= 2; f5++) {
                                                                Layout.card[i5].flipCard();
                                                                for (int r5 = 1; r5 <= 4; r5++) {
                                                                    Layout.card[i5].rotateCard();
                                                                    count++;
                                                                    Layout.variation.setText(Long.toString(count));
                                                                    Layout.put(5, i5);
                                                                    if (stopRequested) {
                                                                        break outerloop;
                                                                    }
                                                                    ;
                                                                    if (!Layout.card[i4].getCard(2).equals(Layout.card[i5].getCard(7))) {
                                                                        continue;
                                                                    }
                                                                    if (!Layout.card[i4].getCard(3).equals(Layout.card[i5].getCard(6))) {
                                                                        continue;
                                                                    }
                                                                    if (!Layout.card[i2].getCard(5).equals(Layout.card[i5].getCard(0))) {
                                                                        continue;
                                                                    }
                                                                    if (!Layout.card[i2].getCard(4).equals(Layout.card[i5].getCard(1))) {
                                                                        continue;
                                                                    }
                                                                    for (int i6 = 1; i6 <= 9; i6++) {
                                                                        if (i1 == i6 || i2 == i6 || i3 == i6 ||
                                                                            i4 == i6 || i5 == i6) {
                                                                            continue;
                                                                        }
                                                                        ;

                                                                        for (int f6 = 1; f6 <= 2; f6++) {
                                                                            Layout.card[i6].flipCard();
                                                                            for (int r6 = 1; r6 <= 4; r6++) {
                                                                                Layout.card[i6].rotateCard();
                                                                                count++;
                                                                                Layout.variation.setText(Long.toString(count));
                                                                                Layout.put(6, i6);
                                                                                if (stopRequested) {
                                                                                    break outerloop;
                                                                                }
                                                                                ;
                                                                                if (!Layout.card[i5].getCard(2).equals(Layout.card[i6].getCard(7))) {
                                                                                    continue;
                                                                                }
                                                                                if (!Layout.card[i5].getCard(3).equals(Layout.card[i6].getCard(6))) {
                                                                                    continue;
                                                                                }
                                                                                if (!Layout.card[i3].getCard(5).equals(Layout.card[i6].getCard(0))) {
                                                                                    continue;
                                                                                }
                                                                                if (!Layout.card[i3].getCard(4).equals(Layout.card[i6].getCard(1))) {
                                                                                    continue;
                                                                                }
                                                                                for (int i7 = 1; i7 <= 9; i7++) {
                                                                                    if (i1 == i7 || i2 == i7 ||
                                                                                        i3 == i7 || i4 == i7 ||
                                                                                        i5 == i7 || i6 == i7) {
                                                                                        continue;
                                                                                    }
                                                                                    ;

                                                                                    for (int f7 = 1; f7 <= 2; f7++) {
                                                                                        Layout.card[i7].flipCard();
                                                                                        for (int r7 = 1; r7 <= 4;
                                                                                             r7++) {
                                                                                            Layout.card[i7].rotateCard();
                                                                                            count++;
                                                                                            Layout.variation.setText(Long.toString(count));
                                                                                            Layout.put(7, i7);
                                                                                            if (stopRequested) {
                                                                                                break outerloop;
                                                                                            }
                                                                                            ;
                                                                                            if (!Layout.card[i4].getCard(5).equals(Layout.card[i7].getCard(0))) {
                                                                                                continue;
                                                                                            }
                                                                                            if (!Layout.card[i4].getCard(4).equals(Layout.card[i7].getCard(1))) {
                                                                                                continue;
                                                                                            }
                                                                                            for (int i8 = 1; i8 <= 9;
                                                                                                 i8++) {
                                                                                                if (i1 == i8 ||
                                                                                                    i2 == i8 ||
                                                                                                    i3 == i8 ||
                                                                                                    i4 == i8 ||
                                                                                                    i5 == i8 ||
                                                                                                    i6 == i8 ||
                                                                                                    i7 == i8) {
                                                                                                    continue;
                                                                                                }
                                                                                                ;

                                                                                                for (int f8 = 1;
                                                                                                     f8 <= 2; f8++) {
                                                                                                    Layout.card[i8].flipCard();
                                                                                                    for (int r8 = 1;
                                                                                                         r8 <= 4;
                                                                                                         r8++) {
                                                                                                        Layout.card[i8].rotateCard();
                                                                                                        count++;
                                                                                                        Layout.variation.setText(Long.toString(count));
                                                                                                        Layout.put(8,
                                                                                                                   i8);
                                                                                                        if (stopRequested) {
                                                                                                            break outerloop;
                                                                                                        }
                                                                                                        ;
                                                                                                        if (!Layout.card[i7].getCard(2).equals(Layout.card[i8].getCard(7))) {
                                                                                                            continue;
                                                                                                        }
                                                                                                        if (!Layout.card[i7].getCard(3).equals(Layout.card[i8].getCard(6))) {
                                                                                                            continue;
                                                                                                        }
                                                                                                        if (!Layout.card[i5].getCard(5).equals(Layout.card[i8].getCard(0))) {
                                                                                                            continue;
                                                                                                        }
                                                                                                        if (!Layout.card[i5].getCard(4).equals(Layout.card[i8].getCard(1))) {
                                                                                                            continue;
                                                                                                        }
                                                                                                        for (int i9 = 1;
                                                                                                             i9 <= 9;
                                                                                                             i9++) {
                                                                                                            if (i1 ==
                                                                                                                i9 ||
                                                                                                                i2 ==
                                                                                                                i9 ||
                                                                                                                i3 ==
                                                                                                                i9 ||
                                                                                                                i4 ==
                                                                                                                i9 ||
                                                                                                                i5 ==
                                                                                                                i9 ||
                                                                                                                i6 ==
                                                                                                                i9 ||
                                                                                                                i7 ==
                                                                                                                i9 ||
                                                                                                                i8 ==
                                                                                                                i9) {
                                                                                                                continue;
                                                                                                            }
                                                                                                            ;
                                                                                                            for (int f9 =
                                                                                                                 1;
                                                                                                                 f9 <=
                                                                                                                 2;
                                                                                                                 f9++) {
                                                                                                                Layout.card[i9].flipCard();
                                                                                                                for (int r9 =
                                                                                                                     1;
                                                                                                                     r9 <=
                                                                                                                     4;
                                                                                                                     r9++) {
                                                                                                                    Layout.card[i9].rotateCard();
                                                                                                                    count++;
                                                                                                                    Layout.variation.setText(Long.toString(count));
                                                                                                                    Layout.put(9,
                                                                                                                               i9);

                                                                                                                    if (stopRequested) {
                                                                                                                        break outerloop;
                                                                                                                    }
                                                                                                                    ;

                                                                                                                    if (!Layout.card[i8].getCard(2).equals(Layout.card[i9].getCard(7))) {
                                                                                                                        continue;
                                                                                                                    }
                                                                                                                    if (!Layout.card[i8].getCard(3).equals(Layout.card[i9].getCard(6))) {
                                                                                                                        continue;
                                                                                                                    }

                                                                                                                    if (!Layout.card[i6].getCard(5).equals(Layout.card[i9].getCard(0))) {
                                                                                                                        continue;
                                                                                                                    }
                                                                                                                    if (!Layout.card[i6].getCard(4).equals(Layout.card[i9].getCard(1))) {
                                                                                                                        continue;
                                                                                                                    }

                                                                                                                    t.delete();
                                                                                                                    t.add(Layout.card[i1].returnCard());
                                                                                                                    t.add(Layout.card[i2].returnCard());
                                                                                                                    t.add(Layout.card[i3].returnCard());
                                                                                                                    t.add(Layout.card[i4].returnCard());
                                                                                                                    t.add(Layout.card[i5].returnCard());
                                                                                                                    t.add(Layout.card[i6].returnCard());
                                                                                                                    t.add(Layout.card[i7].returnCard());
                                                                                                                    t.add(Layout.card[i8].returnCard());
                                                                                                                    t.add(Layout.card[i9].returnCard());
                                                                                                                    t.print();

                                                                                                                    Layout.southLabel.setText("Solve READY!");
                                                                                                                    Layout.button1.setEnabled(false);
                                                                                                                    Layout.button2.setEnabled(false);
                                                                                                                    Layout.button3.setEnabled(true);

                                                                                                                    break outerloop;


                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }

                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


    }

    public static void requestStop() {
        stopRequested = true;
    }

    public static void requestStart() {
        stopRequested = false;
    }

}

