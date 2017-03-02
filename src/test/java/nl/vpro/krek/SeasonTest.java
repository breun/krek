package nl.vpro.krek;

import nl.vpro.krek.Season;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class SeasonTest {

    @Test
    public void spring() {
        test(Month.MARCH, 21, Season.SPRING);
        test(Month.APRIL, 1, Season.SPRING);
        test(Month.MAY, 1, Season.SPRING);
        test(Month.JUNE, 20, Season.SPRING);
    }

    @Test
    public void summer() {
        test(Month.JUNE, 21, Season.SUMMER);
        test(Month.JULY, 1, Season.SUMMER);
        test(Month.AUGUST, 1, Season.SUMMER);
        test(Month.SEPTEMBER, 20, Season.SUMMER);
    }

    @Test
    public void fall() {
        test(Month.SEPTEMBER, 21, Season.FALL);
        test(Month.OCTOBER, 1, Season.FALL);
        test(Month.NOVEMBER, 1, Season.FALL);
        test(Month.DECEMBER, 20, Season.FALL);
    }

    @Test
    public void winter() {
        test(Month.DECEMBER, 21, Season.WINTER);
        test(Month.JANUARY, 1, Season.WINTER);
        test(Month.FEBRUARY, 1, Season.WINTER);
        test(Month.MARCH, 20, Season.WINTER);
    }

    private void test(Month month, int dayOfMonth, Season season) {
        assertThat(Season.of(LocalDateTime.of(2017, month, dayOfMonth, 12, 0))).isEqualTo(season);
    }
}