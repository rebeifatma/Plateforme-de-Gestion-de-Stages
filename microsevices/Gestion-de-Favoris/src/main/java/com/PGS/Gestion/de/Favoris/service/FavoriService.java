package com.PGS.Gestion.de.Favoris.service;
import com.PGS.Gestion.de.Favoris.model.Favori;
import com.PGS.Gestion.de.Favoris.repository.FavoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FavoriService {

    @Autowired
    private FavoriRepository favoriRepository;

    // Ajouter un favori
    public Favori ajouterFavori(Long etudiantId, Long stageId) {
        Favori favori = new Favori(etudiantId, stageId);
        return favoriRepository.save(favori);
    }

    // Supprimer un favori
    public void supprimerFavori(Long id) {
        favoriRepository.deleteById(id);
    }

    // Afficher les favoris d'un étudiant
    public List<Favori> getFavorisByEtudiantId(Long etudiantId) {
        return favoriRepository.findByEtudiantId(etudiantId);
    }
}
