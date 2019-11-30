//LivesGUI.java
/*This game  is the card game lives, both the player and the CPU (player2) start off with 7 cards
* A random card from the deck is placed in the center, player one gets to play first, if player one
* doesn't have a card that matches the suit or value of the card in the center player one must pick up a card,
* The player can also pick up a card whenever they like, if the player holds more than 20 cards they lose the game.
* Their is five values with abilities, Two, Jack, King, Queen and Ace,
* Two - Next player in rotation must pick up 2 cards.
* Jack - Next player in rotation gets skipped.
* King - Changes the direction of rotation (has no function if their are only two players.
* Queen - Next player in rotation can must pick up 4 cards
* Ace - The Wildcard, can be played at any time regardless of suit and changes the suit played. */

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class LivesGUI extends JFrame implements LivesIn{
    File f;
    ArrayList<Player> readPlayerInfo;

    JButton pickUpCardBtn;
    JButton exitBtn;
    JButton[] playerCardBtns;
    JButton[] player2CardBtns;
    JPanel player2Cards;
    JFrame windowForLives;
    JPanel playerCards;
    JPanel stackOfCardsPnl;
    JLabel cardForStackLbl;
    ArrayList<Card> cards;




    public LivesGUI() {

        setUpGUI();
        generateCards();
        generatePlayerCards();
        generatePlayer2Cards();
        cardOnStack();






        //place players cards on panel (playerCards) and make them buttons that change value when player picks up new card

    }//end of LivesGUI constructor


    //deals with the GUI setup
    public void setUpGUI(){
        //setting up window
        windowForLives = new JFrame("Lives");
        windowForLives.setLayout(null);
        windowForLives.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowForLives.setSize(1550,830);
        pickUpCardBtn = new JButton("");
        exitBtn = new JButton("Exit");
        player2Cards = new JPanel();
        player2Cards.setLayout(null);
        playerCards = new JPanel();
        playerCards.setLayout(null);
        //playerCards.setLayout(new GridLayout (1,1));
        //playerCards.setLayout(new BoxLayout().createHorizontalBox();

        // playerCards.setLayout(new BoxLayout(playerCards,BoxLayout.LINE_AXIS));

        playerCards.setBackground(Color.ORANGE);
        player2Cards.setBackground(Color.PINK);
        stackOfCardsPnl = new JPanel();
        stackOfCardsPnl.setLayout(new GridLayout(1,1 ));
        stackOfCardsPnl.setBackground(Color.GREEN);

        //adapted from java API
        windowForLives.setResizable(false);

        //line of code adapted from https://stackoverflow.com/questions/4801386/how-do-i-add-an-image-to-a-jbutton
        pickUpCardBtn.setIcon(new ImageIcon(this.getClass().getResource("/images/blue_back.jpg")));

        //call event handlers
        PickUpCardEventHandler pickUpHandler = new PickUpCardEventHandler();
        backEventHandler exitHandler = new backEventHandler();


        windowForLives.setVisible(true);

        //add action listener to button
        pickUpCardBtn.addActionListener(pickUpHandler);
        exitBtn.addActionListener(exitHandler);



        //positioning buttons
        pickUpCardBtn.setSize(130, 200);
        pickUpCardBtn.setLocation(1350,270);

        exitBtn.setSize(60,30);
        exitBtn.setLocation(1440,1);

        player2Cards.setBounds(20,10,1500,210);
        playerCards.setBounds(20, 500, 1500, 210);
        stackOfCardsPnl.setBounds(600, 250, 130, 210);

        //add buttons and label to the JFrame
        windowForLives.add(pickUpCardBtn);
        windowForLives.add(exitBtn);
        windowForLives.add(player2Cards);
        windowForLives.add(playerCards);
        windowForLives.add(stackOfCardsPnl);
        windowForLives.setVisible(true);

        //Array of buttons for player 2
        player2CardBtns = new JButton[19];

    }//end of setUpGUI




    //method to generate cards
    public void generateCards(){
        cards = new ArrayList<Card>();

        //JB told me to throw in (this.getClass().getResource()), I think I would've figured it out even if he hadn't told me, his exact comment was "JB made some minor changes to this code to get it working"
        cards.add(new Card("Clubs", "Ace", true, new ImageIcon(this.getClass().getResource("/images/AC.jpg"))));
        cards.add(new Card("Clubs", "Two", true, new ImageIcon(this.getClass().getResource("/images/2C.jpg"))));
        cards.add(new Card("Clubs", "Three", true, new ImageIcon(this.getClass().getResource("/images/3C.jpg"))));
        cards.add(new Card("Clubs", "Four", true, new ImageIcon(this.getClass().getResource("/images/4C.jpg"))));
        cards.add(new Card("Clubs", "Five", true, new ImageIcon(this.getClass().getResource("/images/5C.jpg"))));
        cards.add(new Card("Clubs", "Six", true, new ImageIcon(this.getClass().getResource("/images/6C.jpg"))));
        cards.add(new Card("Clubs", "Seven", true, new ImageIcon(this.getClass().getResource("/images/7C.jpg"))));
        cards.add(new Card("Clubs", "Eight", true, new ImageIcon(this.getClass().getResource("/images/8C.jpg"))));
        cards.add(new Card("Clubs", "Nine", true, new ImageIcon(this.getClass().getResource("/images/9C.jpg"))));
        cards.add(new Card("Clubs", "Ten", true, new ImageIcon(this.getClass().getResource("/images/10C.jpg"))));
        cards.add(new Card("Clubs", "King", true, new ImageIcon(this.getClass().getResource("/images/KC.jpg"))));
        cards.add(new Card("Clubs", "Queen", true, new ImageIcon(this.getClass().getResource("/images/QC.jpg"))));
        cards.add(new Card("Clubs", "Jack", true, new ImageIcon(this.getClass().getResource("/images/JC.jpg"))));
        cards.add(new Card("Hearts", "Ace", true, new ImageIcon(this.getClass().getResource("/images/AH.jpg"))));
        cards.add(new Card("Hearts", "Two", true, new ImageIcon(this.getClass().getResource("/images/2H.jpg"))));
        cards.add(new Card("Hearts", "Three", true, new ImageIcon(this.getClass().getResource("/images/3H.jpg"))));
        cards.add(new Card("Hearts", "Four", true, new ImageIcon(this.getClass().getResource("/images/4H.jpg"))));
        cards.add(new Card("Hearts", "Five", true, new ImageIcon(this.getClass().getResource("/images/5H.jpg"))));
        cards.add(new Card("Hearts", "Six", true, new ImageIcon(this.getClass().getResource("/images/6H.jpg"))));
        cards.add(new Card("Hearts", "Seven", true, new ImageIcon(this.getClass().getResource("/images/7H.jpg"))));
        cards.add(new Card("Hearts", "Eight", true, new ImageIcon(this.getClass().getResource("/images/8H.jpg"))));
        cards.add(new Card("Hearts", "Nine", true, new ImageIcon(this.getClass().getResource("/images/9H.jpg"))));
        cards.add(new Card("Hearts", "Ten", true, new ImageIcon(this.getClass().getResource("/images/10H.jpg"))));
        cards.add(new Card("Hearts", "King", true, new ImageIcon(this.getClass().getResource("/images/KH.jpg"))));
        cards.add(new Card("Hearts", "Queen", true, new ImageIcon(this.getClass().getResource("/images/QH.jpg"))));
        cards.add(new Card("Hearts", "Jack", true, new ImageIcon(this.getClass().getResource("/images/JH.jpg"))));
        cards.add(new Card("Spades", "Ace", true, new ImageIcon(this.getClass().getResource("/images/AS.jpg"))));
        cards.add(new Card("Spades", "Two", true, new ImageIcon(this.getClass().getResource("/images/2S.jpg"))));
        cards.add(new Card("Spades", "Three", true, new ImageIcon(this.getClass().getResource("/images/3S.jpg"))));
        cards.add(new Card("Spades", "Four", true, new ImageIcon(this.getClass().getResource("/images/4S.jpg"))));
        cards.add(new Card("Spades", "Five", true, new ImageIcon(this.getClass().getResource("/images/5S.jpg"))));
        cards.add(new Card("Spades", "Six", true, new ImageIcon(this.getClass().getResource("/images/6S.jpg"))));
        cards.add(new Card("Spades", "Seven", true, new ImageIcon(this.getClass().getResource("/images/7S.jpg"))));
        cards.add(new Card("Spades", "Eight", true, new ImageIcon(this.getClass().getResource("/images/8S.jpg"))));
        cards.add(new Card("Spades", "Nine", true, new ImageIcon(this.getClass().getResource("/images/9S.jpg"))));
        cards.add(new Card("Spades", "Ten", true, new ImageIcon(this.getClass().getResource("/images/10S.jpg"))));
        cards.add(new Card("Spades", "King", true, new ImageIcon(this.getClass().getResource("/images/KS.jpg"))));
        cards.add(new Card("Spades", "Queen", true, new ImageIcon(this.getClass().getResource("/images/QS.jpg"))));
        cards.add(new Card("Spades", "Jack", true, new ImageIcon(this.getClass().getResource("/images/JS.jpg"))));
        cards.add(new Card("Diamonds", "Ace", true, new ImageIcon(this.getClass().getResource("/images/AD.jpg"))));
        cards.add(new Card("Diamonds", "Two", true, new ImageIcon(this.getClass().getResource("/images/2D.jpg"))));
        cards.add(new Card("Diamonds", "Three", true, new ImageIcon(this.getClass().getResource("/images/3D.jpg"))));
        cards.add(new Card("Diamonds", "Four", true, new ImageIcon(this.getClass().getResource("/images/4D.jpg"))));
        cards.add(new Card("Diamonds", "Five", true, new ImageIcon(this.getClass().getResource("/images/5D.jpg"))));
        cards.add(new Card("Diamonds", "Six", true, new ImageIcon(this.getClass().getResource("/images/6D.jpg"))));
        cards.add(new Card("Diamonds", "Seven", true, new ImageIcon(this.getClass().getResource("/images/7D.jpg"))));
        cards.add(new Card("Diamonds", "Eight", true, new ImageIcon(this.getClass().getResource("/images/8D.jpg"))));
        cards.add(new Card("Diamonds", "Nine", true, new ImageIcon(this.getClass().getResource("/images/9D.jpg"))));
        cards.add(new Card("Diamonds", "Ten", true, new ImageIcon(this.getClass().getResource("/images/10D.jpg"))));
        cards.add(new Card("Diamonds", "King", true, new ImageIcon(this.getClass().getResource("/images/KD.jpg"))));
        cards.add(new Card("Diamonds", "Queen", true, new ImageIcon(this.getClass().getResource("/images/QD.jpg"))));
        cards.add(new Card("Diamonds", "Jack", true, new ImageIcon(this.getClass().getResource("/images/JD.jpg"))));
    }//end of generateCards method

    //method to deal a card
    public Card dealACard(){
        Card card;
        int bound = 52;
        //random number generator
        Random r = new Random();
        int i = r.nextInt(bound);
        card = cards.get(i);
        card.setAvailable(false);

        //removes card i from deck so it's not called again
        cards.remove(i);
        bound--;

        if(bound > 0)
        {
            return card;
        }

        else
            return null;
    }//end of dealACard method

    public void generatePlayerCards(){
        playerCardBtns = new JButton[19];
        int xVal=10;
        for(int i=0; i < 7; i++)
        {

            //playerCardBtns[i] = new JButton((Icon) cards.get(i));
            //example pickUpCardBtn.setIcon(new ImageIcon(this.getClass().getResource("/images/blue_back.jpg")));
            playerCardBtns[i] = new JButton();
            playerCardBtns[i].setIcon(dealACard().getImage());
            //place button playerCards panel
            playerCards.add(playerCardBtns[i]);
            playerCardBtns[i].setBounds(xVal, 5, 130, 200);

            //moves the card to the right
            xVal+=70;
        }//end of for loop
    }//end of generatePlayerCards

    public void generatePlayer2Cards(){
        int xVal=10;

        for(int i=0; i < 7; i++)
        {


            //adds back of card image to player 2 cards
            player2CardBtns[i] = new JButton(new ImageIcon(this.getClass().getResource("/images/blue_back.jpg")));
            //place button playerCards panel

            //add player 2 cards to player2Cards panel
            player2Cards.add(player2CardBtns[i]);

            //sets position of player 2 cards
            player2CardBtns[i].setBounds(xVal, 5, 130, 200);

            //moves the card to the right
            xVal+=70;
        }//end of for loop
    }//end of generatePlayerCards

    //adds a card to stackOfCardsPnl
    public void cardOnStack(){
            /*cardForStackLbl.setIcon(dealACard().getImage());
         cardForStackLbl = new JButton();
        //place label on stackOfCardsPnl panel
        stackOfCardsPnl.add(cardForStackLbl);
        stackOfCardsPnl.setBounds(1,1,130,200);*/


        //playerCardBtns[i] = new JButton((Icon) cards.get(i));
        //example pickUpCardBtn.setIcon(new ImageIcon(this.getClass().getResource("/images/blue_back.jpg")));
        cardForStackLbl = new JLabel();
        cardForStackLbl.setIcon(dealACard().getImage());
        //place button playerCards panel
        playerCards.add(cardForStackLbl);
        cardForStackLbl.setBounds(5, 5, 130, 200);
    }//end of cardOnStack

    //method to deals a card


    //for player to place a card
    public Card playACard(Card placedCard, Card previousCard){
        //Card card=cards.get(32);


        //if card suit or color matches
        if(placedCard.getSuitOfCard() == previousCard.getSuitOfCard() || placedCard.getValueOfCard() == previousCard.getValueOfCard()){
            placedCard = previousCard;
        }
        else{
            JOptionPane.showMessageDialog(null, "This card can't be placed! Card must match the suit or value of the previous card", "Invalid move!", JOptionPane.ERROR_MESSAGE);
        }

    return placedCard;
    } //end of playACard method

    //adds Card object to button
    public void playerCardFunction(){

    }

    //write file
    public void saveInfo(ArrayList<Player> writePlayerInfo){
        try{
                f = new File("playerstats.dat");
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(writePlayerInfo);
                oos.close();
        }

        catch(FileNotFoundException e){
             JOptionPane.showMessageDialog(null,"Error! File not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null,"Error! IOException!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        }
    //read file
    public static ArrayList<Player> readInfo()
    {
        ArrayList<Player> readPlayerInfo = new ArrayList<>();

        try{
            File f= new File("playerstats.dat");
            FileInputStream fis = new FileInputStream(f);
            ObjectInput ois = new ObjectInputStream(fis);
            readPlayerInfo = (ArrayList<Player>) ois.readObject();
            ois.close();
        }

        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,"Error!!! Can't open file!", "Error", JOptionPane.WARNING_MESSAGE);

        }

        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null,"Error!!! Class not found", "Error", JOptionPane.WARNING_MESSAGE);

        }
        return readPlayerInfo;
    }//end of readInfo

    //method to check and enforce rules
    public void checkLivesRules(){
        Card currentCard = dealACard();
        JOptionPane.showMessageDialog(null, currentCard);
        if (currentCard == null){
            JOptionPane.showMessageDialog(null, "Out of cards! Game over!", "GameOver!", JOptionPane.WARNING_MESSAGE);
        }//end of if
        else{
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
                JOptionPane.showMessageDialog(null, "The next player must must pick up four cards" + currentCard.isAvailable());
            }

            else{
                JOptionPane.showMessageDialog(null, "Play as standard "+ currentCard.isAvailable());
            }
        }//end of else


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


}//end of LivesGUI
