package nl.vpro.krek;

public class DummyLocationService implements LocationService {

    @Override
    public String getCity() {
        return "Eindhoven";
    }
}
