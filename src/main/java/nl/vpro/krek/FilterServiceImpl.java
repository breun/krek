package nl.vpro.krek;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class FilterServiceImpl implements FilterService {

    private final List<Filter> filters;

    public FilterServiceImpl(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public List<Filter> getAll() {
        return filters;
    }

    @Override
    public Optional<Filter> getByName(final String name) {
        return filters.stream()
                .filter(filter -> filter.getName().equals(name))
                .findFirst();
    }
}
