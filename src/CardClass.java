public class CardClass {
    private String suitOfCard;
    private String valueOfCard;
    private boolean available;



    public CardClass(String suitOfCard, String valueOfCard, boolean available){
        setSuitOfCard(suitOfCard);
        setValueOfCard(valueOfCard);
        setAvailable(available);
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
        return "Your card is " + valueOfCard + " Of" + suitOfCard;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

}
