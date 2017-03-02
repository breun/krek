package nl.vpro.krek;

import java.time.LocalDateTime;
import java.time.Month;

public enum Season {
    SPRING("lente"),
    SUMMER("zomer"),
    FALL("herfst"),
    WINTER("winter");

    private String name;

    Season(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    static public Season of(final LocalDateTime dateTime) {
        Month month = dateTime.getMonth();
        switch (month) {
            case JANUARY:
                return WINTER;
            case FEBRUARY:
                return WINTER;
            case MARCH:
                return dateTime.getDayOfMonth() < 21 ? WINTER: SPRING;
            case APRIL:
                return SPRING;
            case MAY:
                return SPRING;
            case JUNE:
                return dateTime.getDayOfMonth() < 21 ? SPRING : SUMMER;
            case JULY:
                return SUMMER;
            case AUGUST:
                return SUMMER;
            case SEPTEMBER:
                return dateTime.getDayOfMonth() < 21 ? SUMMER : FALL;
            case OCTOBER:
                return FALL;
            case NOVEMBER:
                return FALL;
            case DECEMBER:
                return dateTime.getDayOfMonth() < 21 ? FALL : WINTER;
            default:
                throw new IllegalArgumentException("Unknown month: " + month);
        }
    }
}
