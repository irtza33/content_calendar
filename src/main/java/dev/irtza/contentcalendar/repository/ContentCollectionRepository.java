package dev.irtza.contentcalendar.repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import dev.irtza.contentcalendar.model.Content;
import dev.irtza.contentcalendar.model.Status;
import dev.irtza.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
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

    public void save(Content c) {
        content.add(c);
    }

    @PostConstruct
    private void init() {
        Content c = new Content (1,
                "first post",
                "testing my first post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        content.add(c);
    }
}
