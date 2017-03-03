package nl.vpro.krek;

import lombok.Value;

@Value
public class Item {

    private Long id;

    private String author;

    private String title;

    private String callToAction;

    private Filter filter;



//    private Season season;
}
