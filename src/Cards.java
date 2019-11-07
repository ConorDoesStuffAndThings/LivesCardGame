import javax.swing.*;

public class Cards {
    public static void main(String[] args) {

    //suits of cards
    String[] suitArray = new String[]{"Clubs", "Spades", "Diamonds", "Spades"};

    //card numbers
    String[] cardType = new String[]{"Ace", "Queen", "Jack", "King", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

    //math.Random that picks a random item from suitArray
        String chosenSuit = suitArray[(int)(Math.random() * suitArray.length)];


        //adapted from https://stackoverflow.com/questions/25150199/pick-a-random-element-from-a-string-array
        //math.Random that picks a random item from cardType

        String chosenType = cardType[(int)(Math.random() * cardType.length)];

        //outputCard = math.Random for suitArray + math.Random for cardType
        String outputCard = chosenType +" of " + chosenSuit;

        JOptionPane.showMessageDialog(null, outputCard);

    }
}
