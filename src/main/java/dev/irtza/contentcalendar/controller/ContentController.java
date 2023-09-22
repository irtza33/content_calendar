package dev.irtza.contentcalendar.controller;
import dev.irtza.contentcalendar.repository.ContentCollectionRepository;
import java.util.List;
import dev.irtza.contentcalendar.model.Content;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find!"));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content) {
        repo.save(content);
    }

}
