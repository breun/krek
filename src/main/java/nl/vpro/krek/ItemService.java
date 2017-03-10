package nl.vpro.krek;

import java.util.List;
//import java.util.Optional;

public interface ItemService {

    Item getById(Long id);
    //Optional<Item> getById(Long id);

    List<Item> getAllByFilter(Filter filter);

    Item getRandomByFilter(Filter filter);
    //Optional<Item> getRandomByFilter(Filter filter);
}
