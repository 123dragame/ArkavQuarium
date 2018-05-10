package gameTubes;

/**
* <h1>Piranha</h1>
* A subclass of Creature that implements Fish interface,
* defining in-game Piranha fish behavior.
*/
public class Piranha extends Creature implements Fish {
    private int xrand;
    private int yrand;
    private int hunger;
    private int coinTimer;
    /**
     * Constructor to initialize the inherited attributes.
     * @param x the desired abscissa for the object.
     * @param y the desired ordinate for the object.
     * @param direction the desired direction for the object.
     */
    public Piranha(int x, int y, int direction) {
        super(x, y, direction);
        xrand = Main.randInt(0, 1000);
        yrand = Main.randInt(0, 500);
        hunger = 0;
        coinTimer = 500;
    }
    /**
     * A method describing move behavior of a Piranha.
     * @param a The environment to observe where to move.
     */
    @Override
    public void move(Aquarium a) {
        if (coinTimer == 0) {
            spawnCoin(a);
            coinTimer = 500;
        }
        if (hunger > 1000) {
            death(a);
        }
        boolean found = false;
        ElmtLList<Creature> Pc = a.getCreatures().getFirst();
        while (Pc != null) {
            if (this.hunger < 250) {
                break;
            }
            if (Pc.getData() instanceof Guppy) {
                if (this.x < Pc.getData().getX() - 1) {
                    direction = 1;
                    this.x++;
                    this.x++;
                } else if (this.x > Pc.getData().getX() + 1) {
                    direction = -1;
                    this.x--;
                    this.x--;
                }
                if (this.y < Pc.getData().getY()) {
                    this.y++;
                    this.y++;
                } else {
                    this.y--;
                    this.y--;
                }
                found = true;
                break;
            }
            Pc = Pc.getNext();
        }
        if (!found) {
            if (this.x > xrand) {
                this.x--;
                direction = -1;
                if (this.y > yrand) {
                    this.y--;
                } else if (this.y < yrand) {
                    this.y++;
                } else {
                    this.xrand = Main.randInt(0, 1000);
                    this.yrand = Main.randInt(0, 700);
                }
            } else if (this.x < xrand) {
                this.x++;
                direction = 1;
                if (this.y > yrand) {
                    this.y--;
                } else if (this.y < yrand) {
                    this.y++;
                } else {
                    this.xrand = Main.randInt(0, 1000);
                    this.yrand = Main.randInt(0, 700);
                }
            } else {
                if (this.y > yrand) {
                    this.y--;
                } else if (this.y < yrand) {
                    this.y++;
                } else {
                    this.xrand = Main.randInt(0, 1000);
                    this.yrand = Main.randInt(0, 700);
                }
            }
        }
        coinTimer -= 1;
        hunger += 1;
    }
    /**
     * A method describing eat behavior of a Piranha.
     * @param a The environment to observe what to eat.
     */
    @Override
    public void eat(Aquarium a) {
        ElmtLList<Creature> P = a.getCreatures().getFirst();
        while (P != null) {
            if (P.getData() instanceof Guppy) {
                if (P.getData().x - this.x > -5 && P.getData().x - this.x < 5) {
                    if (P.getData().y - this.y > -5
                            && P.getData().y - this.y < 5) {
                        a.delCreature(P.getData());
                        this.hunger = 0;
                        spawnCoin(a);
                        break;
                    }
                }
            }
            P = P.getNext();
        }
    }
    /**
     * A method describing grow behavior of a Piranha.
     * Piranha doesn't grow.
     */
    @Override
    public void grow() {
    }
    /**
     * A method describing death behavior of a Piranha.
     * @param a The environment to observe the death.
     */
    @Override
    public void death(Aquarium a) {
        a.getCreatures().remove(this);
    }
    /**
     * A method describing coin spawning behavior of a Piranha.(Game related)
     * @param a The environment to put the coin.
     */
    @Override
    public void spawnCoin(Aquarium a) {
        Coin c = new Coin(x, y, Main.goldValue);
        a.insertItem(c);
    }
    /**
     * Getter of object's hunger.
     * @return int This returns object's hunger.
     */
    public int getHunger() {
        return hunger;
    }
    /**
     * Setter of object's hunger.
     * @param hunger The desired hunger for the object.
     */
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
}
