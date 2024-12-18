package com.PGS.Stage.controller;
import java.util.List;

import com.PGS.Stage.model.Stage;
import com.PGS.Stage.model.StageETE;
import com.PGS.Stage.model.StagePFE;
import com.PGS.Stage.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/stage/")

public class StageController {
    @Autowired
    private StageService stageServ ;
    @GetMapping("/getall")
    public ResponseEntity<List<Stage>> getStages(){
        List<Stage> s= stageServ.getall();
        return ResponseEntity.ok(s);
    }
    @GetMapping("/getallPFE")
    public ResponseEntity<List<StagePFE>> getStagesPFE(){
        List<StagePFE> s= stageServ.getallPFE();
        return ResponseEntity.ok(s);
    }
    @GetMapping("/getallETE")
    public ResponseEntity<List<StageETE>> getStagesETE(){
        List<StageETE> s= stageServ.getallETE();
        return ResponseEntity.ok(s);
    }
    @GetMapping("/scraping")
    public ResponseEntity<String> getAllStages(){
        return ResponseEntity.ok(stageServ.scraperHiinterns());
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> stageExists(@PathVariable Long id) {
        Boolean exists = stageServ.stageExistsById(id);
        return ResponseEntity.ok(exists);
    }
}