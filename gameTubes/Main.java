package gameTubes;
import javax.swing.*;
import java.lang.Math;
import java.awt.*;
import java.awt.event.*;
/**
* <h1>Main</h1>
* Main class that implements the game.
*/
public class Main extends JFrame implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final int screenWidth = 1280;
    public static final int screenHeight = 720;
    public static Aquarium A;
    public static Snail S;
    public static int guppyPrice = 100;
    public static int piranhaPrice = 200;
    public static int money;
    public static int eggPrice = 500;
    public static int pelletPrice = 10;
    public static int goldValue = 80;
    public static int silverValue = 40;
    public static int bronzeValue = 20;
    public static int eggCount;
    private JButton play = new JButton("Play");
    private JButton exit = new JButton("Exit");
    private JButton mainMenu = new JButton("Main Menu");
    private JButton buyGuppy = new JButton("Guppy : " + guppyPrice);
    private JButton buyPiranha = new JButton("Piranha : " + piranhaPrice);
    private JButton buyEgg = new JButton("Egg : " + eggPrice);
    private JLabel displayMoney = new JLabel("Money : " + money);
    private JLabel displayEgg = new JLabel("Egg(s) : " + eggCount);

    private CardLayout layout = new CardLayout();

    private JPanel panel = new JPanel();
    private Game game = new Game();
    private JLabel menu = new JLabel(new ImageIcon(
            new ImageIcon("MainMenu.png").getImage().getScaledInstance(
                    screenWidth, screenHeight, Image.SCALE_DEFAULT)));
    /**
     * Reset the component of the game.
     */
    public void reset() {
        A = new Aquarium();
        S = new Snail(randInt(screenWidth / 4, 3 * screenWidth / 4), 655, 1);
        A.insertCreature(S);
        eggCount = 0;
        money = 1000;
    }
    /**
     * Constructor to create the game window and panel.
     * @param width The desired game window's width in pixel.
     * @param height The desired game window's height in pixel.
     */
    public Main(int width, int height) {

        panel.setLayout(layout);
        addButtons();
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("ArkavQuarium");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        requestFocus();

        reset();

        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int piranhaCount = 0;
                int guppyCount = 0;
                int coinCount = 0;
                Component current = null;
                for (Component comp : panel.getComponents()) {
                    if (comp.isVisible() == true) {
                        current = comp;
                    }
                }
                if (current.getName().equals("Game")) {
                    ElmtLList<Creature> Pc = A.getCreatures().getFirst();
                    while (Pc != null) {
                        if (Pc.getData() instanceof Guppy) {
                            guppyCount++;
                        } else if (Pc.getData() instanceof Piranha) {
                            piranhaCount++;
                        }
                        Pc.getData().move(A);
                        Pc.getData().eat(A);
                        Pc = Pc.getNext();
                    }
                    ElmtLList<Item> Pi = A.getItems().getFirst();
                    while (Pi != null) {
                        if (Pi.getData() instanceof Coin) {
                            coinCount++;
                        }
                        Pi.getData().move(A);
                        Pi = Pi.getNext();
                    }
                    displayEgg.setText("Egg(s) : " + eggCount);
                    displayMoney.setText("Money : " + money);
                    if (eggCount == 3) {
                        JOptionPane.showMessageDialog(null, "You Won!",
                                "Congratulation!",
                                JOptionPane.INFORMATION_MESSAGE,
                                new ImageIcon("Win.gif"));
                        reset();
                        layout.show(panel, "Menu");
                    } else {
                        if (coinCount == 0 && guppyCount == 0
                                && piranhaCount == 0 && money < guppyPrice) {
                            JOptionPane.showMessageDialog(null, "You Lost!",
                                    "Game Over!",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    new ImageIcon("Lose.gif"));
                            reset();
                            layout.show(panel, "Menu");
                        }
                    }
                    game.repaint();
                }
            }
        });
        timer.start();
    }
    private class MyMouseListener extends MouseAdapter {
        /**
         * Action listener for mouse actions by the player.
         * @param e Mouse action event.
         */
        @Override
        public void mousePressed(MouseEvent e) {
            int Xrange, Yrange;
            int Xicon = Game.goldIcon.getWidth(null) / 2;
            int Yicon = Game.goldIcon.getHeight(null) / 2;
            boolean f = false;
            ElmtLList<Item> Pi = A.getItems().getFirst();
            Coin I = new Coin(e.getX(), e.getY(), 1);
            while (Pi != null) {
                Xrange = Math.abs(I.getX() - Pi.getData().getX());
                Yrange = Math.abs(I.getY() - Pi.getData().getY());
                if (Pi.getData() instanceof Coin && Xrange <= Xicon
                        && Yrange <= Yicon) {
                    A.delItem(Pi.getData());
                    Coin C = (Coin) Pi.getData();
                    money += C.getValue();
                    f = true;
                    break;
                }
                Pi = Pi.getNext();
            }
            if (money >= pelletPrice && !f) {
                money -= pelletPrice;
                Pellet P = new Pellet(e.getX(), e.getY());
                A.insertItem(P);
            }
            displayMoney.setText("Money : " + money);
        }
    }
    /**
     * Add all the buttons in the game to the panel.
     */
    private void addButtons() {
        game.setName("Game");
        menu.setName("Menu");
        play.addActionListener(this);
        exit.addActionListener(this);
        mainMenu.addActionListener(this);
        buyGuppy.addActionListener(this);
        buyPiranha.addActionListener(this);
        buyEgg.addActionListener(this);
        // menu buttons
        menu.setLayout(new FlowLayout());
        menu.add(play);
        menu.add(exit);
        game.addMouseListener(new MyMouseListener());
        game.setLayout(new FlowLayout());

        // game buttons
        game.add(mainMenu);
        game.add(buyGuppy);
        game.add(buyPiranha);
        game.add(buyEgg);
        game.add(displayEgg);
        game.add(displayMoney);

        // adding children to parent Panel
        panel.add(menu, "Menu");
        panel.add(game, "Game");
        add(panel);
        layout.show(panel, "Menu");
    }
    /**
     * Action listener for click actions at the buttons.
     * @param event button clicked event.
     */
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == exit) {
            int n = JOptionPane.showConfirmDialog(this,
                    "Do you want to quit the game?", "WARNING",
                    JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (source == play) {
            layout.show(panel, "Game");
        } else if (source == mainMenu) {
            int n = JOptionPane.showConfirmDialog(this,
                    "You're about to quit current game. Proceed?", "WARNING",
                    JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                reset();
                layout.show(panel, "Menu");
            }
        } else if (source == buyGuppy) {
            if (money >= guppyPrice) {
                int Xloc = randInt(screenWidth / 4, 3 * screenWidth / 4);
                int Yloc = randInt(screenHeight / 4, 3 * screenHeight / 4);
                money -= guppyPrice;
                Guppy G = new Guppy(Xloc, Yloc, 1);
                A.insertCreature(G);
                displayMoney.setText("Money : " + money);
            } else {
                JOptionPane.showMessageDialog(this, "Not Enough Money!",
                        "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        } else if (source == buyPiranha) {
            if (money >= piranhaPrice) {
                int Xloc = randInt(screenWidth / 4, 3 * screenWidth / 4);
                int Yloc = randInt(screenHeight / 4, 3 * screenHeight / 4);
                money -= piranhaPrice;
                Piranha P = new Piranha(Xloc, Yloc, 1);
                A.insertCreature(P);
                displayMoney.setText("Money : " + money);
            } else {
                JOptionPane.showMessageDialog(this, "Not Enough Money!",
                        "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }

        else if (source == buyEgg) {
            if (money >= eggPrice) {
                money -= eggPrice;
                eggCount++;
                displayMoney.setText("Money : " + money);
                displayEgg.setText("Egg(s) : " + eggCount);
            } else {
                JOptionPane.showMessageDialog(this, "Not Enough Money!",
                        "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    /**
     * Call Main object constructor, creating the game window and its components.
     * @param args[] Program arguments.
     */
    public static void main(String args[]) {
        @SuppressWarnings("unused")
        Main J = new Main(screenWidth, screenHeight);
    }
    /**
     * Integer randomizer from given range.
     * @param min The lower limit of the range.
     * @param max The upper limit of the range.
     * @return int This returns randomized integer from given range.
     * @throws IllegalArgumentException If max is not greater than min.
     */
    public static int randInt(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
