package sn.ipd.gestionscolaire.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professeurs")
public class Professeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(unique = true)
    private String email;        // <-- AJOUTÉ

    private String telephone;    // <-- AJOUTÉ

    private String specialite;

    // Constructeur vide obligatoire pour JPA
    public Professeur() {}

    // Constructeur avec paramètres
    public Professeur(String nom, String prenom, String email, String telephone, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.specialite = specialite;
    }

    // GETTERS ET SETTERS
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {        // <-- AJOUTÉ
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {    // <-- AJOUTÉ
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSpecialite() {
        return specialite;
    }
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}