import javax.swing.*;

/**
 * The type Card.
 */
public class Card {

    //creating variable for CardClass object
    private String suitOfCard;
    private String valueOfCard;
    private boolean available;
    private ImageIcon image;


    /**
     * Instantiates a new Card.
     *
     * @param suitOfCard  the suit of card
     * @param valueOfCard the value of card
     * @param available   the available
     * @param image       the image
     */
//constructor
    public Card(String suitOfCard, String valueOfCard, boolean available, ImageIcon image){
        setSuitOfCard(suitOfCard);
        setValueOfCard(valueOfCard);
        setAvailable(available);
        setImage(image);
    }

    /**
     * Gets suit of card.
     *
     * @return the suit of card
     */
//getters and setters
    public String getSuitOfCard() {
        return suitOfCard;
    }

    /**
     * Sets suit of card.
     *
     * @param suitOfCard the suit of card
     */
    public void setSuitOfCard(String suitOfCard) {
        this.suitOfCard = suitOfCard;
    }


    /**
     * Gets value of card.
     *
     * @return the value of card
     */
    public String getValueOfCard() {
        return valueOfCard;
    }

    /**
     * Sets value of card.
     *
     * @param valueOfCard the value of card
     */
    public void setValueOfCard(String valueOfCard) {
        this.valueOfCard = valueOfCard;
    }

    public String toString() {
        return "Your card is " + valueOfCard + " Of " + suitOfCard;
    }

    /**
     * Is available boolean.
     *
     * @return the boolean
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets available.
     *
     * @param available the available
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
