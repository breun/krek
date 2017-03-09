package nl.vpro.krek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class KrekApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(KrekApplication.class);
    }

    public static void main(String[] args) {
		SpringApplication.run(KrekApplication.class, args);
	}

	@Bean
    public FilterService filterService() {
	    return new FilterServiceImpl(data().getFilters());
    }

    @Bean
    public ItemService itemService() {
	    return new ItemServiceImpl(data().getItems());
    }

	@Bean
	public WeatherService weatherService() {
		return new RandomWeatherServiceImpl();
	}

	@Bean
    public LocationService locationService() {
	    return new DummyLocationService("Eindhoven"); // TODO: Use an actual Geo-IP lookup service
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(new Locale("nl", "nl"));
        return sessionLocaleResolver;
    }

    @Bean
    public Data data() {
        return new Data();
    }
}
