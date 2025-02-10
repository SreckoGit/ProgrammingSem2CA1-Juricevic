/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author Sjuri
 * @return parsed LocalDate
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//this class helps with ensuring date standard everywhere in the code,
//enen though we format date here , default LocalDate toString changes slash into dash,
//and needs to be formatted in get date
public class DateValidator {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public static LocalDate parseDate(String dateString) {
        try {
            return LocalDate.parse(dateString, FORMATTER); // Parse the string into LocalDate
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected yyyy/MM/dd: " + dateString);
        }
    }

    
}
