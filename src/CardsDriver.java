import java.io.FileInputStream;
import java.io.FileNotFoundException;

//need http://www.javazoom.net/javalayer/sources.html to make work
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

class CardsDriver {
    public static void main(String args[]) {

        MainMenuGUI menuGUI = new MainMenuGUI();

        //code adapted from https://www.youtube.com/watch?v=oFs7FPpf5-w
        try {
            //song gotten from https://www.youtube.com/watch?v=R0RRuWnCWts
            //FileInputStream musicToBePlayed = new FileInputStream("//music/kevinweasel.mp3");
            FileInputStream musicToBePlayed = new FileInputStream("music/kevinweasel.mp3");

            //creates a new player object called "player"
            Player player = new Player(musicToBePlayed);

            //just for confirmation that the song is playing for when muted
            System.out.println("Song is playing...");

            //plays song
            player.play();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JavaLayerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//end of psvm
}