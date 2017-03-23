package nl.vpro.krek;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeasonTest {

    @Test
    public void spring() {
        test(3, 21, Season.SPRING);
        test(4, 1, Season.SPRING);
        test(5, 1, Season.SPRING);
        test(6, 20, Season.SPRING);
    }

    @Test
    public void summer() {
        test(6, 21, Season.SUMMER);
        test(7, 1, Season.SUMMER);
        test(8, 1, Season.SUMMER);
        test(9, 20, Season.SUMMER);
    }

    @Test
    public void fall() {
        test(9, 21, Season.FALL);
        test(10, 1, Season.FALL);
        test(11, 1, Season.FALL);
        test(12, 20, Season.FALL);
    }

    @Test
    public void winter() {
        test(12, 21, Season.WINTER);
        test(1, 1, Season.WINTER);
        test(2, 1, Season.WINTER);
        test(3, 20, Season.WINTER);
    }

    private void test(int month, int dayOfMonth, Season season) {
        assertThat(Season.of(new DateTime(2017, month, dayOfMonth, 12, 0))).isEqualTo(season);
    }
}