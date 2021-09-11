package yfathi.kafka.tennis.model;

public enum Score {

    SO("0"),
    S15("15"),
    S30("30"),
    S40("40");

    private String label;

     Score(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

}