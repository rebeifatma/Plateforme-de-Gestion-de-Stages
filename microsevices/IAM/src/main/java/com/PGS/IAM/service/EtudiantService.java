package com.PGS.IAM.service;


import com.PGS.IAM.model.Etudiant;

public interface EtudiantService {
    public void AjouterFavoris(Long etd,Long s);
    public String SupprimerFavoris(Long etd,Long s);
    public Etudiant findById(Long id);
}