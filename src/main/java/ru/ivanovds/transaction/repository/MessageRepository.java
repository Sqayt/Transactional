package ru.ivanovds.transaction.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ivanovds.transaction.domain.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
