package com.example.palindrono.service.impl;

import java.util.List;

import com.example.palindrono.model.ProductItem;
import com.example.palindrono.repository.ProductRepository;
import com.example.palindrono.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductItem> getByBrand(String name) {
        return productRepository.findByBrand(name);
    }
    
}