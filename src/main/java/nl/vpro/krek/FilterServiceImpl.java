package nl.vpro.krek;

import java.util.List;

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
    public Filter getByName(final String name) {
        for (Filter filter : filters) {
            if (filter.getName().equals(name)) {
                return filter;
            }
        }
        return null;
    }
}
