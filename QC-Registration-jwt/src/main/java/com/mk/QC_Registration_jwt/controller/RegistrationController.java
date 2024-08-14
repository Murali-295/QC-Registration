package com.mk.QC_Registration_jwt.controller;

import com.mk.QC_Registration_jwt.model.Client;
import com.mk.QC_Registration_jwt.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registration")
    public Map<String, String> registerClient(@RequestBody Client client){
             return registrationService.registerClient(client);
    }
}
