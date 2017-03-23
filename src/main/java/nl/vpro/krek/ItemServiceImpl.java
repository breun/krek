package nl.vpro.krek;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class ItemServiceImpl implements ItemService {

    private final List<Item> items;

    public ItemServiceImpl(final List<Item> items) {
        this.items = items;
    }

    @Override
    public Optional<Item> getById(Long id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Item> getAllByFilter(final Filter filter) {
        return items.stream()
                .filter(item -> item.getFilter().equals(filter))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Item> getRandomByFilter(final Filter filter) {
        List<Item> items = getAllByFilter(filter);

        if (!items.isEmpty()) {
            return Optional.of(items.get(new Random().nextInt(items.size())));
        } else {
            return Optional.empty();
        }
    }
}
