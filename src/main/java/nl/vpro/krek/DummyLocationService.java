package nl.vpro.krek;

public class DummyLocationService implements LocationService {

    private final String city;

    public DummyLocationService(final String city) {
        this.city = city;
    }

    @Override
    public String getCity() {
        return city;
    }
}
