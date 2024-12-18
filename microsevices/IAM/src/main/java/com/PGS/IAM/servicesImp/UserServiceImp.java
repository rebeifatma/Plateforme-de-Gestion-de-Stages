package com.PGS.IAM.servicesImp;

import java.util.Map;
import java.util.Objects;

import com.PGS.IAM.model.User;
import com.PGS.IAM.repositories.EtudiantRepository;
import com.PGS.IAM.repositories.SocieteRepository;
import com.PGS.IAM.repositories.UserRepository;
import com.PGS.IAM.service.UserService;
import com.PGS.IAM.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository UserRepo;

    public Boolean VerifMdp(String mdp) {
        boolean contientMajuscule = false;
        boolean contientMinuscule = false;
        boolean contientChiffre = false;

        // Vérification de la longueur
        if (mdp.length() < 6) {
            return false;
        }

        // Vérification des caractères
        int i=0;
        while(i<mdp.length() )
        {
            char c = mdp.charAt(i);
            if (Character.isUpperCase(c)) {
                contientMajuscule = true;
            } else if (Character.isLowerCase(c)) {
                contientMinuscule = true;
            } else if (Character.isDigit(c)) {
                contientChiffre = true;
            }
            i+=1;
        }

        // Vérification finale
        return contientMajuscule && contientMinuscule && contientChiffre;
    }

    public Boolean VerifEmail(String email) {
        if (email.length()>"@enicar.ucar.tn".length()) {
            return email.endsWith("@enicar.ucar.tn");}
        return false;
    }
    @Autowired
    EtudiantRepository etdRepo;
    @Autowired
    EtudiantServiceImp etdServ;
    @Autowired
    SocieteServiceImp SocServ;
    @Autowired
    SocieteRepository SocRepo;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap){
        try {
            if (validationSignUpMap(requestMap))
            {
                User user=UserRepo.findByEmail(requestMap.get("Email"));
                if (Objects.isNull(user))
                {

                    if (VerifMdp(requestMap.get("Mdp")))
                    {
                        if(requestMap.get("Role").equals("ETD"))
                        {
                            if(VerifEmail(requestMap.get("Email")))
                            {
                                if(requestMap.containsKey("Filiere")&&requestMap.containsKey("Type"))
                                {
                                    etdRepo.save(etdServ.getEtdFormMap(requestMap));
                                    return MessageUtils.getResponseEntity("EtudiantADD_IT_SUCCESSFULLY", HttpStatus.OK);
                                }
                                else
                                {
                                    return MessageUtils.getResponseEntity("TYPE&FILIERE_ARE_REQUIRED", HttpStatus.BAD_REQUEST);
                                }

                            }
                            else
                            {
                                return MessageUtils.getResponseEntity("EMAIL_fORMAT_INCORECT", HttpStatus.BAD_REQUEST);
                            }

                        }
                        else {
                            if(requestMap.get("Email").contains("@"))
                            {
                                if(requestMap.containsKey("Emplacement")&&requestMap.containsKey("NomSociete"))
                                {
                                    SocRepo.save(SocServ.getSocieteFormMap(requestMap));
                                    return MessageUtils.getResponseEntity("SocieteADD_IT_SUCCESSFULLY", HttpStatus.OK);
                                }
                                else {
                                    return MessageUtils.getResponseEntity("Emplacement&NomSociete_ARE_REQUIRED", HttpStatus.BAD_REQUEST);
                                }

                            }
                            else {
                                return MessageUtils.getResponseEntity("EMAIL_fORMAT_INCORECT", HttpStatus.BAD_REQUEST);
                            }
                        }
                    }


                }
                else {
                    return MessageUtils.getResponseEntity("MDP_fORMAT_INCORECT", HttpStatus.BAD_REQUEST);
                }

            }

            else {
                return MessageUtils.getResponseEntity("INVALID_DATA", HttpStatus.BAD_REQUEST);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return MessageUtils.getResponseEntity("SOME_THING_WENT_WRONG", HttpStatus.BAD_REQUEST);
    }
    private boolean validationSignUpMap(Map<String,String> requestMap) {
        return requestMap.containsKey("Nom")&&requestMap.containsKey("Prenom")&&requestMap.containsKey("Email")&&requestMap.containsKey("Mdp")&&requestMap.containsKey("Role");
    }

}