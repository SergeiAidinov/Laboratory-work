package ru.yandex.incoming34.passengers_and_tickets.service;

import org.springframework.stereotype.Service;
import ru.yandex.incoming34.passengers_and_tickets.entity.LoadedFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class FileSaver {

    private final String TARGET_FOLDER = "downloaded_files";

    public boolean saveFile(LoadedFile loadedFile) {
        boolean result = true;
        Optional<File> targetFolderOptional = createTargetFolderIfNotExists();
        if (targetFolderOptional.isPresent()) {
            File outputFile = new File(targetFolderOptional.get() + File.separator + loadedFile.getId());
            try {
                Files.write(outputFile.toPath(), loadedFile.getFileContent());
            } catch (IOException e) {
                result = false;
            }
        }
        return result;
    }

    private String getPathToTargetFolder() {
        return System.getenv().get("PWD")
                + File.separator
                + "src"
                + File.separator
                + "main"
                + File.separator
                + "resources"
                + File.separator
                + TARGET_FOLDER;
    }

    private Optional<File> createTargetFolderIfNotExists() {
        File targetFolder = new File(getPathToTargetFolder());
        if (!targetFolder.exists()) targetFolder.mkdirs();
        return (targetFolder.exists() && targetFolder.isDirectory()) ? Optional.of(targetFolder) : Optional.empty();
    }
}
