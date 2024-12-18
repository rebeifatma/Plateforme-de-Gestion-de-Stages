package com.PGS.IAM.controller;

import java.util.Map;

import com.PGS.IAM.service.UserService;
import com.PGS.IAM.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/iam/")
public class UserController  {

    @Autowired
    private UserService UserServ;

    //@Autowired
    //private BCryptPasswordEncoder encoder ;

    @PostMapping("/SignUp")
    public ResponseEntity<String> AjouterUser(@RequestBody Map<String, String> Request) {
        try {
            return UserServ.signUp(Request);
        }catch(Exception ex) {
            ex.printStackTrace();
        }return MessageUtils.getResponseEntity("SOME_THING_WENT_WRONG", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> checkUserExists(@PathVariable Long id) {
        Boolean exists = UserServ.existsById(id);
        return ResponseEntity.ok(exists);
    }


}