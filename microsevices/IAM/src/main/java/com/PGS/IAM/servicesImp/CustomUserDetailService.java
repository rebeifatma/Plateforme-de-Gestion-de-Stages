package com.PGS.IAM.servicesImp;

import java.util.ArrayList;
import java.util.List;

import com.PGS.IAM.model.User;
import com.PGS.IAM.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String Nom) throws UsernameNotFoundException {

        User user =userRepository.findByEmail(Nom);
        if(user==null) {
            throw new UsernameNotFoundException("user not found with email "+Nom);
        }


        //    return loadUserByEmail(username);



        //public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        //  User user = userRepository.findByEmail(email);
        //if (user == null) {
        //  throw new UsernameNotFoundException("User not found with email: " + email);
        // }
        List<GrantedAuthority>authorities=new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getMdp(), authorities);




    }}