import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Cards extends JFrame implements LivesIn{
    JButton pickUpCardBtn;
    JButton exitBtn;
    JLabel player2Cards;
    JFrame windowForLives;
    ArrayList<CardClass> cards52;

    public Cards() {
        generateCards();

        //setting up window
        windowForLives = new JFrame("Lives");
        windowForLives.setLayout(null);
        windowForLives.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowForLives.setSize(1550,1000);
        JButton pickUpCardBtn = new JButton("");
        JButton exitBtn = new JButton("Exit");
        JLabel player2Cards = new JLabel(new ImageIcon(this.getClass().getResource("/images/back_cards.png")));
        JPanel playerCards = new JPanel();
        playerCards.setLayout(new GridLayout(1,10));
        playerCards.setBackground(Color.ORANGE);

        //adapted from java API
        windowForLives.setResizable(false);

        //line of code adapted from https://stackoverflow.com/questions/4801386/how-do-i-add-an-image-to-a-jbutton
        pickUpCardBtn.setIcon(new ImageIcon(this.getClass().getResource("/images/red_back.png")));

        //call event handlers
        PickUpCardEventHandler pickUpHandler = new PickUpCardEventHandler();
        backEventHandler exitHandler = new backEventHandler();


        windowForLives.setVisible(true);

        //add action listener to button
        pickUpCardBtn.addActionListener(pickUpHandler);
        exitBtn.addActionListener(exitHandler);



        //positioning buttons
        pickUpCardBtn.setSize(200,300);
        pickUpCardBtn.setLocation(1300,300);

        exitBtn.setSize(60,30);
        exitBtn.setLocation(1440,1);

        player2Cards.setBounds(320,10,720,300);
        playerCards.setBounds(20, 600, 1500, 350);

        //add buttons and label to the JFrame
        windowForLives.add(pickUpCardBtn);
        windowForLives.add(exitBtn);
        windowForLives.add(player2Cards);
        windowForLives.add(playerCards);

        windowForLives.setVisible(true);


        //place players cards on panel (playerCards) and make them buttons that change value when player picks up new card

    }
    //outer for loop going through suits
    //inner for loop going through types

    //method to generate cards
    public void generateCards(){
        cards52 = new ArrayList<CardClass>();
        cards52.add(new CardClass("Clubs", "Ace", true, new ImageIcon("/images/AC.png")));
        cards52.add(new CardClass("Clubs", "Two", true, new ImageIcon("/images/2C.png")));
        cards52.add(new CardClass("Clubs", "Three", true, new ImageIcon("/images/3C.png")));
        cards52.add(new CardClass("Clubs", "Four", true, new ImageIcon("/images/4C.png")));
        cards52.add(new CardClass("Clubs", "Five", true, new ImageIcon("/images/5C.png")));
        cards52.add(new CardClass("Clubs", "Six", true, new ImageIcon("/images/6C.png")));
        cards52.add(new CardClass("Clubs", "Seven", true, new ImageIcon("/images/7C.png")));
        cards52.add(new CardClass("Clubs", "Eight", true, new ImageIcon("/images/8C.png")));
        cards52.add(new CardClass("Clubs", "Nine", true, new ImageIcon("/images/9C.png")));
        cards52.add(new CardClass("Clubs", "Ten", true, new ImageIcon("/images/10C.png")));
        cards52.add(new CardClass("Clubs", "King", true, new ImageIcon("/images/KC.png")));
        cards52.add(new CardClass("Clubs", "Queen", true, new ImageIcon("/images/QC.png")));
        cards52.add(new CardClass("Clubs", "Jack", true, new ImageIcon("/images/JC.png")));
        cards52.add(new CardClass("Hearts", "Ace", true, new ImageIcon("/images/AH.png")));
        cards52.add(new CardClass("Hearts", "Two", true, new ImageIcon("/images/2H.png")));
        cards52.add(new CardClass("Hearts", "Three", true, new ImageIcon("/images/3H.png")));
        cards52.add(new CardClass("Hearts", "Four", true, new ImageIcon("/images/4H.png")));
        cards52.add(new CardClass("Hearts", "Five", true, new ImageIcon("/images/5H.png")));
        cards52.add(new CardClass("Hearts", "Six", true, new ImageIcon("/images/6H.png")));
        cards52.add(new CardClass("Hearts", "Seven", true, new ImageIcon("/images/7H.png")));
        cards52.add(new CardClass("Hearts", "Eight", true, new ImageIcon("/images/8H.png")));
        cards52.add(new CardClass("Hearts", "Nine", true, new ImageIcon("/images/9H.png")));
        cards52.add(new CardClass("Hearts", "Ten", true, new ImageIcon("/images/10H.png")));
        cards52.add(new CardClass("Hearts", "King", true, new ImageIcon("/images/KH.png")));
        cards52.add(new CardClass("Hearts", "Queen", true, new ImageIcon("/images/QH.png")));
        cards52.add(new CardClass("Hearts", "Jack", true, new ImageIcon("/images/JH.png")));
        cards52.add(new CardClass("Spades", "Ace", true, new ImageIcon("/images/AS.png")));
        cards52.add(new CardClass("Spades", "Two", true, new ImageIcon("/images/2S.png")));
        cards52.add(new CardClass("Spades", "Three", true, new ImageIcon("/images/3S.png")));
        cards52.add(new CardClass("Spades", "Four", true, new ImageIcon("/images/4S.png")));
        cards52.add(new CardClass("Spades", "Five", true, new ImageIcon("/images/5S.png")));
        cards52.add(new CardClass("Spades", "Six", true, new ImageIcon("/images/6S.png")));
        cards52.add(new CardClass("Spades", "Seven", true, new ImageIcon("/images/7S.png")));
        cards52.add(new CardClass("Spades", "Eight", true, new ImageIcon("/images/8S.png")));
        cards52.add(new CardClass("Spades", "Nine", true, new ImageIcon("/images/9S.png")));
        cards52.add(new CardClass("Spades", "Ten", true, new ImageIcon("/images/10S.png")));
        cards52.add(new CardClass("Spades", "King", true, new ImageIcon("/images/KS.png")));
        cards52.add(new CardClass("Spades", "Queen", true, new ImageIcon("/images/QS.png")));
        cards52.add(new CardClass("Spades", "Jack", true, new ImageIcon("/images/JS.png")));
        cards52.add(new CardClass("Diamonds", "Ace", true, new ImageIcon("/images/AD.png")));
        cards52.add(new CardClass("Diamonds", "Two", true, new ImageIcon("/images/2D.png")));
        cards52.add(new CardClass("Diamonds", "Three", true, new ImageIcon("/images/3D.png")));
        cards52.add(new CardClass("Diamonds", "Four", true, new ImageIcon("/images/4D.png")));
        cards52.add(new CardClass("Diamonds", "Five", true, new ImageIcon("/images/5D.png")));
        cards52.add(new CardClass("Diamonds", "Six", true, new ImageIcon("/images/6D.png")));
        cards52.add(new CardClass("Diamonds", "Seven", true, new ImageIcon("/images/7D.png")));
        cards52.add(new CardClass("Diamonds", "Eight", true, new ImageIcon("/images/8D.png")));
        cards52.add(new CardClass("Diamonds", "Nine", true, new ImageIcon("/images/9D.png")));
        cards52.add(new CardClass("Diamonds", "Ten", true, new ImageIcon("/images/10D.png")));
        cards52.add(new CardClass("Diamonds", "King", true, new ImageIcon("/images/KD.png")));
        cards52.add(new CardClass("Diamonds", "Queen", true, new ImageIcon("/images/QD.png")));
        cards52.add(new CardClass("Diamonds", "Jack", true, new ImageIcon("/images/JD.png")));



    }//end of generateCards method


    //method to deals a card
    public CardClass dealACard(){
        CardClass card;
        Random r = new Random();
        int i = r.nextInt(52);
        card = cards52.get(i);
        card.setAvailable(false);
        return card;
    }//end of dealACard method

    //for player to play a card
    public CardClass playACard(){
        CardClass card=cards52.get(32);
    return card;
    } //end of playACard method

    //method to save wins and loses
    /*public saveInfo(ArrayList<Player> info)
    {

        try{
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(info);
            oos.close();
        }

        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null,"Error!!! File not found!", "Error", JOptionPane.WARNING_MESSAGE);

        }

        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,"Error. IOException occurred", "Error", JOptionPane.WARNING_MESSAGE);

        }
    }*/

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






    //EventHandler for PickUpCard
    private class PickUpCardEventHandler implements ActionListener{

        public void actionPerformed(ActionEvent e)
        {
            checkLivesRules();
        }
    }// end of PickUpCardEventHandler

    //handler to go to main menu
    private class backEventHandler implements ActionListener {

        public void actionPerformed(ActionEvent e)
        {
            //opens main menu
            new MainMenuGUI();

            //hides window
            windowForLives.setVisible(false);
        }
    }// end of PickUpCardEventHandler
}