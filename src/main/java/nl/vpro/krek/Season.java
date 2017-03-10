package nl.vpro.krek;

import org.joda.time.DateTime;

//import java.time.LocalDateTime;
//import java.time.Month;

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
//        }
        }
    }

//    public static Season of(final LocalDateTime dateTime) {
//        Month month = dateTime.getMonth();
//        switch (month) {
//            case JANUARY:
//                return WINTER;
//            case FEBRUARY:
//                return WINTER;
//            case MARCH:
//                return dateTime.getDayOfMonth() < 21 ? WINTER: SPRING;
//            case APRIL:
//                return SPRING;
//            case MAY:
//                return SPRING;
//            case JUNE:
//                return dateTime.getDayOfMonth() < 21 ? SPRING : SUMMER;
//            case JULY:
//                return SUMMER;
//            case AUGUST:
//                return SUMMER;
//            case SEPTEMBER:
//                return dateTime.getDayOfMonth() < 21 ? SUMMER : FALL;
//            case OCTOBER:
//                return FALL;
//            case NOVEMBER:
//                return FALL;
//            case DECEMBER:
//                return dateTime.getDayOfMonth() < 21 ? FALL : WINTER;
//            default:
//                throw new IllegalArgumentException("Unknown month: " + month);
//        }
//    }
}
