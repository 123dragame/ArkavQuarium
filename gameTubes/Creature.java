package gameTubes;
/**
* <h1>Creature</h1>
* An abstract subclass of Entity class,
* defining living entity such as fish and snail.
*/
public abstract class Creature extends Entity {
    /**
     * Constructor to initialize the direction of object and other inherited attributes.
     * @param x the desired abscissa for the object.
     * @param y the desired ordinate for the object.
     * @param direction the desired direction for the object.
     */
    public Creature(int x, int y, int direction) {
        super(x, y);
        this.direction = direction;
    }
    /**
     * Abstract method describing eat behavior of a creature.
     * @param a The environment to observe what to eat.
     */
    public abstract void eat(Aquarium a);
    /**
     * Abstract method describing move behavior of a creature.
     * @param a The environment to observe where to move.
     */
    public abstract void move(Aquarium a);
    /**
     * Getter of creature's direction.
     * @return int This returns creature's direction.
     */
    public int getDirection() {
        return this.direction;
    }
    /**
     * Setter of creature's direction.
     * @param direction The desired direction for the creature.
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    protected int direction;
};
