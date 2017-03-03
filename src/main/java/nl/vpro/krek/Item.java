package nl.vpro.krek;

import lombok.Value;

@Value
public class Item {

    private Long id;

    private String author;

    private String title;

    private String text;

//    private String audioFile;

    private Filter filter;

//    private Season season;
}
