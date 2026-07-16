package sn.ipd.gestionscolaire.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valeur;
    private String commentaire;
    private LocalDate dateNote;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "etudiant_id")
    @JsonIgnoreProperties("notes")
    private Etudiant etudiant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cours_id")
    @JsonIgnoreProperties("notes")
    private Cours cours;

    public Note() {}
    // GETTERS SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getValeur() { return valeur; }
    public void setValeur(Double valeur) { this.valeur = valeur; }
    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }
    public LocalDate getDateNote() { return dateNote; }
    public void setDateNote(LocalDate dateNote) { this.dateNote = dateNote; }
    public Etudiant getEtudiant() { return etudiant; }
    public void setEtudiant(Etudiant etudiant) { this.etudiant = etudiant; }
    public Cours getCours() { return cours; }
    public void setCours(Cours cours) { this.cours = cours; }
}