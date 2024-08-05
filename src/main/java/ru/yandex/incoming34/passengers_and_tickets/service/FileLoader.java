package ru.yandex.incoming34.passengers_and_tickets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.yandex.incoming34.passengers_and_tickets.entity.LoadedFile;
import ru.yandex.incoming34.passengers_and_tickets.repo.LoadedFilesRepo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Service
@AllArgsConstructor
public class FileLoader {

    private final LoadedFilesRepo loadedFilesRepo;

    public void loadFile(MultipartFile file) throws IOException {
        final String fileName = file.getOriginalFilename();
        byte[] bytes;
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            bytes = inputStream.readAllBytes();
        } finally {
            if (Objects.nonNull(inputStream)) inputStream.close();
        }
        final LoadedFile loadedFile = new LoadedFile(fileName, bytes);
        loadedFilesRepo.save(loadedFile);
    }
}

