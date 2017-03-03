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
        Filter filterMax = new Filter("Max", Color.decode("#F3982C"));
        Filter filterPhileine = new Filter("Phileine", Color.decode("#E4232B"));

        filters = Arrays.asList(filterHadewych, filterFrits, filterWinston, filterMaarten, filterJoe, filterOllie, filterMax, filterPhileine);

        items = Arrays.asList(
                new Item(1L, "Peter Verhelst", "Vandaag zie je er...", "Uit: <em>Wij totale vlam</em>, 2014, ISBN 9789044625202", filterOllie),
                new Item(2L, "Charlotte van den Broek", "Stierenkop", "Uit: <em>Kameleon</em>, 2015, ISBN 9789029538435", filterWinston),
                new Item(3L, "Dennis Gaens", "Het is een beter verhaal als Otto het vertelt", "Van deze auteur: <em>Schering en inslag</em>, 2013, ISBN 9789461641755", filterHadewych),
                new Item(4L, "Lowie van Oers", "Turing", "Uit: <em>Turing</em>, 2016, ISBN 9789079571406", filterPhileine),
                new Item(5L, "Niels 't Hooft", "Hou me vast of ik hyperventileer", "Van deze auteur: <em>De verdwijners</em>, 2013, ISBN 9789045023212", filterMaarten),
                new Item(6L, "Maud Vanhauwaert", "Bang", "Van deze auteur: <em>Wij zijn evenwijdig</em>, 2014, ISBN 9789021457055", filterJoe),
                new Item(7L, "Maartje Smits", "Eenkamernotaties", "Uit: <em>Als je een meisje bent</em>, 2016, ISBN 9789076174679", filterFrits),
                new Item(8L, "Helena Hoogenkamp", "Als kind wilde ik iemand redden", "Van deze auteur: <em>Kleine zeemeermin, per ongeluk dood</em>, 2015, ISBN 9789079571376", filterMax)
        );
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public List<Item> getItems() {
        return items;
    }
}
