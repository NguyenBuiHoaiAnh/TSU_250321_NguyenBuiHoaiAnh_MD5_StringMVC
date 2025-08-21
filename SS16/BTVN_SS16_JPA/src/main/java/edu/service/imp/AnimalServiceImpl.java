package edu.service.imp;

import edu.model.entity.Animal;
import edu.repo.AnimalRepo;
import edu.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepo animalRepo;

    @Override
    public List<Animal> findAll() {
        return animalRepo.findAll();
    }

    @Override
    public Animal findById(Long id) {
        return animalRepo.findById(id).orElse(null);
    }

    @Override
    public Animal save(Animal animal) {
        return animalRepo.save(animal);
    }

    @Override
    public void delete(Animal animal) {
        animalRepo.delete(animal);
    }
}
