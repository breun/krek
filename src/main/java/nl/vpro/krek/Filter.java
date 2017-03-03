package nl.vpro.krek;

import java.awt.*;
import java.util.Arrays;
import java.util.Optional;

public enum Filter {

    HADEWYCH("Hadewych", new Color(1, 1, 1)),
    FRITS("Frits", new Color(10, 10, 10)),
    WINSTON("Winston", new Color(20, 20, 20)),
    MAARTEN("Maarten", new Color(40, 40, 40)),
    JOE("Joe", new Color(60, 60, 60)),
    OLLIE("Ollie", new Color(80, 80, 80)),
    MAX("Max", new Color(100, 100, 100)),
    PHILEINE("Phileine", new Color(120, 120, 120));

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
