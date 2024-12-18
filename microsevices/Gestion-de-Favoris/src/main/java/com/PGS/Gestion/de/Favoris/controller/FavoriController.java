package com.PGS.Gestion.de.Favoris.controller;

import com.PGS.Gestion.de.Favoris.service.FavorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/favoris/")
public class FavoriController {

    @Autowired
    private FavorieService favoriService;

    // Ajouter un stage aux favoris

    @PostMapping("/add")
    public ResponseEntity<String> addFavorite(@RequestParam Long userId, @RequestParam Long stageId) {
        String result = favoriService.addFavorite(userId, stageId);
        return ResponseEntity.ok(result);
    }

}
