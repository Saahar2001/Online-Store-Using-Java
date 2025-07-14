package testonlineshoppingstore;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MakeUp extends Item {

    private String brand;
    private String category;
    private String season;

    // no arg constructor 
    public MakeUp() {

    }

    // constructor with arg
    public MakeUp(String brand, String category, String season) {
        this.brand = brand;
        this.category = category;
        this.season = season;
    }

    // getter method
    public String getBrand() {
        return brand;
    }

    // getter method
    public String getCategory() {
        return category;
    }

    // getter method
    public String getSeason() {
        return season;
    }

    // setter method
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // setter method
    public void setCategory(String category) {
        this.category = category;
    }

    // setter method
    public void setSeason(String season) {
        this.season = season;
    }

    // method to calculate price of a specific quantity of product
    @Override
    public void orderSummary(int quantity) throws IOException {
        File makeup = new File("makeup.txt");
        Scanner input = new Scanner(makeup);

        while (input.hasNext()) {
            String line = input.nextLine();
            String[] arr = line.split(",");

            if (arr[0].equals(getItemID())) {
                setPrice(Double.parseDouble(arr[5]));

            }
        }
        input.close();
        System.out.println("Purchased Items: " + getItemID() + ", QTY= " + quantity + ", Total Price= " + (getPrice() * quantity));
        System.out.println("********************Thank you for Shopping********************");
    } // end orderSummary method

    // method to show products
    @Override
    public void showItems() throws IOException {
        File f = new File("makeup.txt");
        Scanner input = new Scanner(f);
        while (input.hasNext()) {
            String line = input.nextLine();
            System.out.println(line);
        }
    } // end showItems method

    // method to search a product from makeup file
    @Override
    public boolean searchItems(String itemID) throws IOException {
        File f = new File("makeup.txt");
        Scanner input = new Scanner(f);
        while (input.hasNext()) {
            String line = input.nextLine();
            if (line.split(",")[0].equals(itemID)) {
                input.close();
                return true;
            }
        }
        input.close();
        return false;
    } // end searchItems method

    // method to add a product to makeup file
    @Override
    public void writeItems() throws IOException {

        File f = new File("makeup.txt");
        ArrayList<String> list = new ArrayList<>();
        Scanner read = new Scanner(f);

        while (read.hasNext()) {
            list.add(read.nextLine());
        }
        read.close();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter an Item ID, itemName, color, department, size, price");
        list.add(input.nextLine());

        PrintWriter output = new PrintWriter(f);

        for (String e : list) {
            output.println(e);
        }
        output.close();

    } // end writeItems method

    // method to delete a product to makeup file
    @Override
    public void deleteItems(String itemID) throws IOException {

        File f = new File("makeup.txt");
        ArrayList<String> list = new ArrayList<>();
        Scanner read = new Scanner(f);

        while (read.hasNext()) {
            String line = read.nextLine();
            if (!line.split(",")[0].equals(itemID)) {
                list.add(line);
            }
        }
        read.close();
        PrintWriter output = new PrintWriter(f);
        for (String e : list) {
            output.println(e);
        }
        output.close();
    } // end deleteItems method

    // toString method
    @Override
    public String toString() {
        return "MakeUp{" + "brand=" + brand + ", category=" + category + ", season=" + season + '}';
    }

}
