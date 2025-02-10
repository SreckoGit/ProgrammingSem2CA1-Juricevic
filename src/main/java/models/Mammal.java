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
public class Mammal extends Animal {

    private String colour;
    private String pattern;
    private static final List<String> VALID_COLOURS = Arrays.asList("White", "Black", "Brown", "Gray", "Spotted", "Striped");
    private static final List<String> VALID_PATTERNS = Arrays.asList("Spots", "Stripes", "Solid", "Checkered");

    //my constructor that checks for specific 
    public Mammal(String specie1, String name2, String habitat3, String dob4, String weight5, String typeSpecific6) {
        super(specie1, name2, habitat3, dob4, weight5);

        // Split the type-specific string
        String[] details = typeSpecific6.split(",");

        //following pattern for mammal, second one in file is value of first and i hardcoded 
        //Mammal class with those two fields, instead going for Map with key value, 
        //which might be safer bet as 0 in line 4 could potentially be something else next time than colour
        if (details.length >= 2) {
            String tempColour = details[0];
            if (!isValidColour(tempColour)) {
                throw new IllegalArgumentException("Invalid mammal colour value: " + tempColour);
            }
            this.colour = tempColour;
            
            // Validate and assign pattern
            String tempPattern = details[1];
            if (!isValidPattern(tempPattern)) {
                throw new IllegalArgumentException("Invalid mammal pattern value: " + tempPattern);
            }
            this.pattern = tempPattern;
            
        } else {
            throw new IllegalArgumentException("Invalid type-specific format for Mammal: " + typeSpecific6);
        }
    }
    
    // -----------methods--------------------------

    public String getColour() {
        return colour;
    }

    public String getPattern() {
        return pattern;
    }
    
    
    private boolean isValidColour(String colour) {
        return VALID_COLOURS.contains(colour);
    }

    // Validate if the pattern is in the list of valid patterns
    private boolean isValidPattern(String pattern) {
        return VALID_PATTERNS.contains(pattern);
    }

    @Override
    public String toString() {
        // Call the Animal's toString() to get common details
        String baseDetails = super.toString();
        // Append the Mammal-specific details
        return baseDetails + ", Colour: " + colour + ", Pattern: " + pattern;
    }
    
    
}
