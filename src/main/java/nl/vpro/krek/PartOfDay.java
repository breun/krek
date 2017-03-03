package nl.vpro.krek;

public enum PartOfDay {

    EARLY_MORNING("vroege morgen"),
    LATE_MORNING("late morgen"),
    EARLY_AFTERNOON("vroege middag"),
    LATE_AFTERNOON("late middag"),
    EARLY_EVENING("vroege avond"),
    LATE_EVENING("late avond"),
    EARLY_NIGHT("vroege nacht"),
    LATE_NIGHT("late nacht");

    private String text;

    PartOfDay(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
