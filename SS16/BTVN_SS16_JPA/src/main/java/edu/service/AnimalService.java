package edu.service;

import edu.model.entity.Animal;

import java.util.List;

public interface AnimalService {

    List<Animal> findAll();

    Animal findById(Long id);

    Animal save(Animal animal);

    void delete(Animal animal);
}
