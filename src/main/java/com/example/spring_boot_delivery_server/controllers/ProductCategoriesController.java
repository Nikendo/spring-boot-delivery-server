package com.example.spring_boot_delivery_server.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_delivery_server.entities.ProductCategory;
import com.example.spring_boot_delivery_server.services.ProductCategoriesService;

@RestController
@RequestMapping("/api/v1/categories")
public class ProductCategoriesController {
    @Autowired
    private ProductCategoriesService service;

    @GetMapping()
    public List<ProductCategory> getAllProductCategories() {
        return service.getAllCategories();
    }

    @PostMapping()
    public ProductCategory createProductCategory(@RequestBody ProductCategory category) {
        return service.createOrUpdateProductCategory(category);
    }

    @PostMapping("/list")
    public List<ProductCategory> createListProductCategory(@RequestBody ArrayList<ProductCategory> categories) {
        return service.createOrUpdateListOfProductCategory(categories);
    }
}
