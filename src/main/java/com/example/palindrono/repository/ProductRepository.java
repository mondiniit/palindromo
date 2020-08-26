package com.example.palindrono.repository;

import com.example.palindrono.model.ProductItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableMongoRepositories
@RepositoryRestResource(collectionResourceRel = "promotions", path = "promotions")
public interface ProductRepository extends MongoRepository<ProductItem, String> {

    List<ProductItem> findByBrand(@Param("name") String name);
    
}