package dev.irtza.contentcalendar.controller;
import dev.irtza.contentcalendar.repository.ContentCollectionRepository;
import java.util.List;
import dev.irtza.contentcalendar.model.Content;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private final ContentCollectionRepository repo;

    public ContentController(ContentCollectionRepository contentCollectionRepository){
        this.repo = contentCollectionRepository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return repo.finalAll();
    }

}
