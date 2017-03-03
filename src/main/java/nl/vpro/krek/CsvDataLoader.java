package nl.vpro.krek;

//import com.fasterxml.jackson.databind.MappingIterator;
//import com.fasterxml.jackson.dataformat.csv.CsvMapper;
//import com.fasterxml.jackson.dataformat.csv.CsvSchema;
//import lombok.Value;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.io.ClassPathResource;
//
//import java.awt.*;
//import java.io.File;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;

//@Slf4j
public class CsvDataLoader {

//    public List<Filter> loadFilters(String fileName) {
//        List<CsvFilter> csvFilters = loadObjectList(CsvFilter.class, fileName);
//        return csvFilters.stream()
//                .map(csvFilter -> new Filter(
//                        csvFilter.name,
//                        Color.decode(csvFilter.hex)
//                ))
//                .collect(Collectors.toList());
//    }
//
//    public List<Item> loadContent(List<Filter> filters, String fileName) {
//        List<CsvItem> csvItems = loadObjectList(CsvItem.class, fileName);
//        return csvItems.stream()
//                .map(csvItem -> new Item(
//                        csvItem.id,
//                        csvItem.author,
//                        csvItem.title,
//                        csvItem.text,
//                        filterForName(filters, csvItem.filter)
//                ))
//                .collect(Collectors.toList());
//    }
//
//    private Filter filterForName(final List<Filter> filters, final String name) {
//        return filters.stream()
//                .filter(filter -> filter.getName().equals(name))
//                .findFirst().orElseThrow(() -> new IllegalArgumentException("Unknown filter: " + name));
//    }
//
//    private <T> List<T> loadObjectList(Class<T> type, String fileName) {
//        try {
//            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
//            CsvMapper mapper = new CsvMapper();
//            File file = new ClassPathResource(fileName).getFile();
//            MappingIterator<T> readValues =
//                    mapper.readerFor(type).with(bootstrapSchema).readValues(file);
//            return readValues.readAll();
//        } catch (Exception e) {
//            log.error("Error occurred while loading object list from file " + fileName, e);
//            return Collections.emptyList();
//        }
//    }
//
//    @Value
//    class CsvFilter {
//        String name;
//
//        String hex;
//    }
//
//    @Value
//    class CsvItem {
//        Long id;
//
//        String author;
//
//        String title;
//
//        String text;
//
//        String filter;
//    }
}
