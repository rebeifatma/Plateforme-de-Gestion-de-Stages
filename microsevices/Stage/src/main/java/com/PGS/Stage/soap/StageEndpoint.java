package com.PGS.Stage.soap;

import com.PGS.Stage.model.Stage;
import com.PGS.Stage.model.StagePFE;
import com.PGS.Stage.model.StageETE;
import com.PGS.Stage.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import java.util.List;

@Endpoint
public class StageEndpoint {

    @Autowired
    private StageService stageService;


    @PayloadRoot(namespace = SoapConstants.NAMESPACE_URI, localPart = "GetAllStagesRequest")
    @ResponsePayload
    public GetAllStagesResponse getAllStages(@RequestPayload GetAllStagesRequest request) {
        List<Stage> stages = stageService.getall();
        GetAllStagesResponse response = new GetAllStagesResponse();

        for (Stage stage : stages) {
            Stage soapStage = new Stage();
            soapStage.setId(stage.getId());
            soapStage.setDescription(stage.getDescription());
            soapStage.setTitre(stage.getTitre());
            soapStage.setNom(stage.getNom());
            soapStage.setDuree(stage.getDuree());
            soapStage.setImg(stage.getImg());
            soapStage.setExpiration(stage.getExpiration());
            soapStage.setNecessarity(stage.getNecessarity());
        }
        return response;
    }

    /**
     * Récupère tous les stages PFE.
     */
    @PayloadRoot(namespace = SoapConstants.NAMESPACE_URI, localPart = "GetAllStagesPFERequest")
    @ResponsePayload
    public GetAllStagesPFEResponse getAllStagesPFE(@RequestPayload GetAllStagesPFERequest request) {
        List<StagePFE> stages = stageService.getallPFE();
        GetAllStagesPFEResponse response = new GetAllStagesPFEResponse();

        for (StagePFE stage : stages) {
            Stage soapStage = new Stage();
            soapStage.setId(stage.getId());
            soapStage.setDescription(stage.getDescription());
            soapStage.setTitre(stage.getTitre());
            soapStage.setNom(stage.getNom());
            soapStage.setDuree(stage.getDuree());
            soapStage.setImg(stage.getImg());
            soapStage.setExpiration(stage.getExpiration());
            soapStage.setNecessarity(stage.getNecessarity());
        }
        return response;
    }

    /**
     * Récupère tous les stages ETE.
     */
    @PayloadRoot(namespace = SoapConstants.NAMESPACE_URI, localPart = "GetAllStagesETERequest")
    @ResponsePayload
    public GetAllStagesETEResponse getAllStagesETE(@RequestPayload GetAllStagesETERequest request) {
        List<StageETE> stages = stageService.getallETE();
        GetAllStagesETEResponse response = new GetAllStagesETEResponse();

        for (StageETE stage : stages) {
            Stage soapStage = new Stage();
            soapStage.setId(stage.getId());
            soapStage.setDescription(stage.getDescription());
            soapStage.setTitre(stage.getTitre());
            soapStage.setNom(stage.getNom());
            soapStage.setDuree(stage.getDuree());
            soapStage.setImg(stage.getImg());
            soapStage.setExpiration(stage.getExpiration());
            soapStage.setNecessarity(stage.getNecessarity());

        }
        return response;
    }
}
