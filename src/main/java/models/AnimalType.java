/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Sjuri
 */
public enum AnimalType {
    MAMMAL, BIRD, FISH, REPTILE;
    
    //method checks received string against every value of enum
    //returns true if they are equal in equalsIgnoreCase
    public static boolean isValid(String type) {
        for (AnimalType a : AnimalType.values()) {
            if (a.name().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }
}
