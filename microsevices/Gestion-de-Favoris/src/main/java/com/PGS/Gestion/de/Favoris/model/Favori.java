package com.PGS.Gestion.de.Favoris.model;

import jakarta.persistence.*;

@Entity
@Table(name = "favoris")
public class Favori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long etudiantId; // ID de l'étudiant
    private Long stageId;    // ID du stage

    // Constructeurs
    public Favori() {}

    public Favori(Long etudiantId, Long stageId) {
        this.etudiantId = etudiantId;
        this.stageId = stageId;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Long etudiantId) {
        this.etudiantId = etudiantId;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }
}
