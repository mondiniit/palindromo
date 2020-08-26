package com.example.palindrono.controller;

import java.util.List;

import com.example.palindrono.model.ProductItem;
import com.example.palindrono.repository.ProductRepository;
import com.example.palindrono.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RequestMapping("/api")
@RestController
public class PaliController {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/product/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductItem> getProductByName(@PathVariable String name){
        return productService.getByBrand(name);
    }
}