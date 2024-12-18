package com.PGS.IAM.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;

@Entity
@DiscriminatorValue("ETD")
public class Etudiant extends User {

    @Column(name = "Filiere")
    private String filiere;

    @Column(name = "Type")
    private String type;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "etudiant_favoris", joinColumns = @JoinColumn(name = "etudiant_id"))
    @Column(name = "favori_id")
    private List<Long> favoris = new ArrayList<>();

    // Constructeur par défaut
    public Etudiant() {
    }

    // Constructeur paramétré
    public Etudiant(Long id, String nom, String prenom, String email, String mdp, String role, String filiere, String type, List<Long> favoris) {
        super(id, nom, prenom, email, mdp, role);
        this.filiere = filiere;
        this.type = type;
        this.favoris = favoris;
    }

    // Getters et Setters

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Long> getFavoris() {
        return favoris;
    }

    public void setFavoris(List<Long> favoris) {
        this.favoris = favoris;
    }

    // Optionnel : Méthode toString pour débogage
    @Override
    public String toString() {
        return "Etudiant{" +
                "filiere='" + filiere + '\'' +
                ", type='" + type + '\'' +
                ", favoris=" + favoris +
                "} " + super.toString();
    }
}
