package com.PGS.Gestion.de.Favoris.controller;
import com.PGS.Gestion.de.Favoris.model.Favori;
import com.PGS.Gestion.de.Favoris.service.FavoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/favoris")
public class FavoriController {

    @Autowired
    private FavoriService favoriService;

    // Ajouter un stage aux favoris
    @PostMapping
    public ResponseEntity<Favori> ajouterFavori(@RequestParam Long etudiantId, @RequestParam Long stageId) {
        Favori favori = favoriService.ajouterFavori(etudiantId, stageId);
        return ResponseEntity.ok(favori);
    }

    // Supprimer un favori
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerFavori(@PathVariable Long id) {
        favoriService.supprimerFavori(id);
        return ResponseEntity.ok("Favori supprimé avec succès.");
    }

    // Afficher les favoris d'un étudiant
    @GetMapping("/{etudiantId}")
    public ResponseEntity<List<Favori>> getFavoris(@PathVariable Long etudiantId) {
        List<Favori> favoris = favoriService.getFavorisByEtudiantId(etudiantId);
        return ResponseEntity.ok(favoris);
    }
}
