package gameTubes;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
/**
* <h1>Game</h1>
* A subclass of JPanel,
* defining game's GUI behavior.
*/
public class Game extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static Image GameBg;
    public static Image guppyIcon1;
    public static Image guppyIcon2;
    public static Image guppyIcon3;
    public static Image hungryGuppyIcon;
    public static Image piranhaIcon;
    public static Image hungryPiranhaIcon;
    public static Image pelletIcon;
    public static Image goldIcon;
    public static Image silverIcon;
    public static Image bronzeIcon;
    public static Image snailIcon;
    /**
     * Constructor to load the assets to be used in game.
     */
    Game() {
        GameBg = Toolkit.getDefaultToolkit().createImage("Game.jpg");
        guppyIcon1 = Toolkit.getDefaultToolkit().createImage("Guppy1.png");
        guppyIcon2 = Toolkit.getDefaultToolkit().createImage("Guppy2.png");
        guppyIcon3 = Toolkit.getDefaultToolkit().createImage("Guppy3.png");
        piranhaIcon = Toolkit.getDefaultToolkit().createImage("Piranha.png");
        pelletIcon = Toolkit.getDefaultToolkit().createImage("Pellet.png");
        goldIcon = Toolkit.getDefaultToolkit().createImage("Gold.png");
        silverIcon = Toolkit.getDefaultToolkit().createImage("Silver.png");
        bronzeIcon = Toolkit.getDefaultToolkit().createImage("Bronze.png");
        snailIcon = Toolkit.getDefaultToolkit().createImage("Snail.png");
        hungryGuppyIcon = Toolkit.getDefaultToolkit()
                .createImage("HungryGuppy.png");
        hungryPiranhaIcon = Toolkit.getDefaultToolkit()
                .createImage("HungryPiranha.png");

    }
    /**
     * Draw assets into the game panel.
     * @param g Tool to draw.
     */
    @Override
    protected void paintComponent(Graphics g) {
        int X;
        int Y;
        int offsetX;
        int offsetY;
        Image I = null;
        BufferedImage B;
        ElmtLList<Creature> Pc = Main.A.getCreatures().getFirst();
        ElmtLList<Item> Pi = Main.A.getItems().getFirst();

        super.paintComponent(g);
        g.drawImage(GameBg, 0, 0, getWidth(), getHeight(), this);

        while (Pc != null) {
            if (Pc.getData() instanceof Guppy) {
                Guppy G = (Guppy) Pc.getData();
                if (G.getHunger() > 500) {
                    I = hungryGuppyIcon;
                } else {
                    if (G.getStage() == 1) {
                        I = guppyIcon1;
                    } else if (G.getStage() == 2) {
                        I = guppyIcon2;
                    } else {
                        I = guppyIcon3;
                    }
                }
            } else if (Pc.getData() instanceof Piranha) {
                Piranha P = (Piranha) Pc.getData();
                if (P.getHunger() > 500) {
                    I = hungryPiranhaIcon;
                } else {
                    I = piranhaIcon;
                }
            } else if (Pc.getData() instanceof Snail) {
                I = snailIcon;
            }
            X = Pc.getData().getX();
            Y = Pc.getData().getY();
            B = toBufferedImage(I);
            offsetX = B.getWidth(null) / 2;
            offsetY = B.getHeight(null) / 2;
            if (Pc.getData().getDirection() == 1) {
                BufferedImage BFlipped = horizontalFlip(B);
                offsetX = B.getWidth(null) / 2;
                offsetY = B.getHeight(null) / 2;
                Graphics2D g2d1 = (Graphics2D) g.create();
                g2d1.drawImage(BFlipped, Math.abs(X - offsetX),
                        Math.abs(Y - offsetY), this);
                g2d1.dispose();

            } else {
                Graphics2D g2d1 = (Graphics2D) g.create();
                g2d1.drawImage(B, Math.abs(X - offsetX), Math.abs(Y - offsetY),
                        this);
                g2d1.dispose();
            }
            Pc = Pc.getNext();
        }

        while (Pi != null) {
            if (Pi.getData() instanceof Pellet) {
                I = pelletIcon;
            } else if (Pi.getData() instanceof Coin) {
                Coin C = (Coin) Pi.getData();
                if (C.getValue() == Main.goldValue) {
                    I = goldIcon;
                } else if (C.getValue() == Main.silverValue) {
                    I = silverIcon;
                } else {
                    I = bronzeIcon;
                }
            }
            X = Pi.getData().getX();
            Y = Pi.getData().getY();
            offsetX = I.getWidth(null) / 2;
            offsetY = I.getHeight(null) / 2;
            B = toBufferedImage(I);
            Graphics2D g2d1 = (Graphics2D) g.create();
            g2d1.drawImage(B, Math.abs(X - offsetX), Math.abs(Y - offsetY),
                    this);
            g2d1.dispose();
            Pi = Pi.getNext();
        }
    }
    /**
     * Flip a buffered image.
     * @param img The BufferedImage to be flipped.
     * @return BufferedImage This returns the flipped image.
     */
    public static BufferedImage horizontalFlip(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage flippedImage = new BufferedImage(w, h, img.getType());
        Graphics2D g = flippedImage.createGraphics();
        g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);
        g.dispose();
        return flippedImage;
    }
    /**
     * Convert Image object to BufferedImage.
     * @param img Image to be converted.
     * @return BufferedImage This returns the converted image.
     */
    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        BufferedImage bimage = new BufferedImage(Math.abs(img.getWidth(null)),
                Math.abs(img.getHeight(null)), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        return bimage;
    }
}
