package yfathi.kafka.tennis.model;

public enum Outcome {
    WIN("Game Win");
    private String label;

    Outcome(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
