package com.PGS.IAM.servicesImp;
import java.util.Map;

import com.PGS.IAM.model.Etudiant;
import com.PGS.IAM.repositories.EtudiantRepository;
import com.PGS.IAM.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class EtudiantServiceImp implements EtudiantService {
    @Autowired
    private EtudiantRepository EtdRepo;

    public void AjouterFavoris(Long etd,Long s) {
        Etudiant e=EtdRepo.getById(etd);
        e.getFavoris().add(s);
        EtdRepo.save(e);
    }
    @Override
    public Etudiant findById(Long id) {
        return EtdRepo.findById(id).orElseThrow(() -> new RuntimeException("Etudiant introuvable"));
    }
    public String SupprimerFavoris(Long etd,Long s) {
        Etudiant e=EtdRepo.getById(etd);
        if (e.getFavoris().contains(s)) {
            e.getFavoris().remove(s);
            EtdRepo.save(e);
            return "Succesivement supprimé !";
        } else {
            return "N existe pas !";
        }
    }
    public Etudiant getEtdFormMap(Map<String,String> requestMap) {
        Etudiant user =new Etudiant();
        user.setNom(requestMap.get("Nom"));
        user.setPrenom(requestMap.get("Prenom"));
        user.setEmail(requestMap.get("Email"));
        BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
        String mdp=bcrypt.encode(requestMap.get("Mdp"));
        user.setMdp(mdp);

        // user.setMdp(new BCryptPasswordEncoder(10).encode(Mdp));
        user.setRole(requestMap.get("Role"));
        user.setType(requestMap.get("Type"));
        user.setFiliere(requestMap.get("Filiere"));

        //User savedUser = UserRepo.save(user);

        return user;

    }
}