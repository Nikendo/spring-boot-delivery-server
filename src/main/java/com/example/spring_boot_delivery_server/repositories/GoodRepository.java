package com.example.spring_boot_delivery_server.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.spring_boot_delivery_server.entities.Good;

@RepositoryRestResource(collectionResourceRel = "goods", path = "goods")
public interface GoodRepository extends CrudRepository<Good, Long> {
    List<Good> findByName(@Param("name") String name);
}
