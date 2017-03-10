package nl.vpro.krek;

import org.joda.time.DateTime;
import org.junit.Test;

//import java.time.LocalDateTime;
//import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class SeasonTest {

    @Test
    public void spring() {
        test(3, 21, Season.SPRING);
        test(4, 1, Season.SPRING);
        test(5, 1, Season.SPRING);
        test(6, 20, Season.SPRING);
//        test(Month.MARCH, 21, Season.SPRING);
//        test(Month.APRIL, 1, Season.SPRING);
//        test(Month.MAY, 1, Season.SPRING);
//        test(Month.JUNE, 20, Season.SPRING);
    }

    @Test
    public void summer() {
        test(6, 21, Season.SUMMER);
        test(7, 1, Season.SUMMER);
        test(8, 1, Season.SUMMER);
        test(9, 20, Season.SUMMER);
//        test(Month.JUNE, 21, Season.SUMMER);
//        test(Month.JULY, 1, Season.SUMMER);
//        test(Month.AUGUST, 1, Season.SUMMER);
//        test(Month.SEPTEMBER, 20, Season.SUMMER);
    }

    @Test
    public void fall() {
        test(9, 21, Season.FALL);
        test(10, 1, Season.FALL);
        test(11, 1, Season.FALL);
        test(12, 20, Season.FALL);
//        test(Month.SEPTEMBER, 21, Season.FALL);
//        test(Month.OCTOBER, 1, Season.FALL);
//        test(Month.NOVEMBER, 1, Season.FALL);
//        test(Month.DECEMBER, 20, Season.FALL);
    }

    @Test
    public void winter() {
        test(12, 21, Season.WINTER);
        test(1, 1, Season.WINTER);
        test(2, 1, Season.WINTER);
        test(3, 20, Season.WINTER);
//        test(Month.DECEMBER, 21, Season.WINTER);
//        test(Month.JANUARY, 1, Season.WINTER);
//        test(Month.FEBRUARY, 1, Season.WINTER);
//        test(Month.MARCH, 20, Season.WINTER);
    }

    private void test(int month, int dayOfMonth, Season season) {
    //private void test(Month month, int dayOfMonth, Season season) {
        //assertThat(Season.of(LocalDateTime.of(2017, month, dayOfMonth, 12, 0))).isEqualTo(season);
        assertThat(Season.of(new DateTime(2017, month, dayOfMonth, 12, 0))).isEqualTo(season);
    }
}