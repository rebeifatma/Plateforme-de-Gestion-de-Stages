package com.PGS.IAM.controller;

import java.util.Map;

import com.PGS.IAM.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Societe")

public class SocieteController {
    @Autowired
    private SocieteService SocServ;
	/*@PostMapping("/PostStage")
	public ResponseEntity<String> AjouterStage(@RequestBody Map<String, String> Request) {
	try {
		return SocServ.PostStage(Request);
	}catch(Exception ex ) {
		ex.printStackTrace();
	}return MessageUtils.getResponseEntity("SOME_THING_WENT_WRONG", HttpStatus.INTERNAL_SERVER_ERROR);
	}*/
}