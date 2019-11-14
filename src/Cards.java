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
            CardConstructor[] cards52 = new CardConstructor[52];

            cards52[0] = new CardConstructor("Clubs", "Ace");
            cards52[1] = new CardConstructor("Clubs", "Two");
            cards52[2] = new CardConstructor("Clubs", "Three");
            cards52[3] = new CardConstructor("Clubs", "Four");
            cards52[4] = new CardConstructor("Clubs", "Five");
            cards52[5] = new CardConstructor("Clubs", "Six");
            cards52[6] = new CardConstructor("Clubs", "Seven");
            cards52[7] = new CardConstructor("Clubs", "Eight");
            cards52[8] = new CardConstructor("Clubs", "Nine");
            cards52[9] = new CardConstructor("Clubs", "Ten");
            cards52[10] = new CardConstructor("Clubs", "King");
            cards52[11] = new CardConstructor("Clubs", "Queen");
            cards52[12] = new CardConstructor("Clubs", "Jack");
            cards52[13] = new CardConstructor("Hearts", "Ace");
            cards52[14] = new CardConstructor("Hearts", "Two");
            cards52[15] = new CardConstructor("Hearts", "Three");
            cards52[16] = new CardConstructor("Hearts", "Four");
            cards52[17] = new CardConstructor("Hearts", "Five");
            cards52[18] = new CardConstructor("Hearts", "Six");
            cards52[19] = new CardConstructor("Hearts", "Seven");
            cards52[20] = new CardConstructor("Hearts", "Eight");
            cards52[21] = new CardConstructor("Hearts", "Nine");
            cards52[22] = new CardConstructor("Hearts", "Ten");
            cards52[23] = new CardConstructor("Hearts", "King");
            cards52[24] = new CardConstructor("Hearts", "Queen");
            cards52[25] = new CardConstructor("Hearts", "Jack");
            cards52[26] = new CardConstructor("Spades", "Ace");
            cards52[27] = new CardConstructor("Spades", "Two");
            cards52[28] = new CardConstructor("Spades", "Three");
            cards52[29] = new CardConstructor("Spades", "Four");
            cards52[30] = new CardConstructor("Spades", "Five");
            cards52[31] = new CardConstructor("Spades", "Six");
            cards52[32] = new CardConstructor("Spades", "Seven");
            cards52[33] = new CardConstructor("Spades", "Eight");
            cards52[34] = new CardConstructor("Spades", "Nine");
            cards52[35] = new CardConstructor("Spades", "Ten");
            cards52[36] = new CardConstructor("Spades", "King");
            cards52[37] = new CardConstructor("Spades", "Queen");
            cards52[38] = new CardConstructor("Spades", "Jack");
            cards52[39] = new CardConstructor("Diamonds", "Ace");
            cards52[40] = new CardConstructor("Diamonds", "Two");
            cards52[41] = new CardConstructor("Diamonds", "Three");
            cards52[42] = new CardConstructor("Diamonds", "Four");
            cards52[43] = new CardConstructor("Diamonds", "Five");
            cards52[44] = new CardConstructor("Diamonds", "Six");
            cards52[45] = new CardConstructor("Diamonds", "Seven");
            cards52[46] = new CardConstructor("Diamonds", "Eight");
            cards52[47] = new CardConstructor("Diamonds", "Nine");
            cards52[48] = new CardConstructor("Diamonds", "Ten");
            cards52[49] = new CardConstructor("Diamonds", "King");
            cards52[50] = new CardConstructor("Diamonds", "Queen");
            cards52[51] = new CardConstructor("Diamonds", "Jack");
            //suits of cards
            /*String[] deck = new String[]{"Ace of Clubs", "Queen of Clubs", "Jack of Clubs", "King of Clubs", "Two of Clubs", "Three of Clubs", "Four of Clubs",
                    "Five of Clubs", "Six of Clubs", "Seven of Clubs", "Eight of Clubs", "Nine of Clubs", "Ten of Clubs", "Ace of Spades", "Queen of Spades",
                    "Jack of Spades", "King of Spades", "Two of Spades", "Three of Spades", "Four of Spades", "Five of Spades", "Six of Spades", "Seven of Spades",
                    "Eight of Spades", "Nine of Spades", "Ten of Spades", "Ace of Diamonds", "Queen of Diamonds", "Jack of Diamonds", "King of Diamonds",
                    "Two of Diamonds", "Three of Diamonds", "Four of Diamonds", "Five of Diamonds", "Six of Diamonds", "Seven of Diamonds", "Eight of Diamonds",
                    "Nine of Diamonds", "Ten of Diamonds", "Ace of Hearts", "Queen of Hearts", "Jack of Hearts", "King of Hearts", "Two of Hearts", "Three of Hearts",
                    "Four of Hearts", "Five of Hearts", "Six of Hearts", "Seven of Hearts", "Eight of Hearts", "Nine of Hearts", "Ten of Hearts"}; */


            //math.Random that picks a random item from suitArray
            //String chosenCard = cards52[(int)(Math.random() * deck.length)];

            for(int i = 0; i<52; i++){
                cards52[i] = cards52[(int)(Math.random() * cards52.length)];


            }
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