/*
Title:CS112 Group Project

Student Name and ID: Hiba, 4358228 
Student Name and ID: Sahar, 4355980
Student Name and ID: Asma, 4350920
Student Name and ID: Razan, 4355941
 
Section: F16
 */
package testonlineshoppingstore;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestOnlineShoppingStore {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int id = 0;

        // use try catch to make sure the user enter integer id
        try {
            System.out.print("Enter user name: ");
            String name = input.nextLine();
            System.out.print("Enter user ID: ");
            id = input.nextInt();
        } catch (InputMismatchException z) {
            System.out.println("Wrong input");
            System.exit(0);
        }

        User admin1 = new User(4358228, "Hiba");
        User admin2 = new User(4350920, "Asma");
        User customer1 = new User(4355980, "Sahar");
        User customer2 = new User(4355941, "Razan");

        // make sure the user is registered using while loop
        while (true) {
            if (id == admin1.getUserID() || id == admin2.getUserID()) {
                admin();
                break;
            } else if (id == customer1.getUserID() || id == customer2.getUserID()) {
                customer();
                break;
            } else {
                System.out.println("you are not registered. Try again.");
                id = input.nextInt();
            }
        } // end loop

    } // end main method

    // a method to display the admin view and its menu
    static void admin() throws IOException {
        System.out.println("^^^^^^^^ Welcome to the Admin view ^^^^^^^^");
        System.out.println("Clothes File:");
        Clothes clothes = new Clothes();
        clothes.showItems();
        System.out.println("**************************************************");
        System.out.println("Makeup File:");
        MakeUp makeUp = new MakeUp();
        makeUp.showItems();
        System.out.println("**************************************************");

        // while loop to show menu of admin view
        boolean loop = true;
        while (loop) {
            System.out.println("Please choose from the following tasks:"
                    + "\n1-Add a clothe item"
                    + "\n2-Delete a clothe item"
                    + "\n3-Add a makeup item"
                    + "\n4-Delete a makeup item"
                    + "\n5-Exit the menue"
                    + "\n6-Exit the application"
                    + "\nEnter your choice: ");
            int choice = input.nextInt();
            String itemID;
            switch (choice) {

                // Add a clothe item
                case 1:
                    clothes.writeItems();
                    System.out.println("successfully added");

                    break;

                // Delete a clothe item
                case 2:
                    System.out.print("Enter an item ID to be deleted: ");
                    itemID = input.next();
                    if (clothes.searchItems(itemID)) {
                        clothes.deleteItems(itemID);
                        System.out.println("item was deleted successfully!");
                    } else {
                        System.out.println("the item is not found");
                    }
                    break;

                // Add a makeup item
                case 3:
                    makeUp.writeItems();
                    System.out.println("successfully added");
                    break;

                // Delete a makeup item
                case 4:
                    System.out.print("Enter an item ID to be deleted: ");
                    itemID = input.next();
                    if (makeUp.searchItems(itemID)) {
                        makeUp.deleteItems(itemID);
                        System.out.println("item was deleted successfully!");
                    } else {
                        System.out.println("the item is not found");
                    }
                    break;

                // Exit the menue
                case 5:
                    loop = false;
                    break;

                // Exit the application
                case 6:
                    System.exit(0);

                // if no cases is matched
                default:
                    System.out.println("invalid choice");
                    System.exit(0);
            } // end switch
        }
    } // end admin method

    // a method to display the customer view and its menu
    static void customer() throws IOException {
        System.out.println("^^^^^^^^ Welcome to the Customer view ^^^^^^^^");
        System.out.println("Clothes File:");
        Clothes clothes = new Clothes();
        clothes.showItems();
        System.out.println("**************************************************");
        System.out.println("Makeup File:");
        MakeUp makeUp = new MakeUp();
        makeUp.showItems();
        System.out.println("**************************************************");

        // while loop to show menu of customer view
        boolean loop = true;
        while (loop) {
            System.out.println("Please select from the following menu:"
                    + "\n1- Buy clothes"
                    + "\n2- Buy makeup"
                    + "\n3- Exit the menue"
                    + "\n4- Exit the application"
                    + "\nEnter your selection: ");
            int choice = input.nextInt();
            String itemID;
            switch (choice) {

                // Buy clothes
                case 1:
                    System.out.println("Please Enter the following information to buy clothes: ");
                    System.out.println("Enter itemID: ");
                    itemID = input.next();
                    if (clothes.searchItems(itemID)) {
                        clothes.setItemID(itemID);
                        System.out.print("Enter an item quantity: ");
                        int quantity = input.nextInt();
                        clothes.orderSummary(quantity);
                    } else {
                        System.out.println("the item is not found");
                    }
                    break;

                // Buy makeup
                case 2:
                    System.out.println("Please Enter the following information to buy MakeUp: ");
                    System.out.println("Enter itemID: ");
                    itemID = input.next();

                    if (makeUp.searchItems(itemID)) {
                        makeUp.setItemID(itemID);
                        System.out.print("Enter an item quantity: ");
                        int quantity2 = input.nextInt();
                        makeUp.orderSummary(quantity2);
                    } else {
                        System.out.println("the item is not found");
                    }
                    break;

                // Exit the menue
                case 3:
                    loop = false;
                    break;

                // Exit the application
                case 4:
                    System.exit(0);

                // if no cases is matched
                default:
                    System.out.println("invalid choice");
                    System.exit(0);
            } // end switch
        }
    } // end customer method

} // end TestOnlineShoppingStore class
