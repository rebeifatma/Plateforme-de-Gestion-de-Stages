package com.PGS.IAM.controller;


import com.PGS.IAM.model.Etudiant;
import com.PGS.IAM.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/iam/")

@RestController
public class EtudiantController {

    @Autowired
    private EtudiantService etdServ;

    @QueryMapping
    public Etudiant etudiantById (@Argument Long id) {
        return etdServ.findById(id);
    }

    @MutationMapping
    public String ajouterFavoris (@Argument Long idEtd, @Argument Long idStage) {
        etdServ.AjouterFavoris(idEtd, idStage);
        return "Stage ajouté aux favoris";
    }

    @MutationMapping
    public String supprimerFavoris (@Argument Long idEtd, @Argument Long idStage) {
        return etdServ.SupprimerFavoris(idEtd, idStage);
    }
}