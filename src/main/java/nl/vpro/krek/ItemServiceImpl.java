package nl.vpro.krek;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;
import java.util.Random;
//import java.util.stream.Collectors;

public class ItemServiceImpl implements ItemService {

    private final List<Item> items;

    public ItemServiceImpl(final List<Item> items) {
        this.items = items;
    }

    @Override
    public Item getById(Long id) {
    //public Optional<Item> getById(Long id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
//        return items.stream()
//                .filter(item -> item.getId().equals(id))
//                .findFirst();
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
//        return items.stream()
//                .filter(item -> item.getFilter().equals(filter))
//                .collect(Collectors.toList());
    }

    @Override
    public Item getRandomByFilter(final Filter filter) {
    //public Optional<Item> getRandomByFilter(final Filter filter) {
        List<Item> items = getAllByFilter(filter);

        if (!items.isEmpty()) {
            return items.get(new Random().nextInt(items.size()));
            //return Optional.of(items.get(new Random().nextInt(items.size())));
        } else {
            return null;
            //return Optional.empty();
        }
    }
}
