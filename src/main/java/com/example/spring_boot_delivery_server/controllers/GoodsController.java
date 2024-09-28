package com.example.spring_boot_delivery_server.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_delivery_server.services.GoodsService;
import com.example.spring_boot_delivery_server.entities.Good;

@RestController
@RequestMapping("/api/v1/goods")
public class GoodsController {

    @Autowired
    private GoodsService service;

    @GetMapping()
    public List<Good> getAllGoods() {
        return service.getAllGoods();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Good> getGoodById(@PathVariable(name = "id") long id) {
        return service.getGoodById(id)
                .map(good -> ResponseEntity.ok(good))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public Good createGood(@RequestBody Good good) {
        return service.createOrUpdateGood(good);
    }

    @PutMapping("/{id}")
    public Good updateGood(@PathVariable(name = "id") long id, @RequestBody Good good) {
        Optional<Good> item = service.getGoodById(id);
        Good updatedGood = new Good();

        if (item.isPresent()) {
            // If we can find the item,
            // update it.
            updatedGood = item.get();
            updatedGood.setName(good.getName());
            updatedGood.setCountry(good.getCountry());
            updatedGood.setDescription(good.getDescription());
            updatedGood.setCategory(good.getCategory());
            updatedGood.setPrice(good.getPrice());
            updatedGood = service.createOrUpdateGood(updatedGood);
        } else {
            // else, create the new item from the request body
            updatedGood = good;
        }

        return updatedGood;
    }

    @DeleteMapping("/{id}")
    public void deleteGoodById(@PathVariable(name = "id") long id) {
        // check if good is existed
        if (service.getGoodById(id).isPresent()) {
            // delete it
            service.deleteGoodById(id);
        }
    }
}
