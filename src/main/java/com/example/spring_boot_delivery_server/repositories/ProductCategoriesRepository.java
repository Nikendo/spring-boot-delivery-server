package com.example.spring_boot_delivery_server.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.spring_boot_delivery_server.entities.ProductCategory;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface ProductCategoriesRepository extends CrudRepository<ProductCategory, Long> {
    List<ProductCategory> findByName(@Param("name") String name);
}
