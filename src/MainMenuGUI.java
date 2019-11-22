import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI {
    JButton playButton;
    JButton statButton;
    JButton exitButton;
    JFrame mainMenuWindow;
    CardClass[] cards52 = new CardClass[52];
    public MainMenuGUI(){
        mainMenuWindow = new JFrame("Main Menu - Lives");
        mainMenuWindow.setLayout(null);
        mainMenuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuWindow.setSize(250, 500);
        mainMenuWindow.setLocation(900,200);
        mainMenuWindow.setResizable(false);

        //create buttons
        JButton playButton = new JButton("Play");
        JButton statButton = new JButton("Statistics");
        JButton exitButton = new JButton("Exit");

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


    }

    private class playEventHandler implements ActionListener {

        public void actionPerformed(ActionEvent e)
        {
            new Cards();
            mainMenuWindow.setVisible(false);
        }
    }// end of PickUpCardEventHandler

    private class ExitGameHandler implements ActionListener{

        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }//end of ExitGameHandler

}
