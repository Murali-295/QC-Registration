package com.mk.QC_Registration_jwt.service;

import com.mk.QC_Registration_jwt.constants.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class JWTService {

    public String generateJWTToken(String username){

        Claims claims=
                Jwts.claims()
                        .setSubject(username)
                        .setIssuedAt(new Date())
                        .setExpiration(new Date(System.currentTimeMillis() + 3600000));

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, Constants.SECRET_KEY)
                .compact();
    }
}