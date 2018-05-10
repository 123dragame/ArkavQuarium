package gameTubes;
/**
* <h1>Item</h1>
* A subclass of Entity class,
* defining inanimate object's behavior.
*/
public abstract class Item extends Entity {
    /**
     * Constructor to initialize the item's timer and other inherited attributes.
     * @param x the desired abscissa for the object.
     * @param y the desired ordinate for the object.
     */
    public Item(int x, int y) {
        super(x, y);
        timer = 0;
    }
    /**
     * A method to check if the item is on land.
     * @return boolean This returns true if the item's ordinate is 0.
     */
    public boolean isOnLand() {
        return (this.getY() == 0);
    }

    /**
     * A method describing move behavior of an item.
     * @param a The environment to observe where to move.
     */
    @Override
    public void move(Aquarium a) {
        if (this.y > 655) {
            if (timer > 300) {
                a.delItem(this);
            }
            timer++;
        } else {
            this.y++;
        }
    }

    private int timer = 0;
}
