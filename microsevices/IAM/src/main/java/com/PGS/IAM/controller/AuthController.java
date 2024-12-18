package com.PGS.IAM.controller;
import com.PGS.IAM.config.JwtProvider;
import com.PGS.IAM.exception.exception;
import com.PGS.IAM.model.Etudiant;
import com.PGS.IAM.model.User;
import com.PGS.IAM.repositories.*;

import com.PGS.IAM.request.LoginRequest;
import com.PGS.IAM.response.AuthResponse;
import com.PGS.IAM.servicesImp.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EtudiantRepository EtdRepo;

    @Autowired
    private CustomUserDetailService customUserDetails;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/Login")
    public AuthResponse signinHandler(@RequestBody LoginRequest loginRequest) {



        String email =loginRequest.getEmail();
        String Mdp=loginRequest.getMdp();

        Authentication authentication =authenticate(email,Mdp);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token=jwtProvider.generateToken(authentication);
        AuthResponse res =new AuthResponse();
        res.setJwt(token);
        res.setMessage("Login Success");
        User user =userRepository.findByEmail(email);
        if (user.getRole().equals("ETD")) {
            Etudiant etd=EtdRepo.getById(user.getId());
            res.setId(user.getId());
            res.setFiliere(etd.getFiliere());
            res.setNom(etd.getNom());
            res.setPrenom(etd.getPrenom());

        }

        if (user.getRole().equals("AD")) {
            res.setNom(user.getNom());
            res.setPrenom(user.getPrenom());
            res.setRole(user.getRole());

        }






        return  res;
    }


    private Authentication authenticate(String email, String Mdp) {



        UserDetails userDetails= customUserDetails.loadUserByUsername(email);

        if(userDetails==null) {

            throw new exception("email invalid");
        }
        if(!passwordEncoder.matches(Mdp, userDetails.getPassword())) {

            throw new exception("Invalid Password");

        }

        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }

}