package warmup.staticmembers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Program that converts temperature from Celsius to Fahrenheit 
 * @author Ramona
 */
public class TemperatureConverter {

    /**
     * The input data will be in format: {temperature} {unit}.
     * Temperatures will be in integer number and units will be
     * one of these two values: Celsius / Fahrenheit. 
     * @param String input 
     */
    private static void tempConverter(String input) {
        
        String[] splitted = input.split(" ");
        
        String unit = splitted[1];
        int temp = Integer.parseInt(splitted[0]);
        
        double tempConverted = 0.0D;
        String unitConverted = "";
        
     
        if (unit.equals("Celsius")) {
            tempConverted = (temp * 1.8) + 32;
            unitConverted = "Fahrenheit";
        } else {
            tempConverted = (temp - 32) / 1.8;
            unitConverted = "Celsius";
        }

      
        System.out.println(String.format("%.2f", tempConverted)+ " " + unitConverted);
    }

    public static void main(String[] args) {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        // receive input, until receive command "End"
        try {
            while (!(input = bReader.readLine()).equals("End")) {
                    tempConverter(input);
            }
        } catch (IOException ioex) {
            System.out.println("I/O Exception " + ioex.getMessage());
        }

    }

}
