/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author Sjuri
 */
import java.util.ArrayList;
import java.util.Scanner;
import models.*;

public class AnimalZoo {

    //receives the list of objects from main
    private ArrayList<Animal> animals;
    private Scanner scanner;

    //constructor
    public AnimalZoo(ArrayList<Animal> animals) {
        this.animals = animals;
        this.scanner = new Scanner(System.in);
    }

    //the beginning loop menu tat calls other menus for display or creation of animal objects
    public void start() {

        while (true) {
            System.out.println("\n Welcome to Dublin Zoo!");
            System.out.println("1 - See all animals");
            System.out.println("2 - Search by type");
            System.out.println("3 - Search by habitat");
            System.out.println("4 - Add new animal");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine(); // Reading as string first

            int choice;
            try {
                //this parsing is also a check for letters
                choice = Integer.parseInt(input); // Convert to number
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue; // Restart loop
            }
            //methods called depending on case value, newer type of switch used for practicce
            switch (choice) {
                case 1 ->
                    displayAllAnimals();
                case 2 ->
                    searchByTypeMenu();
                case 3 ->
                    searchByHabitatMenu();
                case 4 ->
                    addNewAnimal();
                case 0 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default ->
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //loops through list and displays all
    private void displayAllAnimals() {
        System.out.println("\n--- All Animals ---");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    //offers menu to search by type and calls displayAnimalsByType(String type) which displays matching from the list
    private void searchByTypeMenu() {
        int typeChoice;
        while (true) {
            System.out.println("\nSelect an animal type:");
            System.out.println("1 - Mammal");
            System.out.println("2 - Bird");
            System.out.println("3 - Fish");
            System.out.println("4 - Reptile");
            System.out.println("0 - Back to main menu");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine(); // Read input as a string

            try {
                typeChoice = Integer.parseInt(input);   //parsing input and covering a case of user entering letters
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue; // Restart the loop
            }

            if (typeChoice == 0) {
                return; //return if typeChoice is 0(to start() loop where this is called from),
            }            //if not, i've assign returned matched value to type,

            //using a newer type of switch expressions from java 14, where you can return 
            //a value using switch:
            String type = switch (typeChoice) {
                case 1 ->
                    "Mammal";
                case 2 ->
                    "Bird";
                case 3 ->
                    "Fish";
                case 4 ->
                    "Reptile";
                default ->
                    null;        //if 5 was given that will result in null returned
            };

            //now working with type we got from switch, but checking if proper number was given before:
            if (type != null) {
                displayAnimalsByType(type);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    
    //habitat menu that offers switch options and calls displayAnimalsByHabitat(String habitat), displaying matching from the list
    private void searchByHabitatMenu() {
        int habitatChoice;
        while (true) {
            System.out.println("\nSelect an animal habitat:");
            System.out.println("1 - Desert");
            System.out.println("2 - Grassland");
            System.out.println("3 - Mountain");
            System.out.println("4 - Rainforest");
            System.out.println("5 - Forest");
            System.out.println("6 - Savannah");
            System.out.println("7 - Pond");
            System.out.println("8 - Ocean");
            System.out.println("9 - Swamp");
            System.out.println("0 - Back to main menu");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine(); // Read input as a string

            try {
                habitatChoice = Integer.parseInt(input);   //parsing input and covering a case of user entering letters
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue; // Restart the loop
            }

            if (habitatChoice == 0) {
                return; //return if typeChoice is 0(to start() loop where this is called from),
            }            //if not, i've assign returned matched value to type,

            //using a newer type of switch expressions from java 14, where you can return 
            //a value using switch:
            String chosenHabitat = switch (habitatChoice) {
                case 1 ->
                    "Desert";
                case 2 ->
                    "Grassland";
                case 3 ->
                    "Mountain";
                case 4 ->
                    "Rainforest";
                case 5 ->
                    "Forest";
                case 6 ->
                    "Savannah";
                case 7 ->
                    "Pond";
                case 8 ->
                    "Ocean";
                case 9 ->
                    "Swamp";
                default ->
                    null;        //any other num turns default
            };

            //now working with type we got from switch, but checking if proper number was given before:
            if (chosenHabitat != null) {
                displayAnimalsByHabitat(chosenHabitat);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    
    
    //displayAnimalsByType goes through all the animals list that AnimalZoo received and holds,
    //printing out matching ones , and if none found, prints a message
    private void displayAnimalsByType(String type) {
        System.out.println("\n--- " + type + " ---");
        boolean found = false;

        for (Animal animal : animals) {
            //getting class name as string without package name with getSimpleName() call, then ignoring case in comparison:
            if (animal.getClass().getSimpleName().equalsIgnoreCase(type)) {
                found = true;

                System.out.println(animal);
            }
        }

        if (!found) {
            System.out.println("No " + type.toLowerCase() + "s found.");
        }
    }

    
    //prints out animals whose habitat field matches the chosen one in menu
    private void displayAnimalsByHabitat(String habitat) {
        System.out.println("\n--- " + habitat + " ---");
        boolean found = false;

        for (Animal animal : animals) {
            // Compare the animal's habitat to the provided habitat string (ignoring case)
            if (animal.getHabitat().equalsIgnoreCase(habitat)) {
                found = true;

                System.out.println(animal);
            }
        }

        if (!found) {
            System.out.println("No " + habitat.toLowerCase() + "s found.");
        }
    }

    
    /**
 *
 * Displays menu requesting information for creation of animal subclass objects,
 * first variable type is used to request (in if-else statements) specific fields for 
 * 4 Animal subclasses and finalize the creation of object. 
 * "0" for exit is offered in every entry to return to previous menu.
 * Specie type is checked/validated after input, with "continue" if invalid to reset loop.
 * Habitat type is checked/validated after input, with "continue" if invalid to reset loop.
 * 
 * 
 */
    private void addNewAnimal() {
        while (true) {
            try {
                System.out.print("Enter animal type (Mammal, Bird, Fish, Reptile), 0 to exit: ");
                String type = scanner.nextLine().trim();
                if (type.equals("0")) {
                    return;
                }else if (!AnimalType.isValid(type)) {
                    System.out.println("Invalid type: " + type + ". Please try again.");
                    continue;
                }

                System.out.print("Enter specie (Dog, Dragon, Eagle, Goldfish, Wolf, Snake, Parrot, Shark,\n"
                        + "Tiger, Lion, Bear, Owl, Crocodile, Dolphin, Penguin, Elephant,\n"
                        + "Kangaroo, Turtle, Fox, Octopus), 0 to exit: ");
                String specie = scanner.nextLine().trim();
                if (specie.equals("0")) {
                    return;
                } else if (!SpeciesType.isValid(specie)) {                  //validating species after input and 0 check
                    System.out.println("Invalid specie: " + specie + ". Please try again.");
                    continue;
                }

                System.out.print("Enter name, 0 to exit: ");
                String name = scanner.nextLine().trim();
                if (name.equals("0")) {
                    return;
                }

                System.out.print("Enter habitat (Desert, Grassland, Mountain, Rainforest, Forest, Savannah, Pond, Ocean, Swamp), 0 to exit:");
                String habitat = scanner.nextLine().trim();
                if (habitat.equals("0")) {
                    return;
                }else if (!HabitatType.isValid(habitat)) {
                    System.out.println("Invalid habitat: " + habitat + ". Please try again.");
                    continue;
                }

                System.out.print("Enter Date of Birth (yyyy/MM/dd), 0 to exit: ");
                String dob = scanner.nextLine().trim();
                if (dob.equals("0")) {
                    return;
                }

                System.out.print("Enter weight, 0 to exit: ");
                String weight = scanner.nextLine().trim();
                if (weight.equals("0")) {
                    return;
                }

                //every type here has it's own checks in constructor that throw IllegalArgumentException
                //on on their own check of valid values and types, against their Lists of 
                //allowed values
                String extraInfo = "";
                if (type.equalsIgnoreCase("Mammal")) {
                    System.out.print("Enter colour (White, Black, Brown, Gray, Spotted, Striped), 0 to exit: ");
                    String colour = scanner.nextLine().trim();
                    if (colour.equals("0")) {
                        return;
                    }

                    System.out.print("Enter pattern (Spots, Stripes, Solid, Checkered), 0 to exit: ");
                    String pattern = scanner.nextLine().trim();
                    if (pattern.equals("0")) {
                        return;
                    }

                    extraInfo = colour + "," + pattern; //building the string, items separated by "," for subclass constructor

                    Animal animal = new Mammal(specie, name, habitat, dob, weight, extraInfo);
                    animals.add(animal);
                    System.out.println("Sucess! "+ animal.toString());
                    break;

                } else if (type.equalsIgnoreCase("Bird")) {
                    System.out.print("Can the bird fly? true-false, 0 to exit: ");
                    String tfValue = scanner.nextLine().trim();
                    if (tfValue.equals("0")) {
                        return;
                    }

                    System.out.print("Enter colour (White, Black, Brown, Grey, Yellow, Red, Blue, Green), 0 to exit: ");
                    String colour = scanner.nextLine().trim();
                    if (colour.equals("0")) {
                        return;
                    }

                    extraInfo = tfValue + "," + colour;  //building the string,2 items separated by "," for subclass constructor

                    Animal animal = new Bird(specie, name, habitat, dob, weight, extraInfo);
                    animals.add(animal);
                    System.out.println("Sucess! "+ animal.toString());
                    break;

                } else if (type.equalsIgnoreCase("Fish")) {
                    System.out.print("Enter water type (Freshwater/Saltwater, 0 to exit: ");
                    String waterType = scanner.nextLine().trim();
                    if (waterType.equals("0")) {
                        return;
                    }

                    System.out.print("Enter scale-type(Smooth/Rough), 0 to exit: ");
                    String scales = scanner.nextLine().trim();
                    if (scales.equals("0")) {
                        return;
                    }

                    extraInfo = waterType + "," + scales; //building the string,2 items separated by "," for subclass constructor

                    Animal animal = new Fish(specie, name, habitat, dob, weight, extraInfo);
                    animals.add(animal);
                    System.out.println("Sucess! "+ animal.toString());
                    break;

                } else if (type.equalsIgnoreCase("Reptile")) {
                    System.out.print("Enter attack type (Bite, Claw, Fire, Venomous, Sting, 0 to exit: ");
                    String attackType = scanner.nextLine().trim();
                    if (attackType.equals("0")) {
                        return;
                    }

                    System.out.print("Enter favourie food (Eggs, Meat, Fish, Insects, Plants, Small mammals, Dwarves), 0 to exit: ");
                    String food = scanner.nextLine().trim();
                    if (food.equals("0")) {
                        return;
                    }

                    extraInfo = attackType + "," + food;  //building the string,2 items separated by "," for subclass constructor

                    Animal animal = new Reptile(specie, name, habitat, dob, weight, extraInfo);
                    animals.add(animal);
                    System.out.println("Sucess! "+ animal.toString());
                    break;

                } else {
                    System.out.println("Did not receive a proper type: " + type + ", Please try again.");
                    continue; //stop execution of the remaining code in the loop body and restart the loop.
                }//end of type checks and constuctor calls 

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + ". Please try again.");
                continue;
            }
        }

    }

}//end of AnimalZoo
