import java.io.Serializable;

/**
 * The type Player.
 */
public class Player implements Serializable {

    //player stats
    private int noOfWins;
    private int noOfLosses;

    /**
     * Instantiates a new Player.
     */
//player no-argument constructor
    public Player(){
        noOfWins = 0;
        noOfLosses = 0;
    }

    /**
     * Instantiates a new Player.
     *
     * @param noOfWins   the no of wins
     * @param noOfLosses the no of losses
     */
//player 2 argument constructor
    public Player(int noOfWins, int noOfLosses){
        setNoOfWins(noOfWins);
        setNoOfLosses(noOfLosses);
    }

    /**
     * Gets no of wins.
     *
     * @return the no of wins
     */
//getters and setters
    public int getNoOfWins() {
        return noOfWins;
    }

    /**
     * Sets no of wins.
     *
     * @param noOfWins the no of wins
     */
    public void setNoOfWins(int noOfWins) {
        this.noOfWins = noOfWins;
    }

    /**
     * Gets no of losses.
     *
     * @return the no of losses
     */
    public int getNoOfLosses() {
        return noOfLosses;
    }

    /**
     * Sets no of losses.
     *
     * @param noOfLosses the no of losses
     */
    public void setNoOfLosses(int noOfLosses) {
        this.noOfLosses = noOfLosses;
    }

    public String toString() {
        return "Player" + "\nWins: " + noOfWins + "\nLosses: " + noOfLosses;
    }
}
