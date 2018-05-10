package gameTubes;
/**
* <h1>Coin</h1>
* A subclass of Item class that has a value.
*/
public class Coin extends Item {

    private int value;
    /**
     * Constructor to initialize coin's value and other inherited attributes.
     * @param x the desired abscissa for the object.
     * @param y the desired ordinate for the object.
     * @param value the desired value for the coin.
     */
    public Coin(int x, int y, int value) {
        super(x, y);
        this.value = value;
    }
    /**
     * Getter of value.
     * @return int This returns value of the coin object.
     */
    public int getValue() {
        return this.value;
    }
    /**
     * Set the value of coin object to a desired one.
     * @param value The desired value.
     */
    public void setValue(int value) {
        this.value = value;
    }
}
