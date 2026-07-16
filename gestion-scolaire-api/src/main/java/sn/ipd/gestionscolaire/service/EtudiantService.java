package sn.ipd.gestionscolaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sn.ipd.gestionscolaire.model.Etudiant;
import sn.ipd.gestionscolaire.repository.EtudiantRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    private final String UPLOAD_DIR = "uploads/";

    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    public String uploadPhoto(Long id, MultipartFile file) throws IOException {
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant non trouvé avec id: " + id));

        Files.createDirectories(Paths.get(UPLOAD_DIR));

        String fileName = id + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR + fileName);
        Files.write(filePath, file.getBytes());

        etudiant.setPhoto(fileName);
        etudiantRepository.save(etudiant);

        return fileName;
    }
}