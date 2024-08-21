import services.AnimalRegister;
import services.Controller;
import services.View;

public class App {
    public static void main(String[] args) throws Exception {
        AnimalRegister register = new AnimalRegister();
        Controller animalController = new Controller(register);
        View viewAnimal = new View(animalController);
        viewAnimal.run();
   }
}
