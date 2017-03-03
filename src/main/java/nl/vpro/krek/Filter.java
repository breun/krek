package nl.vpro.krek;

import java.awt.*;
import java.util.Arrays;
import java.util.Optional;

public enum Filter {

    HADEWYCH("Hadewych", Color.decode("#1A203C")),
    FRITS("Frits", Color.decode("#739DD3")),
    WINSTON("Winston", Color.decode("#2C5AA5")),
    MAARTEN("Maarten", Color.decode("#6BA753")),
    JOE("Joe", Color.decode("#A54F79")),
    OLLIE("Ollie", Color.decode("#F1E639")),
    MAX("Max", Color.decode("#F3982C")),
    PHILEINE("Phileine", Color.decode("#E4232B"));

    private String name;
    private Color color;

    Filter(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    static Optional<Filter> byName(String name) {
        return Arrays.stream(values())
                .filter(filter -> filter.name.equals(name))
                .findFirst();
    }
}
