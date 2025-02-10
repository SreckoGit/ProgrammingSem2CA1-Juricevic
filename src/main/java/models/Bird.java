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
public class Bird extends Animal{
    
    private boolean canFly; //is first in bird String 
    private String colour;  //secoond string after first ","
    
    
     private static final List<String> VALID_COLOURS = List.of("White", "Black", "Brown", "Grey", "Yellow", "Red", "Blue", "Green");
    
    //constructor 
    public Bird(String specie1, String name2, String habitat3, String dob4, String weight5,String birdSpecific6) {
        super(specie1, name2, habitat3, dob4, weight5);
        
        // Split type-specific data from index 6, separated by ","
        String[] details = birdSpecific6.split(",");
        
         
        if (details.length >= 2) {
            //1st check if we have proper boolean in STring format
            if (!details[0].equalsIgnoreCase("true") && !details[0].equalsIgnoreCase("false")) {
                //this breaks the creation oof bird
                throw new IllegalArgumentException("Invalid canFly value for Bird: " + details[0]);
            }
            //------------2nd then parsing first index as boolean
            this.canFly = Boolean.parseBoolean(details[0]);
            
            //------------getting second index as String
             if (!isValidColour(details[1])) {
                throw new IllegalArgumentException("Invalid colour for Bird: " + details[1]);
            }
            this.colour = details[1];
        }else {
    throw new IllegalArgumentException("Invalid Bird attributes: " + Arrays.toString(details));
}
        
        
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public String getColour() {
        return colour;
    }

    
    private boolean isValidColour(String colour){
        return VALID_COLOURS.contains(colour);
    }
    
    
    
    @Override
    public String toString() {
        // Call the Animal's toString() to get common details
        String baseDetails = super.toString();
        // Appending the specific details
        return baseDetails + ", Colour: " + colour + ", I can fly: " + canFly;
    }
    
    
}
