package nl.vpro.krek;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomWeatherServiceImpl implements WeatherService {

    @Override
    public int getTemperatureInDegreesCelcius() {
        return ThreadLocalRandom.current().nextInt(-10, 35);
    }
}
