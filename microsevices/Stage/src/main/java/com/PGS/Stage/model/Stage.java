package com.PGS.Stage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String titre;
    private String nom;
    private String duree;
    private String img;
    private String expiration;
    private String necessarity;

    // Getters
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTitre() {
        return titre;
    }

    public String getNom() {
        return nom;
    }

    public String getDuree() {
        return duree;
    }

    public String getImg() {
        return img;
    }

    public String getExpiration() {
        return expiration;
    }

    public String getNecessarity() {
        return necessarity;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public void setNecessarity(String necessarity) {
        this.necessarity = necessarity;
    }
}
