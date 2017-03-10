package nl.vpro.krek;

import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;

@Service
public interface FilterService {

    List<Filter> getAll();

    Filter getByName(String name);
    //Optional<Filter> getByName(String name);
}
