package com.PGS.Stage.service;

import com.PGS.Stage.model.Stage;
import com.PGS.Stage.model.StageETE;
import com.PGS.Stage.model.StagePFE;

import java.util.List;

public interface StageService {
    public List<Stage> getall() ;
    public String scraperHiinterns();
    public List<StagePFE> getallPFE();
    public List<StageETE> getallETE();
}