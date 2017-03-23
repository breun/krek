package nl.vpro.krek;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilterService {

    List<Filter> getAll();

    Filter getByName(String name);
}
