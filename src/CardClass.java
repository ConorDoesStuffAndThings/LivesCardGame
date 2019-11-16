import javax.swing.*;

public class CardClass {
    private String suitOfCard;
    private String valueOfCard;
    private boolean available;
    private ImageIcon image;



    public CardClass(String suitOfCard, String valueOfCard, boolean available, ImageIcon image){
        setSuitOfCard(suitOfCard);
        setValueOfCard(valueOfCard);
        setAvailable(available);
        setImage(image);
    }

    public String getSuitOfCard() {
        return suitOfCard;
    }

    public void setSuitOfCard(String suitOfCard) {
        this.suitOfCard = suitOfCard;
    }


    public String getValueOfCard() {
        return valueOfCard;
    }

    public void setValueOfCard(String valueOfCard) {
        this.valueOfCard = valueOfCard;
    }

    public String toString() {
        return "Your card is " + valueOfCard + " Of " + suitOfCard;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
