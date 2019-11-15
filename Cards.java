import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Cards extends JFrame{
    JButton pickUpCardbtn;
    JButton exitBtn;
    JFrame windowForLives;
    CardClass[] cards52 = new CardClass[52];

    public Cards()
    {
        generateCards();

        windowForLives = new JFrame("Lives");
        GridBagLayout myLayout = new GridBagLayout();
        windowForLives.setLayout(myLayout);
        windowForLives.setSize(800,400);
        windowForLives.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton pickUpCardbtn = new JButton("");
        JButton exitBtn = new JButton("Exit");

        //adapted from https://stackoverflow.com/questions/45722445/how-to-set-jframe-to-full-screen
        windowForLives.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //from java API
        windowForLives.setResizable(false);

        //adapted from https://stackoverflow.com/questions/16756903/how-to-set-the-location-of-a-button-anywhere-in-your-jframe/16756933
        exitBtn.setLocation(12, 371);
        pickUpCardbtn.setPreferredSize(new Dimension(200, 300));

        //line of code adapted from https://stackoverflow.com/questions/4801386/how-do-i-add-an-image-to-a-jbutton
        pickUpCardbtn.setIcon(new ImageIcon(this.getClass().getResource("/images/red_back_resize.png")));

        //call event handlers
        PickUpCardEventHandler pickUpHandler = new PickUpCardEventHandler();
        ExitGameHandler exitHandler = new ExitGameHandler();


        windowForLives.setVisible(true);

        //add action listener to button
        pickUpCardbtn.addActionListener(pickUpHandler);
        exitBtn.addActionListener(exitHandler);

        //add buttons to the JFrame
        windowForLives.add(pickUpCardbtn);
        windowForLives.add(exitBtn);
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

    //method to deals a card
    public CardClass dealACard(){
        CardClass card;
        Random r = new Random();
        int i = r.nextInt(52);
        card = cards52[i];
        card.setAvailable(false);
        return card;
    }//end of dealACard method

    //method to check and enforce rules
    public void checkLivesRules(){
        CardClass currentCard = dealACard();
        JOptionPane.showMessageDialog(null, currentCard);

        //add in card abilities
        if(currentCard.getValueOfCard().equals("Two")){
            JOptionPane.showMessageDialog(null, "Next player gets 2 more cards " + currentCard.isAvailable());
        }

        else if(currentCard.getValueOfCard().equals("Jack")){
            JOptionPane.showMessageDialog(null, "Next player in rotation gets skipped "+ currentCard.isAvailable());
        }

        else if(currentCard.getValueOfCard().equals("King")){
            JOptionPane.showMessageDialog(null, "The Direction gets reversed "+ currentCard.isAvailable());
        }

        else if(currentCard.getValueOfCard().equals("Ace")){
            JOptionPane.showMessageDialog(null, "Player who placed card can chose what suit the next card played is "+ currentCard.isAvailable());
        }

        else if(currentCard.getValueOfCard().equals("Queen")){
            JOptionPane.showMessageDialog(null, "The next player must place a " + dealACard() + " or pick up a card "+ currentCard.isAvailable());
        }

        else{
            JOptionPane.showMessageDialog(null, "Play as standard "+ currentCard.isAvailable());
        }
    }//end of checkLivesRules







    private class PickUpCardEventHandler implements ActionListener{

        public void actionPerformed(ActionEvent e)
        {
            checkLivesRules();
        }
    }

    private class ExitGameHandler implements ActionListener{

        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
}