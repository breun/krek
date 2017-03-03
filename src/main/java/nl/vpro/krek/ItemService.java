package nl.vpro.krek;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Optional<Item> getById(Long id);

    List<Item> getAllByFilter(Filter filter);

    Optional<Item> getRandomByFilter(Filter filter);
}
