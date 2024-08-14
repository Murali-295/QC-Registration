package com.mk.QC_Registration_jwt.utilities;

import com.mk.QC_Registration_jwt.constants.Constants;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class MongoUtilities {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Document getClient(Query query) {
        return mongoTemplate.findOne(query, Document.class, Constants.COLLECTION_NAME);
    }
}