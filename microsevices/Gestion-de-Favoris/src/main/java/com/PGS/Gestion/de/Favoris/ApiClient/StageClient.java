package com.PGS.Gestion.de.Favoris.ApiClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stage", url = "http://localhost:8082") // Remplacez l'URL par celle de votre microservice
public interface StageClient {

    @GetMapping("/exists/{id}")
    ResponseEntity<Boolean> stageExists(@PathVariable("id") Long id);
}
