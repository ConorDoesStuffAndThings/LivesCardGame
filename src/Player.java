public class Player {

    //player stats
    private int noOfWins;
    private int noOfLosses;

    //player no-argument constructor
    public Player(){
        noOfWins = 0;
        noOfLosses = 0;
    }
    //player 2 argument constructor
    public Player(int noOfWins, int noOfLosses){
        setNoOfWins(noOfWins);
        setNoOfLosses(noOfLosses);
    }

    //getters and setters
    public int getNoOfWins() {
        return noOfWins;
    }

    public void setNoOfWins(int noOfWins) {
        this.noOfWins = noOfWins;
    }

    public int getNoOfLosses() {
        return noOfLosses;
    }

    public void setNoOfLosses(int noOfLosses) {
        this.noOfLosses = noOfLosses;
    }

    public String toString() {
        return "Player" + "\nWins: " + noOfWins + "\nLosses: " + noOfLosses;
    }
}
