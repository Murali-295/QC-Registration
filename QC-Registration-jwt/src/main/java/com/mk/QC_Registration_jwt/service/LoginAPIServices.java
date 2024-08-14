package com.mk.QC_Registration_jwt.service;

import com.mk.QC_Registration_jwt.utilities.MongoUtilities;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class LoginAPIServices {

    @Autowired
    private MongoUtilities mongoUtilities;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    public Map<String, String> authenticateUser(String clientName, String password) {

        // query db to get user

        Query query = new Query();
        query.addCriteria(Criteria.where("clientName").is(clientName));

        Document clientDatabaseData = mongoUtilities.getClient(query);

        Map<String, String> response = new LinkedHashMap<>();

        //checking whether the password and token are valid or not
        if (clientDatabaseData != null) {

            response.put("client-status", "exists");

            String encodedPassword = clientDatabaseData.get("password").toString();

            // validate password
            if (passwordEncoder.matches(password, encodedPassword)) {

                response.put("client-authentication", "success");

                // else generate new jwt token and update details in db
                String generatedToken = jwtService.generateJWTToken(clientName);

                response.put("JWT Token", generatedToken);

                return response;
            }
            response.put("client-authentication", "failed");
            response.put("errorMessage", "invalid password. Please try again!");
            return response;
        }
        response.put("client-authentication", "failed");
        response.put("errorMessage", "no client found. Please create an account!");
        return response;
    }
}