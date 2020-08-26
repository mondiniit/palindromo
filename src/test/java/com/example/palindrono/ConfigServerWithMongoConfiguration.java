package com.example.palindrono;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration(exclude = { EmbeddedMongoAutoConfiguration.class, MongoAutoConfiguration.class,
    MongoDataAutoConfiguration.class })
   @Configuration
   @ComponentScan(basePackages = { "com.example.palindrono" }, excludeFilters = {
    @ComponentScan.Filter(classes = { SpringBootApplication.class }) })
public class ConfigServerWithMongoConfiguration  extends AbstractMongoBaseConfiguration{
    
}