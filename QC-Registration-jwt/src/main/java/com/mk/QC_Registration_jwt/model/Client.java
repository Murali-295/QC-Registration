package com.mk.QC_Registration_jwt.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {

    private String clientName;
    private String password;

    public String getClientName() {
        return clientName;
    }

    public String getPassword() {
        return password;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
