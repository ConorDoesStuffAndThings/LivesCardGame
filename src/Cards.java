import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cards{
    JButton pickUpCardbtn;
    JFrame windowForLives;
    public Cards()
    {
        windowForLives = new JFrame("Lives");
        FlowLayout flowLayout = new FlowLayout();
        windowForLives.setLayout(flowLayout);
        windowForLives.setSize(350,100);
        windowForLives.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton pickUpCardbtn = new JButton("Please pick up card");
        windowForLives.add(pickUpCardbtn);
        CardEventHandler handler = new CardEventHandler();
        pickUpCardbtn.addActionListener(handler);
        windowForLives.setVisible(true);

    }

    public static void main(String args[])
    {
        Cards myGUI = new Cards();

    }

    private class CardEventHandler implements ActionListener{

        public void actionPerformed(ActionEvent e)
        {
            //suits of cards
            String[] suitArray = new String[]{"Clubs", "Spades", "Diamonds", "Spades"};

            //card numbers
            String[] cardType = new String[]{"Ace", "Queen", "Jack", "King", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

            //math.Random that picks a random item from suitArray
            String chosenSuit = suitArray[(int)(Math.random() * suitArray.length)];

      /*  JOptionPane.showMessageDialog(null, "2 = +2 card \nJack = skips a player \nKing = Reverses direction \nAce = Can be placed on any suit or number and changes type" +
                "\nQueen = Next player MUST match the suit of the Queen card", "Rules of Lives!",  JOptionPane.INFORMATION_MESSAGE);*/
            //adapted from https://stackoverflow.com/questions/25150199/pick-a-random-element-from-a-string-array
            //math.Random that picks a random item from cardType

            String chosenType = cardType[(int)(Math.random() * cardType.length)];

            //outputCard = math.Random for suitArray + math.Random for cardType
            String outputCard = chosenType + " of " + chosenSuit;

            JOptionPane.showMessageDialog(null, outputCard);


            //add in card abilities
            if(cardType.equals("Two")){
                JOptionPane.showMessageDialog(null, "Next player gets 2 more cards");
            }

            else if(cardType.equals("Jack")){
                JOptionPane.showMessageDialog(null, "Next player in rotation gets skipped");
            }

            else if(cardType.equals("King")){
                JOptionPane.showMessageDialog(null, "The Direction gets reversed");
            }

            else if(cardType.equals("Ace")){
                JOptionPane.showMessageDialog(null, "Player who placed card can chose what suit the next card played is");
            }

            else if(cardType.equals("Queen")){
                JOptionPane.showMessageDialog(null, "The next player must place a " + chosenSuit + " or pick up a card");
            }

            else{
                JOptionPane.showMessageDialog(null, "Play as standard");
            }



            System.exit(0);


        }
    }
}