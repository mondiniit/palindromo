package com.example.palindrono.service;

import java.util.List;

import com.example.palindrono.model.ProductItem;
import org.springframework.context.annotation.Bean;

public interface ProductService {

    public List<ProductItem> getByBrand(String name);

}