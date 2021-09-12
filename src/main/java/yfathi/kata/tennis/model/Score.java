package yfathi.kata.tennis.model;

/**
 * The enum Score.
 */
public enum Score {

    /**
     * So score.
     */
    SO("0"),
    /**
     * S 15 score.
     */
    S15("15"),
    /**
     * S 30 score.
     */
    S30("30"),
    /**
     * S 40 score.
     */
    S40("40"),
    /**
     * Adv score.
     */
    ADV("Advantage"),
    /**
     * Gwin score.
     */
    GWIN("Game "),
    /**
     * The Swin.
     */
    SWIN("Set and Match");

    private String label;

     Score(String label) {
        this.label = label;
    }

    /**
     * Gets label.
     *
     * @return the label
     */
    public String getLabel() {
        return this.label;
    }

}