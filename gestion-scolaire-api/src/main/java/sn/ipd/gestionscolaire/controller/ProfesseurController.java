package sn.ipd.gestionscolaire.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.ipd.gestionscolaire.model.Professeur;
import sn.ipd.gestionscolaire.repository.ProfesseurRepository;
import java.util.List;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {
    @Autowired
    private ProfesseurRepository professeurRepository;

    @PostMapping
    public Professeur create(@RequestBody Professeur p) { return professeurRepository.save(p); }
    @GetMapping
    public List<Professeur> getAll() { return professeurRepository.findAll(); }
    @GetMapping("/{id}")
    public Professeur getById(@PathVariable Long id) { return professeurRepository.findById(id).orElseThrow(); }
    @PutMapping("/{id}")
    public Professeur update(@PathVariable Long id, @RequestBody Professeur p) {
        Professeur prof = professeurRepository.findById(id).orElseThrow();
        prof.setNom(p.getNom()); prof.setPrenom(p.getPrenom()); prof.setSpecialite(p.getSpecialite());
        return professeurRepository.save(prof);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) { professeurRepository.deleteById(id); return "Professeur supprimé"; }
}