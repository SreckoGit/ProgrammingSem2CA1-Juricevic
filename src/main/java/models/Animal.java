/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Sjuri
 */
public abstract class Animal {
    
    //did not include type as will search by classname as that is the type
    private String specie;
    private String name;
    private String habitat;
    private LocalDate dob;
    private double weight;
    

    
    /**
 * Constructor initialises String fields, validates date, parses double
 * @param dob4 received as string, parsed into LocalDate after validation
 * @param habitat3 was validated before this constructor call in AnimalFactory
 * @param weight5 is being parsed from String into Double
 */
    public Animal(String specie1, String name2, String habitat3, String dob4, String weight5) {
        this.specie = specie1;
        this.name = name2;
        this.habitat = habitat3;
        this.dob = services.DateValidator.parseDate(dob4);  //parsing string 
        // Convert the weight string to double and handle potential exceptions
        try {
            this.weight = Double.parseDouble(weight5);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid weight format for Mammal: " + weight5);
        }
        
    }

    
    
    public String getSpecie() {
        return specie;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getHabitat() {
        return habitat;
    }

    //animals should be able to change their habitats if they wish so,
    //we still need to check/verify
    public void setHabitat(String newHabitat) {
        if (HabitatType.isValid(newHabitat))
        this.habitat = newHabitat;
    }

    //because of default toString behaviour for local date, i needed to make sure it's 
    //going out formatted as yyyy/mm/dd 
    public String getFormattedDob() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return dob.format(formatter);
    }

    //checks in DateValidator if the date is valid format
    public void setDob(String dob) {
        this.dob = services.DateValidator.parseDate(dob);
    }

    //potential code for display/edit case not yet developed
    public double getWeight() {
        return weight;
    }

    //if need be the scanner in menu will always be reading string annd parsing later so i am following the pattern
    public void setWeight(String weight) {
        
        try {
            this.weight = Double.parseDouble(weight);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid weight format for Mammal: " + weight);
        }
    }

    
    

    @Override
    public String toString() {
        return "Animal is specie: " + specie + ", name: " + name + ", habitat: " + habitat + ", dob: " + getFormattedDob() + ", weight: " + weight;
    }
    
    
    
    
}
