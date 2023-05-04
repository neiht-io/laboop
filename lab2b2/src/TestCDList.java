/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */
import java.util.Scanner;

public class TestCDList {
    private static final int MAX_CD = 100;
    private static CDList cdList = new CDList(MAX_CD);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer
            switch (choice) {
                case 1:
                    addCD();
                    break;
                case 2:
                    displayNumCD();
                    break;
                case 3:
                    displayTotalPrice();
                    break;
                case 4:
                    sortByPriceDesc();
                    break;
                case 5:
                    sortByTitleAsc();
                    break;
                case 6:
                    displayAllCDs();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("===== CD LIST MANAGER =====");
        System.out.println("1. Add a CD to the list");
        System.out.println("2. Display the number of CDs in the list");
        System.out.println("3. Display the total price of CDs in the list");
        System.out.println("4. Sort the list in descending order by price");
        System.out.println("5. Sort the list in ascending order by title");
        System.out.println("6. Display all CDs in the list");
        System.out.println("0. Exit program");
    }

    private static void addCD() {
        System.out.print("Enter CD code: ");
        int maCD = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        System.out.print("Enter CD title: ");
        String tuaCD = scanner.nextLine();
        System.out.print("Enter number of songs: ");
        int soBaiHat = scanner.nextInt();
        System.out.print("Enter price: ");
        double giaThanh = scanner.nextDouble();
        CD cd = new CD(maCD, tuaCD, soBaiHat, giaThanh);
        if (cdList.addCD(cd)) {
            System.out.println("CD added successfully.");
        } else {
            System.out.println("CD could not be added.");
        }
    }

    private static void displayNumCD() {
        System.out.println("Number of CDs: " + cdList.getSize());
    }

    private static void displayTotalPrice() {
        System.out.println("Total price of CDs: " + cdList.getTotalPrice());
    }

    private static void sortByPriceDesc() {
        cdList.sortByPriceDesc();
        System.out.println("CDs sorted by price (descending).");
    }

    private static void sortByTitleAsc() {
        cdList.sortByTitleAsc();
        System.out.println("CDs sorted by title (ascending).");
    }

    private static void displayAllCDs() {
        System.out.println("===== ALL CDs =====");
        cdList.displayAllCDs();
    }
}
