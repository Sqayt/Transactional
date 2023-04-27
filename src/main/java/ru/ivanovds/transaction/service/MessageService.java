package ru.ivanovds.transaction.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ivanovds.transaction.domain.Message;
import ru.ivanovds.transaction.repository.MessageRepository;

import java.util.Iterator;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository repository;

    public Iterable<Message> getAll() {
        return repository.findAll();
    }

    public Message getById(Long id) throws NoSuchElementException {
        return repository.findById(id)
                .orElseThrow();
    }

    public void save(Message message) {
        repository.save(message);
    }

    @Transactional(value = Transactional.TxType.NEVER)
    public Iterable<Message> saveAndShow(Message message) throws RuntimeException {
//        repository.save(message);
//        int a = 1 / 0;
        return repository.findAll();
    }
}
