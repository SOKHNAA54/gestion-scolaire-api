package sn.ipd.gestionscolaire.service;

import sn.ipd.gestionscolaire.model.Cours;
import sn.ipd.gestionscolaire.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursService {

    @Autowired
    private CoursRepository coursRepository;

    public Cours getCoursById(Long id) {
        return coursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé avec id: " + id));
    }

    public Cours updateCours(Long id, Cours coursDetails) {
        Cours cours = getCoursById(id);
        cours.setNom(coursDetails.getNom());
        cours.setDescription(coursDetails.getDescription());
        return coursRepository.save(cours);
    }
}