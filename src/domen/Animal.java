package domen;
import java.util.ArrayList;

public abstract class Animal {
    public int id;
    public String name;
    public String  birthday;
    public ArrayList <String> commands = new ArrayList<>();


    public Animal(int id, String name, String birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAnimalCommands() {
        return commands.toString();
    }

    public void addCommand(String command){
        commands.add(command);

    }

    @Override
    public String toString() {        
        return "id: "+this.id+ ", кличка: "+ this.name + ", дата рождения: "+this.birthday;
    }
}