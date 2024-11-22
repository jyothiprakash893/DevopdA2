package com.lbrce;

import java.util.*;
import java.io.*;

public class CurrencyConverter {

    public static void main(String[] args) {
        // Load exchange rates from file
        String filePath = "C:\\Users\\DELL\\Desktop\\Currency.txt"; // Adjust path if needed
        Map<String, Double> exchangeRates = loadRatesFromFile(filePath);

        // Default values for Jenkins or non-interactive environments
        double amount = args.length > 0 ? Double.parseDouble(args[0]) : 100.0;
        String sourceCurrency = args.length > 1 ? args[1].toUpperCase() : "USD";
        String targetCurrency = args.length > 2 ? args[2].toUpperCase() : "INR";

        // Perform conversion
        double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency, exchangeRates);

        // Print the result
        System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
    }

    /**
     * Loads currency exchange rates from a file.
     * The file should have lines in the format: USD_INR=82.0
     *
     * @param filePath Path to the rates file.
     * @return Map of currency conversion rates.
     */
    private static Map<String, Double> loadRatesFromFile(String filePath) {
        Map<String, Double> rates = new HashMap<>();
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains("=")) {
                    String[] parts = line.split("=");
                    rates.put(parts[0].trim().toUpperCase(), Double.parseDouble(parts[1].trim()));
                }
            }
            System.out.println("Exchange rates loaded successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("Error: Rates file not found at " + filePath);
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Error reading rates file: " + e.getMessage());
            System.exit(1);
        }
        return rates;
    }

    /**
     * Converts the amount from the source currency to the target currency.
     *
     * @param amount         The amount to convert.
     * @param sourceCurrency The source currency code (e.g., USD).
     * @param targetCurrency The target currency code (e.g., INR).
     * @param rates          The map containing exchange rates.
     * @return The converted amount.
     */
    private static double convertCurrency(double amount, String sourceCurrency, String targetCurrency, Map<String, Double> rates) {
        if (sourceCurrency.equals(targetCurrency)) {
            return amount; // No conversion needed
        }

        String key = sourceCurrency + "_" + targetCurrency;
        if (rates.containsKey(key)) {
            return amount * rates.get(key);
        } else {
            System.err.println("Conversion rate not available for " + sourceCurrency + " to " + targetCurrency);
            System.exit(1);
        }
        return 0; // Unreachable
    }
}
