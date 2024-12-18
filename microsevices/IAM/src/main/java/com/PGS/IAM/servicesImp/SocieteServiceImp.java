package com.PGS.IAM.servicesImp;

import java.util.Map;


import com.PGS.IAM.model.Societe;
import com.PGS.IAM.service.SocieteService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SocieteServiceImp implements SocieteService {
    public Societe getSocieteFormMap(Map<String,String> requestMap) {
        Societe user =new Societe();
        user.setNom(requestMap.get("Nom"));
        user.setPrenom(requestMap.get("Prenom"));
        user.setEmail(requestMap.get("Email"));
        BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
        String mdp=bcrypt.encode(requestMap.get("Mdp"));
        user.setMdp(mdp);

        // user.setMdp(new BCryptPasswordEncoder(10).encode(Mdp));
        user.setRole(requestMap.get("Role"));
        user.setNomSociete(requestMap.get("NomSociete"));
        user.setEmplacement(requestMap.get("Emplacement"));


        //User savedUser = UserRepo.save(user);

        return user;

    }
	/*@Override
	public ResponseEntity<String> PostStage(@RequestBody Map<String, String> Request)
	{
		try {
			if (validationSignUpMap(requestMap)) {

			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		 return MessageUtils.getResponseEntity("SOME_THING_WENT_WRONG", HttpStatus.BAD_REQUEST);

	}
	private boolean validationStageMap(Map<String,String> requestMap) {
		 return requestMap.containsKey("description")&&requestMap.containsKey("dateDebut");
	 }*/

}