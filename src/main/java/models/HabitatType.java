/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Sjuri
 */
public enum HabitatType {
    ARCTIC_SEA, 
    ARCTIC_ISLANDS, 
    CAATINGA, 
    CAVE, 
    DESERT, 
    GRASSLAND, 
    MARINE, 
    MOUNTAIN, 
    RAINFOREST, 
    FOREST, 
    SAVANNAH,
    POND,
    TROPICAL_SEA,
    OCEAN,
    SWAMP;

    public static boolean isValid(String habitat) {
        for (HabitatType h : HabitatType.values()) {
            if (h.name().replace("_", " ").equalsIgnoreCase(habitat)) {
                return true;
            }
        }
        return false;  //else version
    }
}
