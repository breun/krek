package nl.vpro.krek;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemServiceImpl implements ItemService {

    private final List<Item> items;

    public ItemServiceImpl(final List<Item> items) {
        this.items = items;
    }

    @Override
    public Item getById(Long id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Item> getAllByFilter(final Filter filter) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getFilter().equals(filter)) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public Item getRandomByFilter(final Filter filter) {
        List<Item> items = getAllByFilter(filter);

        if (!items.isEmpty()) {
            return items.get(new Random().nextInt(items.size()));
        } else {
            return null;
        }
    }
}
