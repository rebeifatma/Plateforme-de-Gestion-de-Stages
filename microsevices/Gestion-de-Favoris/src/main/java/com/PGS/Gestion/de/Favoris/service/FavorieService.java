package com.PGS.Gestion.de.Favoris.service;
import com.PGS.Gestion.de.Favoris.ApiClient.StageClient;
import com.PGS.Gestion.de.Favoris.ApiClient.UserClient;
import com.PGS.Gestion.de.Favoris.model.Favori;
import com.PGS.Gestion.de.Favoris.repository.FavoriRepository;
import org.springframework.stereotype.Service;
@Service
public class FavorieService {

    private final UserClient userClient;
    private final StageClient stageClient;
    private final FavoriRepository favorieRepository;

    public FavorieService(UserClient userClient, StageClient stageClient, FavoriRepository favorieRepository) {
        this.userClient = userClient;
        this.stageClient = stageClient;
        this.favorieRepository = favorieRepository;
    }

    public String addFavorite(Long userId, Long stageId) {
        // Vérification de l'existence de l'utilisateur
        Boolean userExists = userClient.checkUserExists(userId).getBody();
        if (!Boolean.TRUE.equals(userExists)) {
            throw new IllegalArgumentException("L'utilisateur avec l'ID " + userId + " n'existe pas.");
        }

        // Vérification de l'existence du stage
        Boolean stageExists = stageClient.stageExists(stageId).getBody();
        if (!Boolean.TRUE.equals(stageExists)) {
            throw new IllegalArgumentException("Le stage avec l'ID " + stageId + " n'existe pas.");
        }

        // Si tout est validé, sauvegarder le favori
        Favori favorie = new Favori();
        favorie.setEtudiantId(userId);
        favorie.setStageId(stageId);
        favorieRepository.save(favorie);

        return "Favorie ajouté avec succès.";
    }
}
