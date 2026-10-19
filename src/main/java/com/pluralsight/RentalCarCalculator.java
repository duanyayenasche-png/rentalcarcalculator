package com.pluralsight;

import java.util.Scanner;

public class RentalCarCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

// Constants
        final double DAILY_RENTAL_RATE = 29.99;
        final double TOLL_TAG_RATE = 3.95;
        final double GPS_RATE = 2.95;
        final double ROADSIDE_RATE = 3.95;
// User input
        System.out.print("Enter pickup date: ");
        String pickupDate = scanner.nextLine();

        System.out.print("Enter number of rental days: ");
        int rentalDays = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Would you like an electronic toll tag ($3.95/day)? (yes/no): ");
        String tollTag = scanner.nextLine();

        System.out.print("Would you like GPS ($2.95/day)? (yes/no): ");
        String gps = scanner.nextLine();

        System.out.print("Would you like roadside assistance ($3.95/day)? (yes/no): ");
        String roadside = scanner.nextLine();

        System.out.print("Enter your current age: ");
        int age = scanner.nextInt();

// Cost calculations
        double baseCost = rentalDays * DAILY_RENTAL_RATE;
        double tollCost = tollTag.equalsIgnoreCase("yes") ? rentalDays * TOLL_TAG_RATE : 0;
        double gpsCost = gps.equalsIgnoreCase("yes") ? rentalDays * GPS_RATE : 0;
        double roadsideCost = roadside.equalsIgnoreCase("yes") ? rentalDays * ROADSIDE_RATE : 0;

// Young driver surcharge ($30/day if under 25)
        double underageSurcharge = 0;
        if (age < 25) {
            underageSurcharge = rentalDays * 30.00;
        }

        double totalCost = baseCost + tollCost + gpsCost + roadsideCost + underageSurcharge;

// Output
        System.out.println("\nRental Car Estimate");
        System.out.println("-------------------");
        System.out.println("Pickup Date: " + pickupDate);
        System.out.println("Rental Days: " + rentalDays);
        System.out.printf("Base Rental Cost: $%.2f%n", baseCost);
        System.out.printf("Electronic Toll Tag: $%.2f%n", tollCost);
        System.out.printf("GPS Cost: $%.2f%n", gpsCost);
        System.out.printf("Roadside Assistance: $%.2f%n", roadsideCost);
        System.out.printf("Underage Driver Surcharge: $%.2f%n", underageSurcharge);
        System.out.println("-------------------");
        System.out.printf("Total Estimated Cost: $%.2f%n", totalCost);

        scanner.close();

    }
}