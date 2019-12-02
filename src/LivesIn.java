import javax.swing.*;

/**
 * The interface Lives in.
 */
public interface LivesIn {
    /**
     * Generate cards.
     */
    void generateCards();

    /**
     * Deal a card card.
     *
     * @return the card
     */
    Card dealACard();

    /**
     * Check lives rules.
     */
    void checkLivesRules();
}//end of LivesIn

