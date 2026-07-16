package sn.ipd.gestionscolaire.controller; // mets ton package

import sn.ipd.gestionscolaire.model.Inscription;
import sn.ipd.gestionscolaire.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscriptions")
@CrossOrigin(origins = "*")
public class InscriptionController {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    // 1. Créer une inscription - OBLIGATOIRE POUR LE PROF
    @PostMapping
    public ResponseEntity<Inscription> createInscription(@RequestBody Inscription inscription) {
        Inscription savedInscription = inscriptionRepository.save(inscription);
        return ResponseEntity.ok(savedInscription);
    }

    // 2. Lister toutes les inscriptions
    @GetMapping
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    // 3. Récupérer une inscription par ID - Tu l'as déjà
    @GetMapping("/{id}")
    public ResponseEntity<Inscription> getInscriptionById(@PathVariable Long id) {
        return inscriptionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. Supprimer une inscription - Tu l'as déjà
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscription(@PathVariable Long id) {
        inscriptionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}