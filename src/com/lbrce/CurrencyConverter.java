package com.lbrce;

import java.util.Scanner;
import java.io.File;
import java.io.File;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Exchange rates: Modify these as per the current rates
    	
    	File file = new File("C:\\Users\\DELL\\Desktop\\Currency.txt");

        double usdToInr = 82.0;
        double eurToInr = 89.0;
        double gbpToInr = 101.0;
        double inrToUsd = 0.0122;
        double inrToEur = 0.0112;
        double inrToGbp = 0.0099;

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Get input from user
        System.out.println("Enter the amount to convert:");
        double amount = scanner.nextDouble();

        System.out.println("Enter source currency (USD, EUR, GBP, INR):");
        String sourceCurrency = scanner.next().toUpperCase();

        System.out.println("Enter target currency (USD, EUR, GBP, INR):");
        String targetCurrency = scanner.next().toUpperCase();

        // Variable to store the converted amount
        double convertedAmount = 0;

        // Perform currency conversion
        if (sourceCurrency.equals("USD") && targetCurrency.equals("INR")) {
            convertedAmount = amount * usdToInr;
        } else if (sourceCurrency.equals("EUR") && targetCurrency.equals("INR")) {
            convertedAmount = amount * eurToInr;
        } else if (sourceCurrency.equals("GBP") && targetCurrency.equals("INR")) {
            convertedAmount = amount * gbpToInr;
        } else if (sourceCurrency.equals("INR") && targetCurrency.equals("USD")) {
            convertedAmount = amount * inrToUsd;
        } else if (sourceCurrency.equals("INR") && targetCurrency.equals("EUR")) {
            convertedAmount = amount * inrToEur;
        } else if (sourceCurrency.equals("INR") && targetCurrency.equals("GBP")) {
            convertedAmount = amount * inrToGbp;
        } else if (sourceCurrency.equals(targetCurrency)) {
            convertedAmount = amount; // No conversion needed
        } else {
            System.out.println("Conversion rate not available for " + sourceCurrency + " to " + targetCurrency);
            System.exit(0);
        }

        // Print the result
        System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);

        // Close scanner
        scanner.close();
    }
}
