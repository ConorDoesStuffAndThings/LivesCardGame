import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Cards extends JFrame implements LivesIn{
    JButton pickUpCardBtn;
    JButton exitBtn;
    JFrame windowForLives;
    CardClass[] cards52 = new CardClass[52];

    public Cards() {
        generateCards();

        windowForLives = new JFrame("Lives");
        windowForLives.setLayout(null);
        windowForLives.setSize(800,400);
        windowForLives.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton pickUpCardBtn = new JButton("");
        JButton exitBtn = new JButton("Exit");
        JLabel player2Cards = new JLabel(new ImageIcon("/images/back_cards.png"));









        //adapted from https://stackoverflow.com/questions/45722445/how-to-set-jframe-to-full-screen
        windowForLives.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //adapted from java API
        windowForLives.setResizable(false);

        //line of code adapted from https://stackoverflow.com/questions/4801386/how-do-i-add-an-image-to-a-jbutton
        pickUpCardBtn.setIcon(new ImageIcon(this.getClass().getResource("/images/red_back.png")));

        //call event handlers
        PickUpCardEventHandler pickUpHandler = new PickUpCardEventHandler();
        ExitGameHandler exitHandler = new ExitGameHandler();


        windowForLives.setVisible(true);

        //add action listener to button
        pickUpCardBtn.addActionListener(pickUpHandler);
        exitBtn.addActionListener(exitHandler);

        //add buttons and label to the JFrame
        windowForLives.add(pickUpCardBtn);
        windowForLives.add(exitBtn);
        windowForLives.add(player2Cards);

        //positioning buttons
        pickUpCardBtn.setSize(200,300);
        pickUpCardBtn.setLocation(1300,300);

        exitBtn.setSize(60,30);
        exitBtn.setLocation(1440,1);

        player2Cards.setSize(620,300);
        player2Cards.setLocation(720,300);




    }
    //outer for loop going through suits
    //inner for loop going through types

    //method to generate cards
    public void generateCards(){
        cards52[0] = new CardClass("Clubs", "Ace", true, new ImageIcon("/images/AC.png"));
        cards52[1] = new CardClass("Clubs", "Two", true, new ImageIcon("/images/2C.png"));
        cards52[2] = new CardClass("Clubs", "Three", true, new ImageIcon("/images/3C.png"));
        cards52[3] = new CardClass("Clubs", "Four", true, new ImageIcon("/images/4C.png"));
        cards52[4] = new CardClass("Clubs", "Five", true, new ImageIcon("/images/5C.png"));
        cards52[5] = new CardClass("Clubs", "Six", true, new ImageIcon("/images/6C.png"));
        cards52[6] = new CardClass("Clubs", "Seven", true, new ImageIcon("/images/7C.png"));
        cards52[7] = new CardClass("Clubs", "Eight", true, new ImageIcon("/images/8C.png"));
        cards52[8] = new CardClass("Clubs", "Nine", true, new ImageIcon("/images/9C.png"));
        cards52[9] = new CardClass("Clubs", "Ten", true, new ImageIcon("/images/10C.png"));
        cards52[10] = new CardClass("Clubs", "King", true, new ImageIcon("/images/KC.png"));
        cards52[11] = new CardClass("Clubs", "Queen", true, new ImageIcon("/images/QC.png"));
        cards52[12] = new CardClass("Clubs", "Jack", true, new ImageIcon("/images/JC.png"));
        cards52[13] = new CardClass("Hearts", "Ace", true, new ImageIcon("/images/AH.png"));
        cards52[14] = new CardClass("Hearts", "Two", true, new ImageIcon("/images/2H.png"));
        cards52[15] = new CardClass("Hearts", "Three", true, new ImageIcon("/images/3H.png"));
        cards52[16] = new CardClass("Hearts", "Four", true, new ImageIcon("/images/4H.png"));
        cards52[17] = new CardClass("Hearts", "Five", true, new ImageIcon("/images/5H.png"));
        cards52[18] = new CardClass("Hearts", "Six", true, new ImageIcon("/images/6H.png"));
        cards52[19] = new CardClass("Hearts", "Seven", true, new ImageIcon("/images/7H.png"));
        cards52[20] = new CardClass("Hearts", "Eight", true, new ImageIcon("/images/8H.png"));
        cards52[21] = new CardClass("Hearts", "Nine", true, new ImageIcon("/images/9H.png"));
        cards52[22] = new CardClass("Hearts", "Ten", true, new ImageIcon("/images/10H.png"));
        cards52[23] = new CardClass("Hearts", "King", true, new ImageIcon("/images/KH.png"));
        cards52[24] = new CardClass("Hearts", "Queen", true, new ImageIcon("/images/QH.png"));
        cards52[25] = new CardClass("Hearts", "Jack", true, new ImageIcon("/images/JH.png"));
        cards52[26] = new CardClass("Spades", "Ace", true, new ImageIcon("/images/AS.png"));
        cards52[27] = new CardClass("Spades", "Two", true, new ImageIcon("/images/2S.png"));
        cards52[28] = new CardClass("Spades", "Three", true, new ImageIcon("/images/3S.png"));
        cards52[29] = new CardClass("Spades", "Four", true, new ImageIcon("/images/4S.png"));
        cards52[30] = new CardClass("Spades", "Five", true, new ImageIcon("/images/5S.png"));
        cards52[31] = new CardClass("Spades", "Six", true, new ImageIcon("/images/6S.png"));
        cards52[32] = new CardClass("Spades", "Seven", true, new ImageIcon("/images/7S.png"));
        cards52[33] = new CardClass("Spades", "Eight", true, new ImageIcon("/images/8S.png"));
        cards52[34] = new CardClass("Spades", "Nine", true, new ImageIcon("/images/9S.png"));
        cards52[35] = new CardClass("Spades", "Ten", true, new ImageIcon("/images/10S.png"));
        cards52[36] = new CardClass("Spades", "King", true, new ImageIcon("/images/KS.png"));
        cards52[37] = new CardClass("Spades", "Queen", true, new ImageIcon("/images/QS.png"));
        cards52[38] = new CardClass("Spades", "Jack", true, new ImageIcon("/images/JS.png"));
        cards52[39] = new CardClass("Diamonds", "Ace", true, new ImageIcon("/images/AD.png"));
        cards52[40] = new CardClass("Diamonds", "Two", true, new ImageIcon("/images/2D.png"));
        cards52[41] = new CardClass("Diamonds", "Three", true, new ImageIcon("/images/3D.png"));
        cards52[42] = new CardClass("Diamonds", "Four", true, new ImageIcon("/images/4D.png"));
        cards52[43] = new CardClass("Diamonds", "Five", true, new ImageIcon("/images/5D.png"));
        cards52[44] = new CardClass("Diamonds", "Six", true, new ImageIcon("/images/6D.png"));
        cards52[45] = new CardClass("Diamonds", "Seven", true, new ImageIcon("/images/7D.png"));
        cards52[46] = new CardClass("Diamonds", "Eight", true, new ImageIcon("/images/8D.png"));
        cards52[47] = new CardClass("Diamonds", "Nine", true, new ImageIcon("/images/9D.png"));
        cards52[48] = new CardClass("Diamonds", "Ten", true, new ImageIcon("/images/10D.png"));
        cards52[49] = new CardClass("Diamonds", "King", true, new ImageIcon("/images/KD.png"));
        cards52[50] = new CardClass("Diamonds", "Queen", true, new ImageIcon("/images/QD.png"));
        cards52[51] = new CardClass("Diamonds", "Jack", true, new ImageIcon("/images/JD.png"));
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

    //for player to play a card
    public CardClass playACard(){
        CardClass card=cards52[42];
    return card;
    } //end of playACard method

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