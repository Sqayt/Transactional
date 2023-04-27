package ru.ivanovds.transaction.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ivanovds.transaction.domain.Message;
import ru.ivanovds.transaction.service.MessageService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService service;

    @GetMapping("/")
    public String getAll() {
        return "Hello world!";
    }

    @GetMapping("/{id}")
    public Message getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Message message) {
        service.save(message);
        return true;
    }

    @PostMapping("/")
    public List<Message> saveAndShow(@RequestBody Message message) {
        return (List<Message>) service.saveAndShow(message);
    }
}
