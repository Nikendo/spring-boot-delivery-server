package com.example.spring_boot_delivery_server.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_delivery_server.repositories.GoodRepository;
import com.example.spring_boot_delivery_server.entities.Good;;

@Service
public class GoodsService {
    @Autowired
    private GoodRepository repository;

    public List<Good> getAllGoods() {
        return (List<Good>)repository.findAll();
    }
    
    public Optional<Good> getGoodById(long id) {
        return repository.findById(id);
    }

    public Good createOrUpdateGood(Good good) {
        return repository.save(good);
    }

    public void deleteGoodById(long id) {
        repository.deleteById(id);
    }
}
