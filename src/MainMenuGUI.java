

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The type Main menu gui.
 */
public class MainMenuGUI {
    /**
     * The Play button.
     */
    JButton playButton;
    /**
     * The Stat button.
     */
    JButton statButton;
    /**
     * The Exit button.
     */
    JButton exitButton;
    /**
     * The Main menu window.
     */
    JFrame mainMenuWindow;
    /**
     * The Lives gui.
     */
    LivesGUI livesGUI;

    /**
     * The Cards 52.
     */
    Card[] cards52 = new Card[52];

    /**
     * Instantiates a new Main menu gui.
     */
    public MainMenuGUI(){
        mainMenuWindow = new JFrame("Main Menu - Lives");
        mainMenuWindow.setLayout(null);
        mainMenuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuWindow.setSize(250, 500);
        mainMenuWindow.setLocation(900,200);
        mainMenuWindow.setResizable(false);

        //create buttons
        playButton = new JButton("Play");
        statButton = new JButton("Statistics");
        exitButton = new JButton("Exit");

        mainMenuWindow.setVisible(true);

        //place and set button size
        playButton.setBounds(50, 100, 100,50);
        statButton.setBounds(50, 200, 100,50);
        exitButton.setBounds(50, 300, 100,50);

        //add buttons
        mainMenuWindow.add(playButton);
        mainMenuWindow.add(statButton);
        mainMenuWindow.add(exitButton);

        playButton.addActionListener(new playEventHandler());
        exitButton.addActionListener(new ExitGameHandler());
        statButton.addActionListener(new statEventHandler());


    }

    private class playEventHandler implements ActionListener {

        public void actionPerformed(ActionEvent e)
        {
            livesGUI = new LivesGUI();
            mainMenuWindow.setVisible(false);
        }
    }// end of PickUpCardEventHandler

    private class statEventHandler implements ActionListener {

        public void actionPerformed(ActionEvent e)
        {

            //got help from Ryan Madigan (3rd year Games Development)
            ArrayList<Player> playerDetails =  livesGUI.readInfo();

            JTextArea playerInfo = new JTextArea();
            playerInfo.setText("All Player Stats");

            if(playerDetails.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"No stats to display");
            }
            else
            {
                for (int i = 0; i < playerDetails.size(); i++)
                {
                    playerInfo.append(playerDetails.get(i).toString());
                }

                JOptionPane.showMessageDialog(null,playerInfo,"Stats",JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }// end of statEventHandler

    private class ExitGameHandler implements ActionListener{

        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }//end of ExitGameHandler

}
