package sn.ipd.gestionscolaire.repository;

import sn.ipd.gestionscolaire.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}