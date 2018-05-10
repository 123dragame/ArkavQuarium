package gameTubes;
/**
* <h1>ElmtLList</h1>
* Generic linked list element.
* @param <T extends Entity> Generic class T must be Entity class or a subclass of Entity.
*/
public class ElmtLList<T extends Entity> {
    private T data;
    private ElmtLList<T> next;
    /**
     * Constructor to initialize the data contained by the object.
     * @param data The desired data for the object.
     */
    public ElmtLList(T data) {
        this.data = data;
        next = null;
    }
    /**
     * Getter of the data contained by the object.
     * @return T This returns the data of generic list element.
     */
    public T getData() {
        return data;
    }
    /**
     * Getter of reference to next element.
     * @return T This returns the reference to next list element.
     */
    public ElmtLList<T> getNext() {
        return next;
    }
    /**
     * Setter of the data contained by the object.
     * @param data The desired data to be contained by the object.
     */
    public void setData(T data) {
        this.data = data;
    }
    /**
     * Setter of reference to next element.
     * @param next The desired reference to be pointed at.
     */
    public void setNext(ElmtLList<T> next) {
        this.next = next;
    }
}
