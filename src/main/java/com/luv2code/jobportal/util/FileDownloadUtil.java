package com.luv2code.jobportal.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownloadUtil {

    private Path foundfile;

    public Resource getFileAsResourse(String downloadDir, String fileName) throws IOException {

        Path storageRoot = Paths.get(System.getenv().getOrDefault("APP_STORAGE_PATH", "./photos"))
                .toAbsolutePath().normalize();
        Path path = storageRoot.resolve(downloadDir.replaceFirst("^photos/?", "")).normalize();
        if (!path.startsWith(storageRoot) || !Files.isDirectory(path)) {
            return null;
        }
        String safeFileName = Paths.get(fileName).getFileName().toString();
        try (var files = Files.list(path)) {
            files.filter(Files::isRegularFile)
                    .filter(file -> file.getFileName().toString().equals(safeFileName))
                    .findFirst()
                    .ifPresent(file -> foundfile = file);
        }

        if (foundfile != null) {
            return new UrlResource(foundfile.toUri());
        }
        return null;
    }
}
