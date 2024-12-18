package com.PGS.Gestion.de.Favoris.ApiClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "iam", url = "http://localhost:8083") // URL ou Eureka service name
public interface UserClient {

    @GetMapping("/users/{id}")
    ResponseEntity<Boolean> checkUserExists(@PathVariable("id") Long userId);
}
