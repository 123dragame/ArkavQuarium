package gameTubes;
import java.lang.Comparable;
/**
* <h1>Entity</h1>
* An abstract class,
* defining things that exist in an environment.
*/
public abstract class Entity implements Comparable<Entity> {
    /**
     * Constructor to initialize the coordinate of the object.
     * @param x the desired abscissa for the object.
     * @param y the desired ordinate for the object.
     */
    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Compares two entities by their coordinates.
     * Overrides compareTo method from Comparable interface.
     * @param E the object to be compared.
     * @return int This returns 0 if the coordinates are the same.
     */
    @Override
    public int compareTo(Entity E) {
        if (E.getX() == getX() && E.getY() == getY()) {
            return 0;
        }
        return -1;
    }
    /**
     * Abstract method describing move behavior of an entity.
     * @param a The environment to observe where to move.
     */
    public abstract void move(Aquarium a);
    /**
     * Getter of object's abscissa.
     * @return int This returns object's abscissa.
     */
    public int getX() {
        return this.x;
    }
    /**
     * Getter of object's ordinate.
     * @return int This returns object's ordinate.
     */
    public int getY() {
        return this.y;
    }
    /**
     * Setter of object's abscissa.
     * @param x The desired abscissa for the object.
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Setter of object's ordinate.
     * @param y The desired ordinate for the object.
     */
    public void setY(int y) {
        this.y = y;
    }

    protected int x;
    protected int y;

};
