package sn.ipd.gestionscolaire.controller;

import io.swagger.v3.oas.annotations.Parameter; // <-- POUR FORCER CHOOSE FILE
import io.swagger.v3.oas.annotations.media.Schema; // <-- POUR FORCER CHOOSE FILE
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sn.ipd.gestionscolaire.model.Etudiant;
import sn.ipd.gestionscolaire.service.EtudiantService;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant newEtudiant = etudiantService.saveEtudiant(etudiant);
        return ResponseEntity.ok(newEtudiant);
    }

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        return ResponseEntity.ok(etudiants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        return ResponseEntity.ok(etudiant);
    }

    // UPLOAD PHOTO - VERSION FINALE AVEC @Parameter POUR FORCER LE BOUTON
    @PostMapping(value = "/{id}/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadPhoto(
            @PathVariable Long id,
            @Parameter(description = "Fichier image à uploader", schema = @Schema(type = "string", format = "binary"))
            @RequestPart("file") MultipartFile file) {
        try {
            String fileName = etudiantService.uploadPhoto(id, file);
            return ResponseEntity.ok("Photo uploadée avec succès: " + fileName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erreur: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
        return ResponseEntity.ok("Etudiant supprimé avec succès");
    }
}