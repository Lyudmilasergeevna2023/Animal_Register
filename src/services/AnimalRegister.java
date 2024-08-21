package services;

import java.util.ArrayList;
import java.util.List;
import domen.Animal;

public class AnimalRegister implements iRegister <Animal>{

    private List<Animal> animals;

    public AnimalRegister() {
        this.animals = new ArrayList<Animal>();
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animals;
    }

    @Override
    public Animal getAnimalById(int id) {
        if(id >= 0 && id < animals.size()) {
            return animals.get(id);
        }
        return null;
    }

    @Override
    public void add(Animal animal) {
        animals.add(animal);

    }
    @Override
    public void delete(Animal animal) {
        animals.remove(animal);
    }    
}
