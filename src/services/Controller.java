package services;

import java.util.List;

import domen.Animal;
import domen.Camel;
import domen.Cat;
import domen.Dog;
import domen.Donkey;
import domen.Hamster;
import domen.Horse;

public class Controller {

    AnimalRegister animalRegister;

    public Controller(AnimalRegister animalRegister) {
        this.animalRegister = animalRegister;        
    }


    public void addCat(int id, String name, String birthday) {
        Cat cat = new Cat(id, name, birthday);
        animalRegister.add(cat);
    }

    public void addDog(int id, String name, String birthday) {
        Dog dog = new Dog(id, name, birthday);
        animalRegister.add(dog);
    }

    public void addHamster(int id, String name, String birthday) {
        Hamster hamster = new Hamster(id, name, birthday);
        animalRegister.add(hamster);
    }

    public void addHorse(int id, String name, String birthday) {
        Horse horse = new Horse(id, name, birthday);
        animalRegister.add(horse);
    }

    public void addDonkey(int id, String name, String birthday) {
        Donkey donkey = new Donkey(id, name, birthday);
        animalRegister.add(donkey);
    }

    public void addCamel(int id, String name, String birthday) {
        Camel camel = new Camel(id, name, birthday);
        animalRegister.add(camel);
    }

    public List<Animal> getAll() {
        return animalRegister.getAllAnimals();
    }

        public Animal getAnimal(int id) {
        return animalRegister.getAnimalById(id);
    }

    public void addCommand(int id, String command) {
        Animal beast = animalRegister.getAnimalById(id);
        if (beast != null) {
            //animalRegister.delete(beast);
            beast.addCommand(command);
            //animalRegister.add(beast);            
            System.out.println("Команда добавлена животному с id " + id + ": " + command);
        } else {            
            System.err.println("Животное с id " + id + " не существует.");
        }
    }

    public String getCommands(int id) {
        return animalRegister.getAnimalById(id).getAnimalCommands();
    }

    public boolean deleteAnimal(int id) {
        Animal animal = animalRegister.getAnimalById(id);
        if (animal != null) {
            animalRegister.delete(animal);
            return true;
        }
        return false;
    }    
}
