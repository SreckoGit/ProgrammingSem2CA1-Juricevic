/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sjuri
 */
public class Reptile extends Animal {

    private String attackType;
    private String favouriteFood;

    private static final List<String> VALID_ATTACK_TYPES = Arrays.asList("Bite", "Claw", "Fire", "Venomous", "Sting");
    private static final List<String> VALID_FAVOURITE_FOODS = Arrays.asList("Eggs","Meat", "Fish", "Insects", "Plants", "Small mammals", "Dwarves");

    //my constructor 
    public Reptile(String specie, String name, String habitat, String dob, String weight, String typeSpecific6)throws IllegalArgumentException {
        super(specie, name, habitat, dob, weight);

        String[] details = typeSpecific6.split(",");

        if (details.length >= 2) {
            //Validate attackType, if false throw exception
            if (!isValidAttackType(details[0])) {
                throw new IllegalArgumentException("Invalid attack type: " + details[0]);
            }
            this.attackType = details[0];  // Assign valid attackType

            // Validate favouriteFood
            if (!isValidFavouriteFood(details[1])) {
                throw new IllegalArgumentException("Invalid favourite food: " + details[1]);
            }
            this.favouriteFood = details[1];  //Assign valid favouriteFood
        }else {
            throw new IllegalArgumentException("Invalid type-specific format for Reptile: " + typeSpecific6);
        }
    }

    //----------------methods------------------
    public String getAttackType() {
        return attackType;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    private boolean isValidAttackType(String attackType) {
        return VALID_ATTACK_TYPES.contains(attackType);
    }

    private boolean isValidFavouriteFood(String favouriteFood) {
        return VALID_FAVOURITE_FOODS.contains(favouriteFood);
    }
    
    @Override
    public String toString() {
        // Call the Animal's toString() to get common details
        String baseDetails = super.toString();
        // Append the Reptile specific details
        return baseDetails + ", Attack type: " + attackType + ", Favourite food: " + favouriteFood;
    }
    
    
}
