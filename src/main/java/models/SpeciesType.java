/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Sjuri
 * Few of thousands possible, but for simplicity sake list will be kept short
 */
public enum SpeciesType {
    DOG, DRAGON, EAGLE, GOLDFISH, WOLF, SNAKE, PARROT, SHARK,  
    TIGER, LION, BEAR, OWL, CROCODILE, DOLPHIN, PENGUIN, ELEPHANT,  
    KANGAROO, TURTLE, FOX, OCTOPUS;

    public static boolean isValid(String input) {
        for (SpeciesType species : SpeciesType.values()) {
            if (species.name().equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }
}
