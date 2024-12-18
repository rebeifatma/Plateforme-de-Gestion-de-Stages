package com.PGS.IAM.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@NamedQuery(
        name = "findByEmail",
        query = "SELECT c FROM User c WHERE c.email =:email"
)
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "Mdp")
    private String mdp;

    @Column(name = "Role")
    private String role;

    // Constructeur par défaut
    public User() {
    }

    // Constructeur paramétré
    public User(Long id, String nom, String prenom, String email, String mdp, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
    }

    // Getters et Setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Optionnel : Méthode toString pour débogage
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
