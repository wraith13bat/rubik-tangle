package tangle;

/*
 * Graphical display
 *
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.util.Hashtable;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;


public class Layout extends JFrame {

    protected static long startTime = 0;
    protected long stopTime = 0;

    protected static JTabbedPane tabbedPane;
    private JPanel borderPanel;
    private JPanel titlePanel;
    private JPanel gridPanel;
    private JPanel gridPanel2;
    private JPanel tanglePanel;

    protected static JLabel[] img = new JLabel[10];
    protected static JButton button1 = new JButton("Start");
    protected static JButton button2 = new JButton("Stop");
    protected static JButton button3 = new JButton("Shuffle");
    protected static JLabel stopperLabel = new JLabel("Time:");
    protected static JLabel stopper = new JLabel("00:00:00");
    protected static JLabel variationLabel = new JLabel("Variation: ");
    protected static JLabel variation = new JLabel("0");
    //protected static JLabel usage = new JLabel("Usage:");
    protected static JLabel usage = new JLabel("Usage:");
    protected static JLabel usageDesc = new JLabel("<html>left click: rotate<br/>right click: flip<br/> drag and drop: swap</html>");

    protected static Hashtable<String, ImageIcon> icon = new Hashtable<String, ImageIcon>();

    protected static Image tangleIcon;

    protected transient Thread search;

    protected static JLabel southLabel;

    protected static Card[] card;

    protected static int[] order;

    protected static int[] cardOrder;

    protected int from = 0;
    protected int to = 0;


    public Layout() {

        super("Rubik Tangle 1.0");

        order = new int[9];
        cardOrder = new int[10];

        card = new Card[10];
        for (int i = 1; i <= 9; i++) {
            card[i] = new Card();
        }

        tangleIcon = new ImageIcon(getClass().getResource("images/rubik_tangle_icon.jpg")).getImage();

        icon.put("EMPTY", new ImageIcon(getClass().getResource("images/EMPTY.PNG")));
        icon.put("KPSKPZSZ", new ImageIcon(getClass().getResource("images/KPSKPZSZ.PNG")));
        icon.put("KPSPZKSZ", new ImageIcon(getClass().getResource("images/KPSPZKSZ.PNG")));
        icon.put("KPSZKSZP", new ImageIcon(getClass().getResource("images/KPSZKSZP.PNG")));
        icon.put("KPZKPSZS", new ImageIcon(getClass().getResource("images/KPZKPSZS.PNG")));
        icon.put("KPZPSKZS", new ImageIcon(getClass().getResource("images/KPZPSKZS.PNG")));
        icon.put("KPZSKSPZ", new ImageIcon(getClass().getResource("images/KPZSKSPZ.PNG")));
        icon.put("KSPSZKPZ", new ImageIcon(getClass().getResource("images/KSPSZKPZ.PNG")));
        icon.put("KSPZKPZS", new ImageIcon(getClass().getResource("images/KSPZKPZS.PNG")));
        icon.put("KSPZKZSP", new ImageIcon(getClass().getResource("images/KSPZKZSP.PNG")));
        icon.put("KSZPKPSZ", new ImageIcon(getClass().getResource("images/KSZPKPSZ.PNG")));
        icon.put("KSZPKZPS", new ImageIcon(getClass().getResource("images/KSZPKZPS.PNG")));
        icon.put("KSZSPKZP", new ImageIcon(getClass().getResource("images/KSZSPKZP.PNG")));
        icon.put("KZPKZSPS", new ImageIcon(getClass().getResource("images/KZPKZSPS.PNG")));
        icon.put("KZPSKSZP", new ImageIcon(getClass().getResource("images/KZPSKSZP.PNG")));
        icon.put("KZPZSKPS", new ImageIcon(getClass().getResource("images/KZPZSKPS.PNG")));
        icon.put("KZSKZPSP", new ImageIcon(getClass().getResource("images/KZSKZPSP.PNG")));
        icon.put("KZSPKSPZ", new ImageIcon(getClass().getResource("images/KZSPKSPZ.PNG")));
        icon.put("KZSZPKSP", new ImageIcon(getClass().getResource("images/KZSZPKSP.PNG")));
        icon.put("PKSKZPSZ", new ImageIcon(getClass().getResource("images/PKSKZPSZ.PNG")));
        icon.put("PKSPKZSZ", new ImageIcon(getClass().getResource("images/PKSPKZSZ.PNG")));
        icon.put("PKSZPSZK", new ImageIcon(getClass().getResource("images/PKSZPSZK.PNG")));
        icon.put("PKZKSPZS", new ImageIcon(getClass().getResource("images/PKZKSPZS.PNG")));
        icon.put("PKZPKSZS", new ImageIcon(getClass().getResource("images/PKZPKSZS.PNG")));
        icon.put("PKZSPSKZ", new ImageIcon(getClass().getResource("images/PKZSPSKZ.PNG")));
        icon.put("PSKSZPKZ", new ImageIcon(getClass().getResource("images/PSKSZPKZ.PNG")));
        icon.put("PSKZPKZS", new ImageIcon(getClass().getResource("images/PSKZPKZS.PNG")));
        icon.put("PSKZPZSK", new ImageIcon(getClass().getResource("images/PSKZPZSK.PNG")));
        icon.put("PSZKPKSZ", new ImageIcon(getClass().getResource("images/PSZKPKSZ.PNG")));
        icon.put("PSZKPZKS", new ImageIcon(getClass().getResource("images/PSZKPZKS.PNG")));
        icon.put("PSZSKPZK", new ImageIcon(getClass().getResource("images/PSZSKPZK.PNG")));
        icon.put("PZKPZSKS", new ImageIcon(getClass().getResource("images/PZKPZSKS.PNG")));
        icon.put("PZKSPSZK", new ImageIcon(getClass().getResource("images/PZKSPSZK.PNG")));
        icon.put("PZKZSPKS", new ImageIcon(getClass().getResource("images/PZKZSPKS.PNG")));
        icon.put("PZSKPSKZ", new ImageIcon(getClass().getResource("images/PZSKPSKZ.PNG")));
        icon.put("PZSPZKSK", new ImageIcon(getClass().getResource("images/PZSPZKSK.PNG")));
        icon.put("PZSZKPSK", new ImageIcon(getClass().getResource("images/PZSZKPSK.PNG")));
        icon.put("SKPSKZPZ", new ImageIcon(getClass().getResource("images/SKPSKZPZ.PNG")));
        icon.put("SKPZSPZK", new ImageIcon(getClass().getResource("images/SKPZSPZK.PNG")));
        icon.put("SKPZSZKP", new ImageIcon(getClass().getResource("images/SKPZSZKP.PNG")));
        icon.put("SKZPSPKZ", new ImageIcon(getClass().getResource("images/SKZPSPKZ.PNG")));
        icon.put("SKZPSZPK", new ImageIcon(getClass().getResource("images/SKZPSZPK.PNG")));
        icon.put("SKZSKPZP", new ImageIcon(getClass().getResource("images/SKZSKPZP.PNG")));
        icon.put("SPKSPZKZ", new ImageIcon(getClass().getResource("images/SPKSPZKZ.PNG")));
        icon.put("SPZKSKPZ", new ImageIcon(getClass().getResource("images/SPZKSKPZ.PNG")));
        icon.put("SPKZSKZP", new ImageIcon(getClass().getResource("images/SPKZSKZP.PNG")));
        icon.put("SPKZSZPK", new ImageIcon(getClass().getResource("images/SPKZSZPK.PNG")));
        icon.put("SPZKSZKP", new ImageIcon(getClass().getResource("images/SPZKSZKP.PNG")));
        icon.put("SPZSPKZK", new ImageIcon(getClass().getResource("images/SPZSPKZK.PNG")));
        icon.put("SZKPSKPZ", new ImageIcon(getClass().getResource("images/SZKPSKPZ.PNG")));
        icon.put("SZKPSPZK", new ImageIcon(getClass().getResource("images/SZKPSPZK.PNG")));
        icon.put("SZKSZPKP", new ImageIcon(getClass().getResource("images/SZKSZPKP.PNG")));
        icon.put("SZPKSKZP", new ImageIcon(getClass().getResource("images/SZPKSKZP.PNG")));
        icon.put("SZPKSPKZ", new ImageIcon(getClass().getResource("images/SZPKSPKZ.PNG")));
        icon.put("SZPSZKPK", new ImageIcon(getClass().getResource("images/SZPSZKPK.PNG")));
        icon.put("ZKPKSZPS", new ImageIcon(getClass().getResource("images/ZKPKSZPS.PNG")));
        icon.put("ZKPSZSKP", new ImageIcon(getClass().getResource("images/ZKPSZSKP.PNG")));
        icon.put("ZKPZKSPS", new ImageIcon(getClass().getResource("images/ZKPZKSPS.PNG")));
        icon.put("ZKSKPZSP", new ImageIcon(getClass().getResource("images/ZKSKPZSP.PNG")));
        icon.put("ZKSPZSPK", new ImageIcon(getClass().getResource("images/ZKSPZSPK.PNG")));
        icon.put("ZKSZKPSP", new ImageIcon(getClass().getResource("images/ZKSZKPSP.PNG")));
        icon.put("ZPKPSZKS", new ImageIcon(getClass().getResource("images/ZPKPSZKS.PNG")));
        icon.put("ZPKSZSPK", new ImageIcon(getClass().getResource("images/ZPKSZSPK.PNG")));
        icon.put("ZPKZPSKS", new ImageIcon(getClass().getResource("images/ZPKZPSKS.PNG")));
        icon.put("ZPSKZSKP", new ImageIcon(getClass().getResource("images/ZPSKZSKP.PNG")));
        icon.put("ZPSPKZSK", new ImageIcon(getClass().getResource("images/ZPSPKZSK.PNG")));
        icon.put("ZPSZPKSK", new ImageIcon(getClass().getResource("images/ZPSZPKSK.PNG")));
        icon.put("ZSKPZKPS", new ImageIcon(getClass().getResource("images/ZSKPZKPS.PNG")));
        icon.put("ZSKPZPSK", new ImageIcon(getClass().getResource("images/ZSKPZPSK.PNG")));
        icon.put("ZSKSPZKP", new ImageIcon(getClass().getResource("images/ZSKSPZKP.PNG")));
        icon.put("ZSPKZKSP", new ImageIcon(getClass().getResource("images/ZSPKZKSP.PNG")));
        icon.put("ZSPKZPKS", new ImageIcon(getClass().getResource("images/ZSPKZPKS.PNG")));
        icon.put("ZSPSKZPK", new ImageIcon(getClass().getResource("images/ZSPSKZPK.PNG")));

        for (int i = 1; i <= 9; i++) {
            img[i] = new JLabel();
        }

        shuffle();

        stopper.setToolTipText("minute:second:millisecond");
        stopperLabel.setToolTipText("minute:second:millisecond");

        //this.setSize(600,540);
        this.setBounds(10, 10, 600, 540);
        this.setResizable(false);
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        borderPanel = new JPanel();
        gridPanel = new JPanel();
        gridPanel2 = new JPanel();
        titlePanel = new JPanel();
        tanglePanel = new JPanel();

        final ImageIcon tangleImage = new ImageIcon(getClass().getResource("images/tangle.png"));
        JLabel tangleLabel = new JLabel(tangleImage, JLabel.CENTER);

        this.getContentPane().add(tabbedPane);
        tabbedPane.addTab("Description", titlePanel);
        tabbedPane.addTab("GridLayout", gridPanel);
        tabbedPane.addTab("Tangle", tanglePanel);

        borderPanel.setLayout(new BorderLayout());
        gridPanel.setLayout(new GridLayout(3, 3)); // 3 rows, 3 cols
        GridLayout grid2 = new GridLayout(5, 2, 10, 20); // 5 rows, 2 cols with spacing
        gridPanel2.setLayout(grid2);

        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        tanglePanel.setLayout(new BorderLayout());

        // adding componenets to show the layouts
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        northPanel.add(new JLabel("<html><br><br></html>"));
        southLabel = new JLabel("Shuffled state");
        southPanel.add(southLabel);

        centerPanel.add(gridPanel);
        centerPanel.add(gridPanel2);
        southPanel.setBackground(Color.WHITE);

        borderPanel.add(northPanel, BorderLayout.NORTH);
        borderPanel.add(southPanel, BorderLayout.SOUTH);
        borderPanel.add(eastPanel, BorderLayout.EAST);
        borderPanel.add(westPanel, BorderLayout.WEST);
        borderPanel.add(centerPanel, BorderLayout.CENTER);

        tanglePanel.add(northPanel, BorderLayout.NORTH);
        tanglePanel.add(southPanel, BorderLayout.SOUTH);
        tanglePanel.add(eastPanel, BorderLayout.EAST);
        tanglePanel.add(centerPanel, BorderLayout.CENTER);


        for (int i = 1; i <= 9; i++) {
            Action(i);
        }


        for (int i = 1; i <= 9; i++) {
            gridPanel.add(img[i]);
        }

        titlePanel.add(new JLabel("<html><big>Rubik Tangle</big><hr><html>"));
        titlePanel.add(new JLabel("<html><p style='font-size:9px;'>The Rubik's Tangle is a logic game consisting of 9 small cardboard tiles. <br/>" +
                                  "These cardboard tiles (the more modern ones are made of plastic) are double-sided, <br/>" +
                                  "so we have a total of 18 figures. <br/>" +
                                  "Each figure shows 4 threads of different colors, <br/>" +
                                  "which are entangled with each other. <br/>" +
                                  "Each figure looks the same, except that the colors of the threads are different. <br/>" +
                                  "The goal of the game is to place these nine cardboard tiles <br/>" +
                                  "in such a way that the colors of the threads are continuous, <br/> and the whole forms a 3x3 square. <br/>" +
                                  "The cards can be placed in a total of 95,126,813,710 ways.<br/><br/>" +
                                  " <p align='right'>Created by Attila Boros</p>" + "</p></html>"));

        titlePanel.add(tangleLabel);

        JButton buttonNext = new JButton("Next");
        buttonNext.setToolTipText("Start solve");
        titlePanel.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(1);
            }
        });

        titlePanel.add(new JLabel("          "));
        JButton buttonExit = new JButton("Exit");
        buttonExit.setToolTipText("Exit");
        titlePanel.add(buttonExit);

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        eastPanel.add(gridPanel2);
        button1.setToolTipText("Start solving");
        gridPanel2.add(button1);

        button2.setToolTipText("Stop solving");
        gridPanel2.add(button2);
        button2.setEnabled(false);

        gridPanel2.add(stopperLabel);
        gridPanel2.add(stopper);
        gridPanel2.add(variationLabel);
        gridPanel2.add(variation);

        button3.setToolTipText("Shuffle cards");
        gridPanel2.add(button3);

        gridPanel2.add(new JLabel(""));
        gridPanel2.add(usage);
        gridPanel2.add(usageDesc);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startTime = System.currentTimeMillis();
                southLabel.setText("Solve in progress, wait...");
                button1.setEnabled(false);
                button2.setEnabled(true);
                button3.setEnabled(false);
                Solve.requestStart();
                search = new Thread(new Solve());
                search.start();
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Solve.requestStop();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e2) {
                    //
                }
                southLabel.setText("Solve stopped");
                button1.setEnabled(true);
                button2.setEnabled(false);
                button3.setEnabled(true);
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shuffle();
                southLabel.setText("Shuffled state");
                Layout.button1.setEnabled(true);
            }
        });


    }


    public static void delete() {
        for (int i = 1; i <= 9; i++) {
            img[i].setIcon(icon.get("EMPTY"));
        }
    }


    public static void put(int place, int cardIndex) {
        cardOrder[place] = cardIndex;
        //kartyaSorrend[ki] = hely;
        img[place].setIcon(icon.get(card[cardIndex].printCard()));
        long elapsed = System.currentTimeMillis() - startTime;
        long millisec = (elapsed / 10) % 100;
        long second = (elapsed / 1000) % 60;
        long minute = (elapsed / (1000 * 60)) % 60;
        //long hour = (eltelt / (1000 * 60 * 60)) % 24;
        String time = String.format("%02d:%02d:%02d", minute, second, millisec);

        stopper.setText(time);
        //tabbedPane.paintImmediately(50, 50, 350, 500);
        //tabbedPane.paintImmediately(50, 50, 550, 500);

        //try {
        //    Thread.sleep(1);
        //} catch (InterruptedException e) {
        //}
    }


    public static void main(String[] args) {
        Layout frame = new Layout();

        frame.setVisible(true);


        frame.setIconImage(tangleIcon);
        // this is an implementation of window listener
        // the program will be stopped if you close the main frame
        WindowListener listener = new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        };
        frame.addWindowListener(listener);
    }


    public static int[] RandomizeArray(int a, int b) {
        Random rgen = new Random(); // Random number generator
        int size = b - a + 1;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = a + i;
        }

        for (int i = 0; i < array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }

    public static void shuffle() {
        order = RandomizeArray(1, 9);
        card[order[1]].setCardFront("K", "Z", "P", "Z", "S", "K", "P", "S");
        card[order[1]].setCardBack("K", "S", "P", "S", "Z", "K", "P", "Z");
        card[order[2]].setCardFront("K", "S", "Z", "S", "P", "K", "Z", "P");
        card[order[2]].setCardBack("K", "P", "S", "P", "Z", "K", "S", "Z");
        card[order[3]].setCardFront("K", "P", "Z", "P", "S", "K", "Z", "S");
        card[order[3]].setCardBack("K", "Z", "S", "Z", "P", "K", "S", "P");

        card[order[4]].setCardFront("Z", "P", "K", "P", "S", "Z", "K", "S");
        card[order[4]].setCardBack("Z", "K", "S", "K", "P", "Z", "S", "P");
        card[order[5]].setCardFront("Z", "K", "P", "K", "S", "Z", "P", "S");
        card[order[5]].setCardBack("Z", "S", "K", "S", "P", "Z", "K", "P");
        card[order[6]].setCardFront("Z", "S", "P", "S", "K", "Z", "P", "K");
        card[order[6]].setCardBack("Z", "P", "S", "P", "K", "Z", "S", "K");

        card[order[7]].setCardFront("P", "Z", "K", "Z", "S", "P", "K", "S");
        card[order[7]].setCardBack("P", "K", "Z", "K", "S", "P", "Z", "S");
        card[order[8]].setCardFront("P", "Z", "S", "Z", "K", "P", "S", "K");
        card[order[8]].setCardBack("P", "S", "K", "S", "Z", "P", "K", "Z");
        card[order[0]].setCardFront("P", "K", "S", "K", "Z", "P", "S", "Z");
        card[order[0]].setCardBack("P", "S", "Z", "S", "K", "P", "Z", "K");


        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= (int) (Math.random() * 2 + 1); j++) {
                card[i].flipCard();
                for (int l = 1; l <= (int) (Math.random() * 4 + 1); l++) {
                    card[i].rotateCard();
                }
            }
        }


        for (int i = 1; i <= 9; i++) {
            put(i, i);
        }

        stopper.setText("00:00:00");

    }


    public void Action(int ii) {
        final int i = ii;
        img[i].addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    card[cardOrder[i]].rotateCard();
                    put(i, cardOrder[i]);
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    card[cardOrder[i]].flipCard();
                    put(i, cardOrder[i]);
                }
                stopper.setText("00:00:00");
                button1.setEnabled(true);
                southLabel.setText("Shuffled state");
            }
            //@Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    //System.out.println("Egér gomb lenyomva:" + i);
                    from = i;
                }

            }
            //@Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    PointerInfo a = MouseInfo.getPointerInfo();
                    Point point = new Point(a.getLocation());
                    SwingUtilities.convertPointFromScreen(point, gridPanel);
                    int x = (int) point.getX();
                    int y = (int) point.getY();
                    if (x < 0) {
                        x = 0;
                    }
                    ;
                    if (y < 0) {
                        y = 0;
                    }
                    ;
                    if (x >= 300) {
                        x = 299;
                    }
                    ;
                    if (y >= 300) {
                        y = 299;
                    }
                    ;
                    //System.out.println("X:"+x+",Y:"+y);
                    int to = (y / 100) * 3 + (x / 100 + 1);
                    //System.out.println("Egér gomb felengedve: " + hova);
                    //System.out.println("honnan="+honnan+" hova="+hova);
                    int tmp = cardOrder[from];
                    ImageIcon tmp2 = icon.get(card[cardOrder[from]].printCard());
                    cardOrder[from] = cardOrder[to];
                    img[from].setIcon(icon.get(card[cardOrder[to]].printCard()));
                    cardOrder[to] = tmp;
                    img[to].setIcon(tmp2);
                    /*
                ImageIcon tmp2 = ikon.get(k[honnan].printKartya());
                img[honnan].setIcon(ikon.get(k[hova].printKartya()));
                img[hova].setIcon(tmp2);
                */
                    /*
                System.out.print("Kartyasorrend: ");
                for (int i=1;i<10;i++) {
                    System.out.print(kartyaSorrend[i]);
                }
                System.out.println("");
                */
                    stopper.setText("00:00:00");
                    button1.setEnabled(true);
                    southLabel.setText("Shuffled state");


                }

            }
            //@Override
            public void mouseEntered(MouseEvent e) {
            }
            //@Override
            public void mouseExited(MouseEvent e) {
            }
        });

    }


}


