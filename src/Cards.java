import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cards{
    JButton pickUpCardbtn;
    JButton exitBtn;
    JFrame windowForLives;
    public Cards()
    {
        windowForLives = new JFrame("Lives");
        FlowLayout flowLayout = new FlowLayout();
        windowForLives.setLayout(flowLayout);
        windowForLives.setSize(350,100);
        windowForLives.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton pickUpCardbtn = new JButton("Please pick up card");

        CardEventHandler handler = new CardEventHandler();
        pickUpCardbtn.addActionListener(handler);

        windowForLives.setVisible(true);

        JButton exitBtn = new JButton("Exit");
        windowForLives.add(pickUpCardbtn, exitBtn);
        exitBtn.addActionListener(handler);
    }
    //outer for loop going through suits
    //inner for loop going through types


    private class CardEventHandler implements ActionListener{

        public void actionPerformed(ActionEvent e)
        {
            CardConstructor clubAce = new CardConstructor("Club", "Ace");
            //suits of cards
            String[] deck = new String[]{"Ace of Clubs", "Queen of Clubs", "Jack of Clubs", "King of Clubs", "Two of Clubs", "Three of Clubs", "Four of Clubs",
                    "Five of Clubs", "Six of Clubs", "Seven of Clubs", "Eight of Clubs", "Nine of Clubs", "Ten of Clubs", "Ace of Spades", "Queen of Spades",
                    "Jack of Spades", "King of Spades", "Two of Spades", "Three of Spades", "Four of Spades", "Five of Spades", "Six of Spades", "Seven of Spades",
                    "Eight of Spades", "Nine of Spades", "Ten of Spades", "Ace of Diamonds", "Queen of Diamonds", "Jack of Diamonds", "King of Diamonds",
                    "Two of Diamonds", "Three of Diamonds", "Four of Diamonds", "Five of Diamonds", "Six of Diamonds", "Seven of Diamonds", "Eight of Diamonds",
                    "Nine of Diamonds", "Ten of Diamonds", "Ace of Hearts", "Queen of Hearts", "Jack of Hearts", "King of Hearts", "Two of Hearts", "Three of Hearts",
                    "Four of Hearts", "Five of Hearts", "Six of Hearts", "Seven of Hearts", "Eight of Hearts", "Nine of Hearts", "Ten of Hearts"};


            //math.Random that picks a random item from suitArray
            String chosenCard = deck[(int)(Math.random() * deck.length)];

      /*  JOptionPane.showMessageDialog(null, "2 = +2 card \nJack = skips a player \nKing = Reverses direction \nAce = Can be placed on any suit or number and changes type" +
                "\nQueen = Next player MUST match the suit of the Queen card", "Rules of Lives!",  JOptionPane.INFORMATION_MESSAGE);*/

            //adapted from https://stackoverflow.com/questions/25150199/pick-a-random-element-from-a-string-array
            //math.Random that picks a random item from cardType
            //outputCard = math.Random for suitArray + math.Random for cardType
            String outputCard = chosenCard;
            JOptionPane.showMessageDialog(null, outputCard);


            //add in card abilities
            if(chosenCard.substring(0,3).equals("Two")){
                JOptionPane.showMessageDialog(null, "Next player gets 2 more cards");
            }

            else if(chosenCard.substring(0,4).equals("Jack")){
                JOptionPane.showMessageDialog(null, "Next player in rotation gets skipped");
            }

            else if(chosenCard.substring(0,4).equals("King")){
                JOptionPane.showMessageDialog(null, "The Direction gets reversed");
            }

            else if(chosenCard.substring(0,3).equals("Ace")){
                JOptionPane.showMessageDialog(null, "Player who placed card can chose what suit the next card played is");
            }

            else if(chosenCard.substring(0,5).equals("Queen")){
                JOptionPane.showMessageDialog(null, "The next player must place a " + chosenCard + " or pick up a card");
            }

            else{
                JOptionPane.showMessageDialog(null, "Play as standard");
            }



            //System.exit(0);


        }
    }
}