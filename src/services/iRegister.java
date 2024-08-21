package services;
import java.util.List;
import domen.Animal;

public interface iRegister <T>{

    List<Animal> getAllAnimals();

    Animal getAnimalById(int id);

    void add(Animal animal);

    void delete (Animal animal);
}