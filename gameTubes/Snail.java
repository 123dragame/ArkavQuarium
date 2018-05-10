package gameTubes;
/**
* <h1>Snail</h1>
* A subclass of Creature,
* defining in-game snail behavior.
*/
public class Snail extends Creature {
    /**
     * Constructor to initialize the inherited attributes.
     * @param x the desired abscissa for the object.
     * @param y the desired ordinate for the object.
     * @param direction the desired direction for the object.
     */
    public Snail(int x, int y, int direction) {
        super(x, y, direction);
    }
    /**
     * A method describing eat behavior of a Snail.
     * @param a The environment to observe what to eat.
     */
    @Override
    public void eat(Aquarium a) {
        ElmtLList<Item> P = a.getItems().getFirst();
        while (P != null) {
            if (P.getData() instanceof Coin) {
                if (P.getData().x - this.x > -5 && P.getData().x - this.x < 5) {
                    if (P.getData().y - this.y > -5
                            && P.getData().y - this.y < 5) {
                        a.delItem(P.getData());
                        Coin C = (Coin) P.getData();
                        Main.money += C.getValue();
                        break;
                    }
                }
            }
            P = P.getNext();
        }
    }
    /**
     * A method describing move behavior of a Snail.
     * @param a The environment to observe where to move.
     */
    @Override
    public void move(Aquarium a) {
        boolean found = false;
        ElmtLList<Item> Pi = a.getItems().getFirst();
        while (Pi != null) {
            if (Pi.getData() instanceof Coin) {
                if (this.x < Pi.getData().getX() - 1) {
                    direction = 1;
                    this.x++;
                    this.x++;
                } else if (this.x > Pi.getData().getX() + 1) {
                    direction = -1;
                    this.x--;
                    this.x--;
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
            } else if (this.x < xrand) {
                this.x++;
                direction = 1;
            } else {
                this.xrand = Main.randInt(0, 1000);
            }
        }
    }
    /**
     * A method to check if coin exists in the environment.
     * @param a The environment to observe coin.
     * @return boolean This returns true if coin exists in the environment.
     */
    boolean isCoinExist(Aquarium a) {
        ElmtLList<Item> P = a.getItems().getFirst();
        boolean found = false;
        while (P != null) {
            if (P.getData() instanceof Coin) {
                found = true;
                break;
            }
            P = P.getNext();
        }
        return found;
    }

    private int xrand;
}
