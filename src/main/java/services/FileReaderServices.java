/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import java.io.*;
import java.util.*;
/**
 *
 * @author Sjuri
 */
public class FileReaderServices {

    public static ArrayList<String[]> readFile(String filePath) throws IOException {
        // List to store each animal's data as a String array
        ArrayList<String[]> list = new ArrayList<>();

        // Line counter to track where errors occur
        int lineCount = 1;

        // Get file as a resource
        InputStream inputStream = FileReaderServices.class.getClassLoader().getResourceAsStream(filePath);


        // Using try-with-resources to ensure the Scanner is closed automatically
        try (Scanner scanner = new Scanner(new InputStreamReader(inputStream))) {

            // Read the file in chunks of 4 lines
            while (scanner.hasNext()) {

                // creating an array to hold animal details
                String[] fields = new String[8];  

                // Read four lines per animal entry
                for (int i = 0; i < 4; i++) {

                    // making sure the file has more lines to read, otherwise throw an error
                    if (!scanner.hasNext()) {
                        throw new IOException("Unexpected end of file at line " + lineCount);
                    }

                    // Read the current line and split it by commas
                    String[] tempLineString = scanner.nextLine().split(",");

                    // Populate the fields array based on which line of the 4-line structure we are processing (i in loop)
                    switch (i) {
                        case 0 -> {
                            // Line 1: Animal Type, Species, Name
                            if (tempLineString.length >= 3) {
                                fields[0] = tempLineString[0]; // Animal Type 
                                fields[1] = tempLineString[1]; // Species 
                                fields[2] = tempLineString[2]; // Name 
                            } else {
                                throw new IOException("Invalid format at line " + lineCount);
                            }
                        }
                        case 1 -> {
                            // Line 2: Habitat
                            if (tempLineString.length >= 1) {
                                fields[3] = tempLineString[0];
                            } else {
                                throw new IOException("Invalid format at line " + lineCount);
                            }
                        }
                        case 2 -> {
                            // Line 3: Date of Birth and Weight
                            if (tempLineString.length >= 2) {
                                fields[4] = tempLineString[0]; // Date of Birth 
                                fields[5] = tempLineString[1]; // Weight
                            } else {
                                throw new IOException("Invalid format at line " + lineCount);
                            }
                        }
                        case 3 -> {
                            // Line 4: Type-specific data (multiple values)
                            // Store the data as a List<String> to handle varying numbers of parameters
                            if (tempLineString.length >= 1) {
                                fields[6] = String.join(",", tempLineString);  // Join all the type-specific data with commas
                            } else {
                                throw new IOException("Invalid format at line " + lineCount);
                            }
                        }
                        default -> throw new IOException("Unexpected case in data processing.");
                    }

                    // Increment line counter for each processed line
                    lineCount++;
                }

                // Store the line range for error reference
                fields[7] = "Lines " + (lineCount - 4) + " to " + (lineCount - 1);

                // Add the structured data to the list
                list.add(fields);     // Add the structured data to the list

            } // end of loop
        }

        return list; // Return the structured list of animal data
    }
}
