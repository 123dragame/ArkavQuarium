package gameTubes;
/**
* <h1>Aquarium</h1>
* An environment containing entities like fishes, snails, coins, and pellets.
*/

public class Aquarium {

    private LList<Creature> CrList;

    private LList<Item> ItList;
    /**
     * Constructor to create lists containing Creature and Item objects.
     */
    public Aquarium() {
        CrList = new LList<Creature>();
        ItList = new LList<Item>();
    }
    /**
     * Getter of list of creatures.
     * @return CrList This returns list of creatures.
     */
    public LList<Creature> getCreatures() {
        return CrList;
    }
    /**
     * Getter of list of items.
     * @return ItList This returns list of items.
     */
    public LList<Item> getItems() {
        return ItList;
    }
    /**
     * Insert Creature C to list of creatures.
     * @param C the creature to be added.
     */
    public void insertCreature(Creature C) {
        CrList.add(C);
    }
    /**
     * Insert Item I to list of items.
     * @param I the creature to be added.
     */
    public void insertItem(Item I) {
        ItList.add(I);
    }
    /**
     * Delete Item I in the list of items.
     * @param I the creature to be deleted.
     */
    public void delItem(Item I) {
        ItList.remove(I);
    }
    /**
     * Insert Creature C in the list of creatures.
     * @param C the creature to be deleted.
     */
    public void delCreature(Creature C) {
        CrList.remove(C);
    }
}
