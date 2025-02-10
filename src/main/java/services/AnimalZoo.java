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
import models.Animal;

public class AnimalZoo {

    //receives the list of objects from main
    private ArrayList<Animal> animals;
    private Scanner scanner;

    //constructor
    public AnimalZoo(ArrayList<Animal> animals) {
        this.animals = animals;
        this.scanner = new Scanner(System.in);
    }

    //the beginning loop menu
    public void start() {

        while (true) {
            System.out.println("\n Welcome to Dublin Zoo!");
            System.out.println("1 - See all animals");
            System.out.println("2 - Search by type");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");
            
            String input = scanner.nextLine(); // Reading as string first

            int choice;
            try {
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

    private void displayAllAnimals() {
        System.out.println("\n--- All Animals ---");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

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
                typeChoice = Integer.parseInt(input);
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

    private void displayAnimalsByType(String type) {
        System.out.println("\n--- " + type + " ---");
    boolean found = false;

    for (Animal animal : animals) {
        if (animal.getClass().getSimpleName().equalsIgnoreCase(type)) {
            found = true;

            // Print animal details in a more readable way
//            System.out.println("Name: " + animal.getName());
//            System.out.println("Species: " + animal.getSpecie());
//            System.out.println("Habitat: " + animal.getHabitat());
//            System.out.println("");
//            System.out.println("-------------------");
              System.out.println(animal);
        }
    }

    if (!found) {
        System.out.println("No " + type.toLowerCase() + "s found.");
    }
    }
}
