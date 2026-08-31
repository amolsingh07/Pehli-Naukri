package com.luv2code.jobportal.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {

    public static void saveFile(String uploadDir, String filename, MultipartFile multipartFile) throws IOException {

        Path storageRoot = Paths.get(System.getenv().getOrDefault("APP_STORAGE_PATH", "./photos"))
                .toAbsolutePath().normalize();
        Path uploadPath = storageRoot.resolve(uploadDir.replaceFirst("^photos/?", "")).normalize();
        if (!uploadPath.startsWith(storageRoot)) {
            throw new IOException("Invalid upload path");
        }
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream();) {
            Path path = uploadPath.resolve(Paths.get(filename).getFileName()).normalize();
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException ioe) {
            throw new IOException("Could not save image file: " + filename, ioe);
        }
    }
}
