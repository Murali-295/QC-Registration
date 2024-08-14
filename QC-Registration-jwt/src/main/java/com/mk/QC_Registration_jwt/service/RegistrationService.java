package com.mk.QC_Registration_jwt.service;

import com.mk.QC_Registration_jwt.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RegistrationService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Map<String, String> registerClient(Client client){
        String clientName = client.getClientName();
        String encodedPassword = passwordEncoder.encode(client.getPassword());
        Map<String, String> response = new LinkedHashMap<>();

        Client newClient = new Client();
        newClient.setClientName(clientName);
        newClient.setPassword(encodedPassword);

        try {
            mongoTemplate.insert(newClient);
            response.put("status", "Client registered successfully");
            return response;
        } catch (Exception e) {
            response.put("status", "registration unsuccessful. Client already exists.");
            return response;
        }
    }

}

