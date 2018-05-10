package gameTubes;
/**
* <h1>LList</h1>
* Generic linked list.
* @param <T extends Entity> Generic class T must be Entity class or a subclass of Entity.
*/
public class LList<T extends Entity> {
    private ElmtLList<T> first;
    /**
     * Constructor to create an empty list.
     */
    public LList() {
        first = null;
    }
    /**
     * Constructor to create a list with the first element initialized.
     * @param data The desired first element of the list.
     */
    public LList(T data) {
        first = new ElmtLList<T>(data);
    }
    /**
     * Getter of the first element of the list.
     * @return ElmtLList<T> This returns the first element of the list.
     */
    public ElmtLList<T> getFirst() {
        return first;
    }
    /**
     * A method to check if the list is empty.
     * @return boolean This returns true if the list is empty.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * A method to add an element to the list.
     * @param data The desired data to be contained by the new element of the list.
     */
    public void add(T data) {
        if (!isEmpty()) {
            ElmtLList<T> P = first;
            while (P.getNext() != null) {
                P = P.getNext();
            }
            ElmtLList<T> PNewElm = new ElmtLList<T>(data);
            P.setNext(PNewElm);
        } else {
            first = new ElmtLList<T>(data);
        }
    }

    /**
     * A method to remove an element of the list containing the data.
     * @param data The desired data to be matched with the element of the list.
     */
    public void remove(T data) {
        ElmtLList<T> P = first;
        ElmtLList<T> Prec = null;
        while (P != null) {
            if (P.getData().compareTo(data) == 0) {
                if (P == first) {
                    first = P.getNext();
                    break;
                } else {
                    Prec.setNext(P.getNext());
                    break;
                }
            } else {
                Prec = P;
                P = P.getNext();
            }
        }
    }

    /**
     * Getter of the element at the desired index.
     * @param idx The desired index of the element.
     * @return T This returns the data contained by the element.
     */
    public T get(int idx) {
        int count = 0;
        ElmtLList<T> P = first;
        while (count < idx) {
            P = P.getNext();
            count++;
        }
        return P.getData();
    }

    /**
     * A method to find index of the element containing the data.
     * @param data The reference data to be matched with the element.
     * @return int This returns index of the element containing the data.
     */
    public int find(T data) {
        int idx = 0;
        boolean f = false;
        ElmtLList<T> P = first;
        while (P != null) {
            if (P.getData().compareTo(data) == 0) {
                f = true;
                break;
            } else {
                P = P.getNext();
                idx++;
            }
        }
        if (f) {
            return idx;
        }
        return -1;
    }
}
