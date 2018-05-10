package gameTubes;

/**
* <h1>Guppy</h1>
* A subclass of Creature that implements Fish interface,
* defining in-game Guppy fish behavior.
*/
public class Guppy extends Creature implements Fish {
    private int stage;
    private int xrand;
    private int yrand;
    private int hunger;
    private int coinTimer;
    private int growTimer;
    /**
     * Constructor to initialize the inherited attributes.
     * @param x the desired abscissa for the object.
     * @param y the desired ordinate for the object.
     * @param direction the desired direction for the object.
     */
    public Guppy(int x, int y, int direction) {
        super(x, y, direction);
        stage = 1;
        coinTimer = 500;
        growTimer = 150;
        hunger = 0;
        xrand = Main.randInt(0, 1000);
        yrand = Main.randInt(0, 500);
    }
    /**
     * A method describing move behavior of a Guppy.
     * @param a The environment to observe where to move.
     */
    @Override
    public void move(Aquarium a) {
        if (coinTimer == 0) {
            spawnCoin(a);
            coinTimer = 500;
        }
        if (growTimer == 0) {
            grow();
            if (stage == 2) {
                growTimer = 300;
            } else {
                growTimer = 400;
            }
        }
        if (hunger > 1000) {
            death(a);
        }

        boolean found = false;
        ElmtLList<Item> Pi = a.getItems().getFirst();
        while (Pi != null) {
            if (this.hunger < 250) {
                break;
            }
            if (Pi.getData() instanceof Pellet) {
                if (this.x < Pi.getData().getX() - 1) {
                    direction = 1;
                    this.x++;
                    this.x++;
                } else if (this.x > Pi.getData().getX() + 1) {
                    direction = -1;
                    this.x--;
                    this.x--;
                }
                if (this.y < Pi.getData().getY()) {
                    this.y++;
                    this.y++;
                } else {
                    this.y--;
                    this.y--;
                }
                found = true;
                break;
            }
            Pi = Pi.getNext();
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
     * A method describing eat behavior of a Guppy.
     * @param a The environment to observe what to eat.
     */
    @Override
    public void eat(Aquarium a) {
        ElmtLList<Item> P = a.getItems().getFirst();
        while (P != null) {
            if (P.getData() instanceof Pellet) {
                if (P.getData().x - this.x > -5 && P.getData().x - this.x < 5) {
                    if (P.getData().y - this.y > -5
                            && P.getData().y - this.y < 5) {
                        a.delItem(P.getData());
                        this.hunger = 0;
                        growTimer -= 50;
                        break;
                    }
                }
            }
            P = P.getNext();
        }
    }
    /**
     * A method describing grow behavior of a Guppy.
     */
    @Override
    public void grow() {
        if (stage != 3) {
            stage++;
        }
    }
    /**
     * A method describing death behavior of a Guppy.
     * @param a The environment to observe the death.
     */
    @Override
    public void death(Aquarium a) {
        a.getCreatures().remove(this);
    }
    /**
     * A method describing coin spawning behavior of a Guppy.(Game related)
     * @param a The environment to put the coin.
     */
    @Override
    public void spawnCoin(Aquarium a) {
        Coin c;
        if (stage == 1) {
            c = new Coin(x, y, Main.bronzeValue);
        } else if (stage == 2) {
            c = new Coin(x, y, Main.silverValue);
        } else {
            c = new Coin(x, y, Main.goldValue);
        }
        a.insertItem(c);
    }
    /**
     * Getter of object's stage.
     * @return int This returns object's stage.
     */
    public int getStage() {
        return stage;
    }
    /**
     * Getter of object's hunger.
     * @return int This returns object's hunger.
     */
    public int getHunger() {
        return hunger;
    }
    /**
     * Getter of object's coinTimer.
     * @return int This returns object's coinTimer.
     */
    public int getCoinTimer() {
        return coinTimer;
    }
    /**
     * Getter of object's growTimer.
     * @return int This returns object's growTimer.
     */
    public int getGrowTimer() {
        return growTimer;
    }
    /**
     * Setter of object's stage.
     * @param stage The desired stage for the object.
     */
    public void setStage(int stage) {
        this.stage = stage;
    }
    /**
     * Setter of object's hunger.
     * @param hunger The desired hunger for the object.
     */
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
    /**
     * Setter of object's coinTimer.
     * @param coinTimer The desired coinTimer for the object.
     */
    public void setCoinTimer(int coinTimer) {
        this.coinTimer = coinTimer;
    }
    /**
     * Setter of object's growTimer.
     * @param growTimer The desired growTimer for the object.
     */
    public void setGrowTimer(int growTimer) {
        this.growTimer = growTimer;
    }

}
