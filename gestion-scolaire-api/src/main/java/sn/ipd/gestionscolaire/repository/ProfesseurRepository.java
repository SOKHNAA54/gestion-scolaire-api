package sn.ipd.gestionscolaire.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.ipd.gestionscolaire.model.Professeur;
public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {}