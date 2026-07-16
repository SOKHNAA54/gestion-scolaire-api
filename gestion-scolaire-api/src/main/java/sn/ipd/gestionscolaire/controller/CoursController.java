package sn.ipd.gestionscolaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.ipd.gestionscolaire.model.Cours;
import sn.ipd.gestionscolaire.repository.CoursRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cours") // URL de base: http://localhost:8080/api/cours
public class CoursController {

    @Autowired
    private CoursRepository coursRepository;

    // 1. CREER UN COURS - POST
    @PostMapping
    public Cours createCours(@RequestBody Cours cours) {
        return coursRepository.save(cours);
    }

    // 2. LISTER TOUS LES COURS - GET
    @GetMapping
    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    // 3. RECUPER UN COURS PAR ID - GET
    @GetMapping("/{id}")
    public Cours getCoursById(@PathVariable Long id) {
        return coursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé avec id: " + id));
    }

    // 4. MODIFIER UN COURS - PUT
    @PutMapping("/{id}")
    public Cours updateCours(@PathVariable Long id, @RequestBody Cours coursDetails) {
        Cours cours = coursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé avec id: " + id));

        cours.setNom(coursDetails.getNom());
        cours.setCode(coursDetails.getCode());
        cours.setDescription(coursDetails.getDescription()); // Maintenant ça marche

        return coursRepository.save(cours);
    }

    // 5. SUPPRIMER UN COURS - DELETE
    @DeleteMapping("/{id}")
    public String deleteCours(@PathVariable Long id) {
        Cours cours = coursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé avec id: " + id));

        coursRepository.delete(cours);
        return "Cours supprimé avec succès";
    }
}