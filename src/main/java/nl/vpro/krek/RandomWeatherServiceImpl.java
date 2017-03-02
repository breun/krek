package nl.vpro.krek;

import java.util.concurrent.ThreadLocalRandom;

public class RandomWeatherServiceImpl implements WeatherService {

    @Override
    public int getTemperatureInDegreesCelcius() {
        return ThreadLocalRandom.current().nextInt(-10, 35);
    }
}
