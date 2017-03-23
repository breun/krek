package nl.vpro.krek;

import java.util.List;

public interface ItemService {

    Item getById(Long id);

    List<Item> getAllByFilter(Filter filter);

    Item getRandomByFilter(Filter filter);
}
