package sn.ipd.gestionscolaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ipd.gestionscolaire.model.Cours;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}
