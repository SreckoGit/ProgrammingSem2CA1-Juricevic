/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sjuri
 * Few of thousands possible, but for simplicity sake list will be kept short
 */
public enum SpeciesType {
    DOG, DRAGON, EAGLE, GOLDFISH, WOLF, SNAKE, PARROT, SHARK,  
    TIGER, LION, BEAR, OWL, CROCODILE, DOLPHIN, PENGUIN, ELEPHANT,  
    KANGAROO, TURTLE, FOX, OCTOPUS;

    /**
     * 
     * @param specie
     * @param type
     * @return true/false 
     * gets species allowed for a certain type, then compares the species in parameters 
     * with allowed species for the type, this prevents creation of a Fish object that is species Elephant
     */
    public static boolean isValidForType(String specie, String type) {
        List<SpeciesType> validSpecies = getValidSpeciesForType(type); //call for allowed species for the type
        try {
            SpeciesType speciesType = SpeciesType.valueOf(specie.toUpperCase());
            return validSpecies.contains(speciesType);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // Get the valid species list for a given type
    private static List<SpeciesType> getValidSpeciesForType(String type) {
        switch (type.toUpperCase()) {
            case "MAMMAL":
                return Arrays.asList(DOG, WOLF, TIGER, LION, BEAR, ELEPHANT, KANGAROO, FOX);
            case "BIRD":
                return Arrays.asList(EAGLE, PARROT, OWL, PENGUIN);
            case "FISH":
                return Arrays.asList(GOLDFISH, SHARK, DOLPHIN);
            case "REPTILE":
                return Arrays.asList(SNAKE, CROCODILE, TURTLE);
            default:
                return new ArrayList<>(); // Invalid type
        }
    }
}
