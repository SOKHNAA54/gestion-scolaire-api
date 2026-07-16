package sn.ipd.gestionscolaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ipd.gestionscolaire.model.Etudiant;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findByNomContainingIgnoreCase(String nom); // AJOUTE ÇA
}