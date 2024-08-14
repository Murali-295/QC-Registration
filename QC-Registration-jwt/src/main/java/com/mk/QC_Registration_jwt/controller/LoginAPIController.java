package com.mk.QC_Registration_jwt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mk.QC_Registration_jwt.service.LoginAPIServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class LoginAPIController {

    @Autowired
    private LoginAPIServices loginAPIServices;

    public static ObjectMapper objectMapper=new ObjectMapper();

    @GetMapping("/login")
    public ObjectNode getToken(@RequestBody Map<String,String> clientDetails){

        String clientName=clientDetails.get("clientName");
        String password=clientDetails.get("password");

        return objectMapper.convertValue(loginAPIServices.authenticateUser(clientName,password), ObjectNode.class);
    }
}