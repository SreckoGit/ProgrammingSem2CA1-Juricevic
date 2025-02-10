/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package app;

import java.util.ArrayList;
import services.FileReaderServices;
import java.io.IOException;
import models.Animal;
import services.AnimalZoo;

/**
 *
 * @author Sjuri
 */
public class Main {

    public static void main(String[] args) {

        try {
            // Read file and create animals in one step

            ArrayList<Animal> animals = factory.AnimalFactory.createAnimals(FileReaderServices.readFile("animals.txt"));
//            System.out.println("Current Working Directory: " + System.getProperty("user.dir"));

            System.out.println("Animals created successfully!");

            //passing the list to AnimalZoo class and starting the menu 
            AnimalZoo zoo = new AnimalZoo(animals);
            zoo.start();

            //managing all the exceptions being thrown from reading to object making
        } catch (IOException e) {
            System.err.println("File error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Data error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }//end of main

}//end of Main class
