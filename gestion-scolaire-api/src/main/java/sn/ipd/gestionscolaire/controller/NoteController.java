package sn.ipd.gestionscolaire.controller;

import sn.ipd.gestionscolaire.model.Note;
import sn.ipd.gestionscolaire.repository.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin("*")
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @PostMapping
    public Note create(@RequestBody Note n) {
        return noteRepository.save(n);
    }

    @GetMapping
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Note getById(@PathVariable Long id) {
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note non trouvée"));
    }

    @PutMapping("/{id}")
    public Note update(@PathVariable Long id, @RequestBody Note n) {
        Note note = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note non trouvée"));

        note.setValeur(n.getValeur());
        note.setCommentaire(n.getCommentaire());
        note.setDateNote(n.getDateNote());
        note.setEtudiant(n.getEtudiant());
        note.setCours(n.getCours());

        return noteRepository.save(note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        noteRepository.deleteById(id);
    }
}