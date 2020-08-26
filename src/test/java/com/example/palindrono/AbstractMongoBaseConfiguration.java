package com.example.palindrono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.core.env.Environment;



public abstract class AbstractMongoBaseConfiguration extends AbstractMongoClientConfiguration{
    
    @Autowired
    private Environment env;

    @Override
    protected String getDatabaseName() {
        return env.getRequiredProperty("spring.data.mongodb.database");
    }
}