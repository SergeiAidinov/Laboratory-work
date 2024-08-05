package ru.yandex.incoming34.passengers_and_tickets.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.yandex.incoming34.passengers_and_tickets.entity.LoadedFile;
import ru.yandex.incoming34.passengers_and_tickets.repo.LoadedFilesRepo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Objects;

@Service
@AllArgsConstructor
public class FileLoader {

    private final LoadedFilesRepo loadedFilesRepo;

    public void loadFile(MultipartFile multipartFile) throws IOException {
        final String fileName = multipartFile.getOriginalFilename();
        final byte[] fileContent;
        InputStream inputStream = null;
        try {
            inputStream = multipartFile.getInputStream();
            fileContent = inputStream.readAllBytes();
        } finally {
            if (Objects.nonNull(inputStream)) inputStream.close();
        }
        final LoadedFile loadedFile = new LoadedFile(fileName, fileContent);
        loadedFilesRepo.save(loadedFile);
    }
}

