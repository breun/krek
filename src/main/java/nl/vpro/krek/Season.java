package nl.vpro.krek;

import org.joda.time.DateTime;

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

    public static Season of (final DateTime dateTime) {
        int month = dateTime.getMonthOfYear();
        switch (month) {
            case 1:
                return WINTER;
            case 2:
                return WINTER;
            case 3:
                return dateTime.getDayOfMonth() < 21 ? WINTER: SPRING;
            case 4:
                return SPRING;
            case 5:
                return SPRING;
            case 6:
                return dateTime.getDayOfMonth() < 21 ? SPRING : SUMMER;
            case 7:
                return SUMMER;
            case 8:
                return SUMMER;
            case 9:
                return dateTime.getDayOfMonth() < 21 ? SUMMER : FALL;
            case 10:
                return FALL;
            case 11:
                return FALL;
            case 12:
                return dateTime.getDayOfMonth() < 21 ? FALL : WINTER;
            default:
                throw new IllegalArgumentException("Unknown month: " + month);
        }
    }

}
