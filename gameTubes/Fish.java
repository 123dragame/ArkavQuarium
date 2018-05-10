package gameTubes;
/**
* <h1>Fish</h1>
* An interface,
* defining fish's behavior.
*/
public interface Fish {
    /**
     * Abstract method describing grow behavior of a fish.
     */
    public void grow();
    /**
     * Abstract method describing death behavior of a fish.
     * @param a The environment to observe the death.
     */
    public void death(Aquarium a);
    /**
     * Abstract method describing coin spawning behavior of a fish.(Game related)
     * @param a The environment to put the coin.
     */
    public void spawnCoin(Aquarium a);
}
