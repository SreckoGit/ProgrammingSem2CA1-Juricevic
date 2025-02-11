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
public class Fish extends Animal {

    private String waterType;
    private String scalesType;

    private static final List<String> VALID_WATER_TYPES = Arrays.asList("Freshwater", "Saltwater");
    private static final List<String> VALID_SCALES_TYPES = Arrays.asList("Smooth", "Rough");

    public Fish(String specie1, String name2, String habitat3, String dob4, String weight5, String typeSpecific6)throws IllegalArgumentException {
        super(specie1, name2, habitat3, dob4, weight5);

        //decided to add my own values as file did not specify fish and bird patterns 
        String[] details = typeSpecific6.split(",");

        if (details.length >= 2) {
            // Validate and assign waterType
            if (!isValidWaterType(details[0])) {
                throw new IllegalArgumentException("Invalid water type: " + details[0]);
            }
            this.waterType = details[0];  // Assign valid waterType

            // Validate and assign scalesType
            if (!isValidScalesType(details[1])) {
                throw new IllegalArgumentException("Invalid scales type: " + details[1]);
            }
            this.scalesType = details[1];  // Assign valid scalesType
        } else {
            throw new IllegalArgumentException("Invalid type-specific format for Fish: " + typeSpecific6);
        }
    }

    //------------methods---------------
    public String getWaterType() {
        return waterType;
    }

    public String getScalesType() {
        return scalesType;
    }

    private boolean isValidWaterType(String waterType) {
        return VALID_WATER_TYPES.contains(waterType);
    }

    private boolean isValidScalesType(String scalesType) {
        return VALID_SCALES_TYPES.contains(scalesType);
    }
    
    
    @Override
    public String toString() {
        // Call the Animal's toString() to get common details
        String baseDetails = super.toString();
        // Append the details
        return baseDetails + ", Scales: " + scalesType + ", Water type: " + waterType;
    }

}
