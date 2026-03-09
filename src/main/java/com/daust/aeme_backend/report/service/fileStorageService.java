package com.daust.aeme_backend.report.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class fileStorageService {

    private final Path uploadPath = Paths.get("uploads");

    public fileStorageService() throws IOException {
        // Crée le dossier s’il n’existe pas
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
    }

    // ==============================
    // SAVE FILE
    // ==============================
    public String saveFile(MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        // Génère un nom unique
        String uniqueFileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        Path filePath = uploadPath.resolve(uniqueFileName);

        // Sauvegarde physique du fichier
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filePath.toString();
    }

    // ==============================
    // DELETE FILE
    // ==============================
    public void deleteFile(String filePath) {

        try {
            Path path = Paths.get(filePath);
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete file: " + filePath);
        }
    }
}