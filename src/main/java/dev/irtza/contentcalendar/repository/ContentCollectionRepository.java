package dev.irtza.contentcalendar.repository;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import dev.irtza.contentcalendar.model.Content;
import org.springframework.stereotype.Repository;

@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    public List<Content> finalAll() {
        return content;
    }

    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

}
