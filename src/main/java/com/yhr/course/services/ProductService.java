package com.yhr.course.services;

import com.yhr.course.entities.Product;
import com.yhr.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll()
    {
        return productRepository.findAll();
    }

    public Product findById(Long id)
    {
        return productRepository.findById(id).orElse(null);
    }
}
