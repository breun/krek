package nl.vpro.krek;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.*;

@Controller
public class ItemController {

    private final ItemService itemService;

    public ItemController(final ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "/item/{id}")
    public String index(@PathVariable("id") final Long id, Model model) {
        Item item = itemService.getById(id).orElseThrow(() -> new IllegalArgumentException("No item for id " + id));
        Filter filter = item.getFilter();
        model.addAttribute("titel", item.getTitle());
        model.addAttribute("auteur", item.getAuthor());
        model.addAttribute("tekst", item.getText());
        model.addAttribute("filter_naam", filter.getName());
        model.addAttribute("filter_kleur", toHex(filter.getColor()));
        return "item";
    }

    private String toHex(final Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }
}
