public class CardConstructor {
    private String suitOfCard;
    private String cardColour;
    private int valueOfCard;

    public CardConstructor(String suitOfCard, String cardColour, int valueOfCard){
        setCardColour(cardColour);
        setSuitOfCard(suitOfCard);
        setValueOfCard(valueOfCard);
    }

    public String getSuitOfCard() {
        return suitOfCard;
    }

    public void setSuitOfCard(String suitOfCard) {
        this.suitOfCard = suitOfCard;
    }

    public String getCardColour() {
        return cardColour;
    }

    public void setCardColour(String cardColour) {
        this.cardColour = cardColour;
    }

    public int getValueOfCard() {
        return valueOfCard;
    }

    public void setValueOfCard(int valueOfCard) {
        this.valueOfCard = valueOfCard;
    }

    public String toString() {
        return "Your card is " + cardColour + suitOfCard + valueOfCard;
    }
}
