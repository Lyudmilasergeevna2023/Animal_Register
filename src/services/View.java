package services;

import java.util.List;
import java.util.Scanner;
import domen.Animal;

public class View {
    public static Controller controller;

    public View(Controller controller) {
        View.controller = controller;    }


    public void run() throws Exception {
        Scanner in = new Scanner(System.in);
        Counter counter = new Counter();    
        boolean flag = true;
        try{
            while (flag) {
                System.out.println("\nВыберете команду:\n" +
                        "1 - Добавить новое животное \n" +
                        "2 - Вывести список всех животных \n" +
                        "3 - Вывести информацию о животном по его id \n" +
                        "4 - Обучить животное новым командам \n" +
                        "5 - Вывести список команд, которые выполняет животное(ID) \n" +
                        "6 - Удалить животное \n" +
                        "7 - Посчитать количество животных \n" +
                        "8 - Выход из меню \n");

                String command = in.next();
                try {
                    switch (command) {
                        case "1": // Добавить новое животное
                            System.out.println("Выберите вид животного:\n" +
                                    "1 - кот\n" +
                                    "2 - собака\n" +
                                    "3 - хомяк\n" +
                                    "4 - лошадь\n" +
                                    "5 - верблюд\n" +
                                    "6 - осел\n");

                            String animalType = in.next();
                            System.out.println("Введите имя: ");
                            String name = in.next();
                            String birthday = inputBirthday();

                            switch (animalType) {
                                case "1":
                                    controller.addCat(counter.getCount(), name, birthday);
                                    counter.add();
                                    break;
                                case "2":
                                    controller.addDog(counter.getCount(), name, birthday);
                                    counter.add();
                                    break;
                                case "3":
                                    controller.addHamster(counter.getCount(), name, birthday);
                                    counter.add();
                                    break;
                                case "4":
                                    controller.addHorse(counter.getCount(), name, birthday);
                                    counter.add();
                                    break;
                                case "5":
                                    controller.addCamel(counter.getCount(), name, birthday);
                                    counter.add();
                                    break;
                                case "6":
                                    controller.addDonkey(counter.getCount(), name, birthday);
                                    counter.add();
                                    break;
                                default:
                                    System.out.println("Такой вид животных не предусмотрен");
                                    break;
                            }
                            break;
                        case "2": // Вывести список всех животных
                            List<Animal> animals = controller.getAll();
                            for (int i = 0; i < animals.toArray().length; i++) {
                                System.out.println(animals.get(i).toString());
                            }
                            break;
                        case "3": // Вывести информацию о животном по его id
                            System.out.println("Введите id:");
                            int id = Integer.parseInt(in.next());
                            System.out.println(controller.getAnimal(id).toString());
                            break;
                        case "4": // Обучить животное новым командам
                            System.out.println("Введите id животного: ");
                            int ID = Integer.parseInt(in.next());
                            System.out.println("Введите команду: ");
                            String commandForAnimal = in.next();
                            controller.addCommand(ID, commandForAnimal);
                            System.out.println("Команда добавлена");
                            break;
                        case "5": // Вывести список команд, которые выполняет животное
                            System.out.println("Введите id животного: ");
                            int Id = Integer.parseInt(in.next());
                            System.out.println(controller.getCommands(Id));
                            break;
                            case "6": // Удалить животное
                            System.out.println("Введите id животного для удаления:");
                            int animalIdToDelete = Integer.parseInt(in.next());
                            controller.deleteAnimal(animalIdToDelete);
                            System.out.println("Животное успешно удалено.");
                            break;
                        case "7": // Посчитать количество животных
                            System.out.println("Количество животных: " + counter.getCount());
                            break;
                        case "8": // Выход из меню
                            flag = false;
                            System.out.println("Вы выходите из меню. Всего доброго!");
                            break;
                        default:
                            System.out.println("Неверная команда. Попробуйте ещё раз.");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода. Пожалуйста, введите корректные данные.");
                } catch (Exception e) {
                    System.out.println("Произошла ошибка: " + e.getMessage());
                }
            }
        } finally {
            in.close();
        }
    }

    private String inputBirthday() {
        System.out.println("Введите дату рождения (в формате ДД.ММ.ГГГГ):");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
