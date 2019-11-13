public class CardConstructor {
    private String suitOfCard;
    private String valueOfCard;

    public CardConstructor(String suitOfCard, String valueOfCard){
        setSuitOfCard(suitOfCard);
        setValueOfCard(valueOfCard);
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
}
