package com.PGS.IAM.response;

import java.util.ArrayList;

public class AuthResponse {

    private String jwt;
    private String message;
    private String nom;
    private String prenom;
    private Long id;
    private String filiere;
    private String role;

    // Constructeur par défaut
    public AuthResponse() {
    }

    // Constructeur avec paramètres
    public AuthResponse(String jwt, String message, String nom, String prenom, Long id, String filiere, String role) {
        this.jwt = jwt;
        this.message = message;
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.filiere = filiere;
        this.role = role;
    }

    // Getter et Setter pour jwt
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    // Getter et Setter pour message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Getter et Setter pour nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter et Setter pour prenom
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Getter et Setter pour id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter et Setter pour filiere
    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    // Getter et Setter pour role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Optionnel : Méthode toString pour affichage facile
    @Override
    public String toString() {
        return "AuthResponse{" +
                "jwt='" + jwt + '\'' +
                ", message='" + message + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", id=" + id +
                ", filiere='" + filiere + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
