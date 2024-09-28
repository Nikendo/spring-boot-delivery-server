package com.example.spring_boot_delivery_server.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_delivery_server.entities.ProductCategory;
import com.example.spring_boot_delivery_server.repositories.ProductCategoriesRepository;

@Service
public class ProductCategoriesService {
    @Autowired
    private ProductCategoriesRepository repository;

    public List<ProductCategory> getAllCategories() {
        return (List<ProductCategory>)repository.findAll();
    }

    public ProductCategory createOrUpdateProductCategory(ProductCategory category) {
        return repository.save(category);
    }

    public List<ProductCategory> createOrUpdateListOfProductCategory(ArrayList<ProductCategory> categories) {        
        ArrayList<ProductCategory> createdCategories = new ArrayList<>();

        for(ProductCategory cat : categories) {
            createdCategories.add(repository.save(cat));
        }

        return createdCategories;
    }
}
