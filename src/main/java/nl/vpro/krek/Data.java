package nl.vpro.krek;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Data {

    private final List<Filter> filters;

    private final List<Item> items;

    public Data() {
        Filter filterHadewych = new Filter("Hadewych", Color.decode("#1A203C"));
        Filter filterFrits = new Filter("Frits", Color.decode("#739DD3"));
        Filter filterWinston = new Filter("Winston", Color.decode("#2C5AA5"));
        Filter filterMaarten = new Filter("Maarten", Color.decode("#6BA753"));
        Filter filterJoe = new Filter("Joe", Color.decode("#A54F79"));
        Filter filterOllie = new Filter("Ollie", Color.decode("#F1E639"));
        Filter filterMax = new Filter("Max", Color.decode("#1A203C"));
        Filter filterPhileine = new Filter("Phileine", Color.decode("#1A203C"));

        filters = Arrays.asList(filterHadewych, filterFrits, filterWinston, filterMaarten, filterJoe, filterOllie, filterMax, filterPhileine);

        items = Arrays.asList(
                new Item(1L, "Pietje Puk", "De titel van Pietje Puk", "De tekst van Pietje Puk", filterFrits),
                new Item(2L, "Maria Magdalena", "De titel van Maria Magdalena", "De tekst van Maria Magdalena", filterHadewych)
        );
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public List<Item> getItems() {
        return items;
    }
}
