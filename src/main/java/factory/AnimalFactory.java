/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import java.util.ArrayList;
import models.*; //all the models imported

/**
 *
 * @author Sjuri
 */
public class AnimalFactory {

    /**
 *  Method receives a String array and loops through it, checking Habitat, type of animal and creating objects, 
    placing into animals ArrayList and returning it
 * @param fileData receives String array from FileReadingServices call in main()
 * @return animals ArrayList
 * @throws IllegalArgumentException for invalid habitat or animal type
 */
    //
    public static ArrayList<Animal> createAnimals(ArrayList<String[]> fileData) throws IllegalArgumentException {

        ArrayList<Animal> animals = new ArrayList<>();

        // Loop through each set of animal data
        for (String[] data : fileData) {
            Animal animal = null;

            if (!models.HabitatType.isValid(data[3])) {
                throw new IllegalArgumentException("Invalid habitat type: " + data[3]);
            }
            
            // Example: assume data[0] is the animal type, rest is data in string format to be converted in animal class
            switch (data[0].toUpperCase()) {
                case "MAMMAL":
                    animal = new Mammal(data[1], data[2], data[3], data[4], data[5], data[6]);
                    break;
                case "BIRD":
                    animal = new Bird(data[1], data[2], data[3], data[4], data[5], data[6]);
                    break;
                case "FISH":
                    animal = new Fish(data[1], data[2], data[3], data[4], data[5], data[6]);
                    break;
                case "REPTILE":
                    animal = new Reptile(data[1], data[2], data[3], data[4], data[5], data[6]);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid animal type: " + data[0]);
            }
            
            animals.add(animal);
        }

        return animals; // Return the list of created animals
    }

}
