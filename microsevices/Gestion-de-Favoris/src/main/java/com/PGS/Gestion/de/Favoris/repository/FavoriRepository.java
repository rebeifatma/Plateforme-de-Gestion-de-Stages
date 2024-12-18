package com.PGS.Gestion.de.Favoris.repository;

import com.PGS.Gestion.de.Favoris.model.Favori;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriRepository extends JpaRepository<Favori, Long> {
    // Méthode pour récupérer les favoris d'un étudiant
    List<Favori> findByEtudiantId(Long etudiantId);
}
