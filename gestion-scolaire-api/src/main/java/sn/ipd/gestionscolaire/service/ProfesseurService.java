package sn.ipd.gestionscolaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.ipd.gestionscolaire.model.Professeur;
import sn.ipd.gestionscolaire.repository.ProfesseurRepository;

import java.util.List;

@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository professeurRepository;

    // CREATE
    public Professeur createProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    // READ ALL
    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    // READ BY ID
    public Professeur getProfesseurById(Long id) {
        return professeurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professeur non trouvé avec l'id: " + id));
    }

    // UPDATE
    public Professeur updateProfesseur(Long id, Professeur professeurDetails) {
        Professeur professeur = professeurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professeur non trouvé avec l'id: " + id));

        professeur.setNom(professeurDetails.getNom());
        professeur.setPrenom(professeurDetails.getPrenom());
        professeur.setEmail(professeurDetails.getEmail());         // <-- Maintenant ça existe
        professeur.setTelephone(professeurDetails.getTelephone()); // <-- Et ça aussi
        professeur.setSpecialite(professeurDetails.getSpecialite());

        return professeurRepository.save(professeur);
    }

    // DELETE
    public void deleteProfesseur(Long id) {
        Professeur professeur = professeurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professeur non trouvé avec l'id: " + id));
        professeurRepository.delete(professeur);
    }
}