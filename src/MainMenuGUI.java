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
        mainMenuWindow.setSize(1000, 1000);
        JButton playButton = new JButton("Play");
        JButton statButton = new JButton("Statistics");
        JLabel exitButton = new JLabel("Exit");

        mainMenuWindow.setVisible(true);

        playButton.setBounds(50, 50, 100,100);
        mainMenuWindow.add(playButton);
        mainMenuWindow.add(statButton);
        mainMenuWindow.add(exitButton);

        playButton.addActionListener(new playEventHandler());

    }

    private class playEventHandler implements ActionListener {

        public void actionPerformed(ActionEvent e)
        {
            new Cards();
        }
    }// end of PickUpCardEventHandler


}
