package com.PGS.IAM.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface UserService {

    public Boolean VerifMdp(String mdp);
    public Boolean VerifEmail(String email);
    public ResponseEntity<String> signUp(Map<String, String> requestMap);

}