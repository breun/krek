package nl.vpro.krek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class KrekApplication {

	public static void main(String[] args) {
		SpringApplication.run(KrekApplication.class, args);
	}

	@Bean
	public WeatherService weatherService() {
		return new RandomWeatherServiceImpl();
	}

	@Bean
    public LocationService locationService() {
	    return new DummyLocationService();
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(new Locale("nl", "nl"));
        return sessionLocaleResolver;
    }
}
