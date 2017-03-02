package nl.vpro.krek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

@Controller
public class IndexController {

    private static final Locale LOCALE = new Locale("nl", "nl");

    private final WeatherService weatherService;

    private final LocationService locationService;

    @Autowired
    public IndexController(WeatherService weatherService, LocationService locationService) {
        this.weatherService = weatherService;
        this.locationService = locationService;
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        LocalDateTime now = LocalDateTime.now();

        model.addAttribute("weekdag", now.getDayOfWeek().getDisplayName(TextStyle.FULL, LOCALE));
        model.addAttribute("seizoen", Season.of(now).toString());
        model.addAttribute("temperatuur", weatherService.getTemperatureInDegreesCelcius());

        model.addAttribute("donker", darkness(now.getHour()));
        model.addAttribute("dagdeel", daypart(now.getHour()));
        model.addAttribute("rangtelwoord", rangtelwoord(now.getDayOfMonth()));
        model.addAttribute("maand", StringUtils.capitalize(now.getMonth().getDisplayName(TextStyle.FULL, LOCALE)));
        model.addAttribute("jaar", now.getYear());
        model.addAttribute("stad", locationService.getCity());

        return "index";
    }

    private String darkness(final int hour) {
        if (hour < 8) {
            return "nog donker";
        } else if (hour < 12) {
            return "al licht";
        } else if (hour < 18) {
            return "nog licht";
        } else {
            return "al donker";
        }
    }

    private String daypart(final int hour) {
        if (hour <= 3) {
            return "vroege nacht";
        } else if (hour <= 6) {
            return "late nacht";
        } else if (hour <= 9) {
            return "vroege ochtend";
        } else if (hour <= 12) {
            return "late ochtend";
        } else if (hour <= 15) {
            return "vroege middag";
        } else if (hour <= 18) {
            return "late middag";
        } else if (hour <= 21) {
            return "vroege avond";
        } else if (hour <= 24) {
            return "late avond";
        } else {
            throw new IllegalArgumentException("Unknow hour: " + hour);
        }
    }

    private String rangtelwoord(final int dayOfMonth) {
        switch (dayOfMonth) {
            case 1:
                return "eerste";
            case 2:
                return "tweede";
            case 3:
                return "derde";
            case 4:
                return "vierde";
            case 5:
                return "vijfde";
            case 6:
                return "zesde";
            case 7:
                return "zevende";
            case 8:
                return "achtste";
            case 9:
                return "negende";
            case 10:
                return "tiende";
            case 11:
                return "elfde";
            case 12:
                return "twaalfde";
            case 13:
                return "dertiende";
            case 14:
                return "veertiende";
            case 15:
                return "vijftiende";
            case 16:
                return "zestiende";
            case 17:
                return "zeventiende";
            case 18:
                return "achttiende";
            case 19:
                return "negentiende";
            case 20:
                return "twintigste";
            case 21:
                return "een en twintigste";
            case 22:
                return "twee en twintigste";
            case 23:
                return "drie en twintigste";
            case 24:
                return "vier en twingtigste";
            case 25:
                return "vijf en twintigste";
            case 26:
                return "zes en twintigste";
            case 27:
                return "zeven en twintigste";
            case 28:
                return "acht en twintigste";
            case 29:
                return "negen en twintigste";
            case 30:
                return "dertigste";
            case 31:
                return "een en dertigste";
            default:
                throw new IllegalArgumentException("Unknown day of month: " + dayOfMonth);
        }
    }
}