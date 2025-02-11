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
    DESERT, 
    GRASSLAND,  
    MOUNTAIN, 
    RAINFOREST, 
    FOREST, 
    SAVANNAH,
    POND,
    OCEAN,
    SWAMP;

    public static boolean isValid(String habitat) {
        for (HabitatType h : HabitatType.values()) {
            if (h.name().equalsIgnoreCase(habitat)) {
                return true;
            }
        }
        return false;  //else version
    }
}
