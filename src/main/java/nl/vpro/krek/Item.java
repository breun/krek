package nl.vpro.krek;

import lombok.Value;
import nl.vpro.krek.Filter;

import java.util.Set;

@Value
public class Item {

    private Set<Filter> filters;

    private String text;
}
