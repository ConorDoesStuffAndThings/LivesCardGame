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
import javax.swing.JScrollPane;

public class LivesGUI extends JFrame implements LivesIn{
    JButton pickUpCardBtn;
    JButton exitBtn;
    JButton[] playerCardBtns;
    JLabel player2Cards;
    JFrame windowForLives;
    JPanel playerCards;
    JPanel stackOfCards;
    ArrayList<Card> cards;
    ArrayList<Player> playerInfo;

    public LivesGUI() {
        generateCards();

        //setting up window
        windowForLives = new JFrame("Lives");
        windowForLives.setLayout(null);
        windowForLives.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowForLives.setSize(1550,830);
        pickUpCardBtn = new JButton("");
        exitBtn = new JButton("Exit");
        player2Cards = new JLabel(new ImageIcon(this.getClass().getResource("/images/back_cards.png")));
        playerCards = new JPanel();
        playerCards.setLayout(null);
        //playerCards.setLayout(new GridLayout (1,1));
        //playerCards.setLayout(new BoxLayout().createHorizontalBox();

       // playerCards.setLayout(new BoxLayout(playerCards,BoxLayout.LINE_AXIS));

        playerCards.setBackground(Color.ORANGE);
        stackOfCards = new JPanel();
        stackOfCards.setLayout(new GridLayout(1,1 ));
        stackOfCards.setBackground(Color.GREEN);

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
        pickUpCardBtn.setLocation(1300,170);

        exitBtn.setSize(60,30);
        exitBtn.setLocation(1440,1);

        player2Cards.setBounds(320,10,720,300);
        playerCards.setBounds(20, 500, 1500, 320);
        stackOfCards.setBounds(300, 300, 192, 300);

        //add buttons and label to the JFrame
        windowForLives.add(pickUpCardBtn);
        windowForLives.add(exitBtn);
        windowForLives.add(player2Cards);
        windowForLives.add(playerCards);
        windowForLives.add(stackOfCards);
        windowForLives.setVisible(true);


        //make into array

        playerCardBtns = new JButton[19];

        //default xVal for button
        int xVal=10;

        for(int i=0; i < playerCardBtns.length; i++)
        {


            //playerCardBtns[i] = new JButton((Icon) cards.get(i));
            playerCardBtns[i] = new JButton(cards.get(i).getImage());
            //place button playerCards panel
            playerCards.add(playerCardBtns[i]);
            playerCardBtns[i].setBounds(xVal, 5, 196, 300);

            //moves the card to the right
            xVal+=70;
        }
        //setting cards

        /*
        cardOne = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\3D.png"));
        cardTwo = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\3H.png"));
        cardThree = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\2C.png"));
        cardFour = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\6C.png"));
        cardFive = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\KC.png"));
        cardSix = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\QC.png"));
        cardSeven = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\8H.png"));
        cardEight = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\9D.png"));
        cardNine = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\9H.png"));
        cardTen = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\AD.png"));
        cardEleven = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\AS.png"));
        cardTwelve = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\QC.png"));
        cardThirteen = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\QS.png"));
        cardFourteen = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\KC.png"));
        cardFifthteen = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\10S.png"));
        cardSixteen = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\10C.png"));
        cardSeventeen = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\AC.png"));
        cardEighteen = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\AD.png"));
        cardNineteen = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\9S.png"));
        cardTweenty = new JButton(new ImageIcon("C:\\Users\\t00205418\\IdeaProjects\\LivesCardGame\\src\\images\\10D.png"));
        */
        //add button for card to JPanel


        //place players cards on panel (playerCards) and make them buttons that change value when player picks up new card

    }
    //outer for loop going through suits
    //inner for loop going through types

    //method to generate cards
    public void generateCards(){
        cards = new ArrayList<Card>();
        cards.add(new Card("Clubs", "Ace", true, new ImageIcon("/images/AC.png")));
        cards.add(new Card("Clubs", "Two", true, new ImageIcon("/images/2C.png")));
        cards.add(new Card("Clubs", "Three", true, new ImageIcon("/images/3C.png")));
        cards.add(new Card("Clubs", "Four", true, new ImageIcon("/images/4C.png")));
        cards.add(new Card("Clubs", "Five", true, new ImageIcon("/images/5C.png")));
        cards.add(new Card("Clubs", "Six", true, new ImageIcon("/images/6C.png")));
        cards.add(new Card("Clubs", "Seven", true, new ImageIcon("/images/7C.png")));
        cards.add(new Card("Clubs", "Eight", true, new ImageIcon("/images/8C.png")));
        cards.add(new Card("Clubs", "Nine", true, new ImageIcon("/images/9C.png")));
        cards.add(new Card("Clubs", "Ten", true, new ImageIcon("/images/10C.png")));
        cards.add(new Card("Clubs", "King", true, new ImageIcon("/images/KC.png")));
        cards.add(new Card("Clubs", "Queen", true, new ImageIcon("/images/QC.png")));
        cards.add(new Card("Clubs", "Jack", true, new ImageIcon("/images/JC.png")));
        cards.add(new Card("Hearts", "Ace", true, new ImageIcon("/images/AH.png")));
        cards.add(new Card("Hearts", "Two", true, new ImageIcon("/images/2H.png")));
        cards.add(new Card("Hearts", "Three", true, new ImageIcon("/images/3H.png")));
        cards.add(new Card("Hearts", "Four", true, new ImageIcon("/images/4H.png")));
        cards.add(new Card("Hearts", "Five", true, new ImageIcon("/images/5H.png")));
        cards.add(new Card("Hearts", "Six", true, new ImageIcon("/images/6H.png")));
        cards.add(new Card("Hearts", "Seven", true, new ImageIcon("/images/7H.png")));
        cards.add(new Card("Hearts", "Eight", true, new ImageIcon("/images/8H.png")));
        cards.add(new Card("Hearts", "Nine", true, new ImageIcon("/images/9H.png")));
        cards.add(new Card("Hearts", "Ten", true, new ImageIcon("/images/10H.png")));
        cards.add(new Card("Hearts", "King", true, new ImageIcon("/images/KH.png")));
        cards.add(new Card("Hearts", "Queen", true, new ImageIcon("/images/QH.png")));
        cards.add(new Card("Hearts", "Jack", true, new ImageIcon("/images/JH.png")));
        cards.add(new Card("Spades", "Ace", true, new ImageIcon("/images/AS.png")));
        cards.add(new Card("Spades", "Two", true, new ImageIcon("/images/2S.png")));
        cards.add(new Card("Spades", "Three", true, new ImageIcon("/images/3S.png")));
        cards.add(new Card("Spades", "Four", true, new ImageIcon("/images/4S.png")));
        cards.add(new Card("Spades", "Five", true, new ImageIcon("/images/5S.png")));
        cards.add(new Card("Spades", "Six", true, new ImageIcon("/images/6S.png")));
        cards.add(new Card("Spades", "Seven", true, new ImageIcon("/images/7S.png")));
        cards.add(new Card("Spades", "Eight", true, new ImageIcon("/images/8S.png")));
        cards.add(new Card("Spades", "Nine", true, new ImageIcon("/images/9S.png")));
        cards.add(new Card("Spades", "Ten", true, new ImageIcon("/images/10S.png")));
        cards.add(new Card("Spades", "King", true, new ImageIcon("/images/KS.png")));
        cards.add(new Card("Spades", "Queen", true, new ImageIcon("/images/QS.png")));
        cards.add(new Card("Spades", "Jack", true, new ImageIcon("/images/JS.png")));
        cards.add(new Card("Diamonds", "Ace", true, new ImageIcon("/images/AD.png")));
        cards.add(new Card("Diamonds", "Two", true, new ImageIcon("/images/2D.png")));
        cards.add(new Card("Diamonds", "Three", true, new ImageIcon("/images/3D.png")));
        cards.add(new Card("Diamonds", "Four", true, new ImageIcon("/images/4D.png")));
        cards.add(new Card("Diamonds", "Five", true, new ImageIcon("/images/5D.png")));
        cards.add(new Card("Diamonds", "Six", true, new ImageIcon("/images/6D.png")));
        cards.add(new Card("Diamonds", "Seven", true, new ImageIcon("/images/7D.png")));
        cards.add(new Card("Diamonds", "Eight", true, new ImageIcon("/images/8D.png")));
        cards.add(new Card("Diamonds", "Nine", true, new ImageIcon("/images/9D.png")));
        cards.add(new Card("Diamonds", "Ten", true, new ImageIcon("/images/10D.png")));
        cards.add(new Card("Diamonds", "King", true, new ImageIcon("/images/KD.png")));
        cards.add(new Card("Diamonds", "Queen", true, new ImageIcon("/images/QD.png")));
        cards.add(new Card("Diamonds", "Jack", true, new ImageIcon("/images/JD.png")));
    }//end of generateCards method


    //method to deals a card
    public Card dealACard(){
        Card card;
        Random r = new Random();
        int i = r.nextInt(52);
        card = cards.get(i);
        card.setAvailable(false);
        return card;
    }//end of dealACard method

    //for player to place a card
    public Card playACard(Card placedCard, Card previousCard){
        //Card card=cards.get(32);


        //if card suit or color matches
        if(placedCard.getSuitOfCard() == previousCard.getSuitOfCard() || placedCard.getValueOfCard() == previousCard.getValueOfCard()){
            placedCard = previousCard;
        }
        else{
            JOptionPane.showMessageDialog(null, "This card can't be placed! Card must match the suit or number of the previous card", "Invalid move!", JOptionPane.ERROR_MESSAGE);
        }

    return placedCard;
    } //end of playACard method

    //write file
    public static void saveInfo(ArrayList<Player> playerInfo){
        try{
                File f = new File("playerstats.dat");
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(playerInfo);
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
    public static ArrayList<Player> statisticsWinLose()
    {
        ArrayList<Player> playerInfo = new ArrayList<>();

        try{
            File f= new File("playerstats.dat");
            FileInputStream fis = new FileInputStream(f);
            ObjectInput ois = new ObjectInputStream(fis);
            playerInfo = (ArrayList<Player>) ois.readObject();
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
        return playerInfo;
    }//end of statisticsWinLose

    //method to check and enforce rules
    public void checkLivesRules(){
        Card currentCard = dealACard();
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
            JOptionPane.showMessageDialog(null, "The next player must must pick up four cards" + currentCard.isAvailable());
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
