package com.PGS.IAM.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SOC")
public class Societe extends User {

    @Column(name = "NomSociete")
    private String nomSociete;

    @Column(name = "Emplacement")
    private String emplacement;

    // Constructeur par défaut
    public Societe() {
    }

    // Constructeur paramétré
    public Societe(Long id, String nom, String prenom, String email, String mdp, String role, String nomSociete, String emplacement) {
        super(id, nom, prenom, email, mdp, role);
        this.nomSociete = nomSociete;
        this.emplacement = emplacement;
    }

    // Getters et Setters
    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    // Optionnel : Méthode toString pour débogage
    @Override
    public String toString() {
        return "Societe{" +
                "nomSociete='" + nomSociete + '\'' +
                ", emplacement='" + emplacement + '\'' +
                "} " + super.toString();
    }
}
