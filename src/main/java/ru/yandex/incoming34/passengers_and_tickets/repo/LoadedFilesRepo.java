package ru.yandex.incoming34.passengers_and_tickets.repo;

import org.springframework.data.repository.CrudRepository;
import ru.yandex.incoming34.passengers_and_tickets.entity.LoadedFile;

public interface LoadedFilesRepo extends CrudRepository<LoadedFile, String> {
}
