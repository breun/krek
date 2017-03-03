package nl.vpro.krek;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

    private final FilterService filterService;

    private final ItemService itemService;

    public ItemController(final FilterService filterService, final ItemService itemService) {
        this.filterService = filterService;
        this.itemService = itemService;
    }

    @GetMapping(value = "/item/{id}")
    public String item(@PathVariable("id") final Long id, Model model) {
        Item item = itemService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("No item for id " + id));
        Filter filter = item.getFilter();
        model.addAttribute("titel", item.getTitle());
        model.addAttribute("auteur", item.getAuthor());
        model.addAttribute("tekst", item.getText());
        model.addAttribute("filter", filter);
        return "item";
    }

    @GetMapping(value = "/item")
    public String choose(@RequestParam("filter") String filterName) {
        Filter filter = filterService.getByName(filterName)
                .orElseThrow(() -> new IllegalArgumentException("Unknown filter: " + filterName));
        Item item = itemService.getRandomByFilter(filter)
                .orElseThrow(() -> new IllegalArgumentException("No items for filter: " + filter));
        Long id = item.getId();
        return "redirect:/item/" + id;
    }
}
