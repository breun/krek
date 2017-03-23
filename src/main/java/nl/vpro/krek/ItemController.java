package nl.vpro.krek;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Slf4j
@Controller
public class ItemController {

    private final FilterService filterService;

    private final ItemService itemService;

    private final ResourceLoader resourceLoader;

    public ItemController(final FilterService filterService, final ItemService itemService, final ResourceLoader resourceLoader) {
        this.filterService = filterService;
        this.itemService = itemService;
        this.resourceLoader = resourceLoader;
    }

    @GetMapping(value = "/item/{id}")
    public String item(@PathVariable("id") final Long id, Model model) {
        Item item = itemService.getById(id);
        if (item == null) {
            throw new IllegalArgumentException("No item for id " + id);
        }

        Filter filter = item.getFilter();
        model.addAttribute("titel", item.getTitle());
        model.addAttribute("auteur", item.getAuthor());
        model.addAttribute("tekst", textForItem(item.getId()));
        model.addAttribute("audioLink", linkForAudio(item.getId()));
        model.addAttribute("filter", filter);
        model.addAttribute("oproepTotActie", item.getCallToAction());
        return "item";
    }

    @GetMapping(value = "/item")
    public String choose(@RequestParam("filter") final String filterName) {
        final Filter filter = filterService.getByName(filterName);
        if (filter == null) {
            throw new IllegalArgumentException("Unknown filter: " + filterName);
        }

        Item item = itemService.getRandomByFilter(filter);
        if (item == null) {
            throw new IllegalArgumentException("No items for filter: " + filter);
        }

        Long id = item.getId();
        return "redirect:/item/" + id;
    }

    private String textForItem(final Long itemId) {
        String filename = itemId + ".txt";
        Resource resource = resourceLoader.getResource("classpath:static/content/" + filename);
        try (InputStream in = resource.getInputStream()) {
            return StreamUtils.copyToString(in, Charset.forName("UTF-8")).replace("\n", "<br/>");
        } catch (IOException e) {
            log.error("Text file not found", e);
            return "";
        }
    }

    private String linkForAudio(final Long itemId) {
        return "/content/" + itemId + ".mp3";
    }
}
