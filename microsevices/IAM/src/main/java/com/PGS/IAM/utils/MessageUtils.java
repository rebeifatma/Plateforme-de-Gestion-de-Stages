package com.PGS.IAM.utils;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MessageUtils {

    public static ResponseEntity<String> getResponseEntity(String responseMessage,HttpStatus httpStatus){
        return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}",httpStatus);
    }
}