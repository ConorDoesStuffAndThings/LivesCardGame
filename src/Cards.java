import javax.swing.*;

public class Cards {
    public static void main(String[] args) {

    //suits of cards
    String[] suitArray = new String[]{"Clubs", "Spades", "Diamonds", "Spades"};

    //card numbers
    String[] cardType = new String[]{"Ace", "Queen", "Jack", "King", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

    //math.Random that picks a random item from suitArray
        String chosenSuit = suitArray[(int)(Math.random() * suitArray.length)];

        JOptionPane.showMessageDialog(null, "2 = +2 card \nJack = skips a player \nKing = Reverses direction \nAce = Can be placed on any suit or number and changes type" +
                "\nQueen = Next player MUST match the suit of the Queen card", "Rules of Lives!",  JOptionPane.INFORMATION_MESSAGE);
        //adapted from https://stackoverflow.com/questions/25150199/pick-a-random-element-from-a-string-array
        //math.Random that picks a random item from cardType

        String chosenType = cardType[(int)(Math.random() * cardType.length)];

        //outputCard = math.Random for suitArray + math.Random for cardType
        String outputCard = chosenType +" of " + chosenSuit;

        JOptionPane.showMessageDialog(null, outputCard);


        //

    }
}
