import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Cards{
    JButton pickUpCardbtn;
    JButton exitBtn;
    JFrame windowForLives;
    CardClass[] cards52 = new CardClass[52];



    public Cards()
    {
        generateCards();

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

    //method to generate cards
    public void generateCards(){
        cards52[0] = new CardClass("Clubs", "Ace", true);
        cards52[1] = new CardClass("Clubs", "Two", true);
        cards52[2] = new CardClass("Clubs", "Three", true);
        cards52[3] = new CardClass("Clubs", "Four", true);
        cards52[4] = new CardClass("Clubs", "Five", true);
        cards52[5] = new CardClass("Clubs", "Six", true);
        cards52[6] = new CardClass("Clubs", "Seven", true);
        cards52[7] = new CardClass("Clubs", "Eight", true);
        cards52[8] = new CardClass("Clubs", "Nine", true);
        cards52[9] = new CardClass("Clubs", "Ten", true);
        cards52[10] = new CardClass("Clubs", "King", true);
        cards52[11] = new CardClass("Clubs", "Queen", true);
        cards52[12] = new CardClass("Clubs", "Jack", true);
        cards52[13] = new CardClass("Hearts", "Ace", true);
        cards52[14] = new CardClass("Hearts", "Two", true);
        cards52[15] = new CardClass("Hearts", "Three", true);
        cards52[16] = new CardClass("Hearts", "Four", true);
        cards52[17] = new CardClass("Hearts", "Five", true);
        cards52[18] = new CardClass("Hearts", "Six", true);
        cards52[19] = new CardClass("Hearts", "Seven", true);
        cards52[20] = new CardClass("Hearts", "Eight", true);
        cards52[21] = new CardClass("Hearts", "Nine", true);
        cards52[22] = new CardClass("Hearts", "Ten", true);
        cards52[23] = new CardClass("Hearts", "King", true);
        cards52[24] = new CardClass("Hearts", "Queen", true);
        cards52[25] = new CardClass("Hearts", "Jack", true);
        cards52[26] = new CardClass("Spades", "Ace", true);
        cards52[27] = new CardClass("Spades", "Two", true);
        cards52[28] = new CardClass("Spades", "Three", true);
        cards52[29] = new CardClass("Spades", "Four", true);
        cards52[30] = new CardClass("Spades", "Five", true);
        cards52[31] = new CardClass("Spades", "Six", true);
        cards52[32] = new CardClass("Spades", "Seven", true);
        cards52[33] = new CardClass("Spades", "Eight", true);
        cards52[34] = new CardClass("Spades", "Nine", true);
        cards52[35] = new CardClass("Spades", "Ten", true);
        cards52[36] = new CardClass("Spades", "King", true);
        cards52[37] = new CardClass("Spades", "Queen", true);
        cards52[38] = new CardClass("Spades", "Jack", true);
        cards52[39] = new CardClass("Diamonds", "Ace", true);
        cards52[40] = new CardClass("Diamonds", "Two", true);
        cards52[41] = new CardClass("Diamonds", "Three", true);
        cards52[42] = new CardClass("Diamonds", "Four", true);
        cards52[43] = new CardClass("Diamonds", "Five", true);
        cards52[44] = new CardClass("Diamonds", "Six", true);
        cards52[45] = new CardClass("Diamonds", "Seven", true);
        cards52[46] = new CardClass("Diamonds", "Eight", true);
        cards52[47] = new CardClass("Diamonds", "Nine", true);
        cards52[48] = new CardClass("Diamonds", "Ten", true);
        cards52[49] = new CardClass("Diamonds", "King", true);
        cards52[50] = new CardClass("Diamonds", "Queen", true);
        cards52[51] = new CardClass("Diamonds", "Jack", true);
    }//end of generateCards method


    public CardClass dealACard(){
        CardClass card;
        Random r = new Random(52);
        int i = r.nextInt();
        card = cards52[i];
         return card;

    }






    private class CardEventHandler implements ActionListener{

        public void actionPerformed(ActionEvent e)
        {



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

                cards52[i] = cards52[(int)(Math.random() * cards52.length)];

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