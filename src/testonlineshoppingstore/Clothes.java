package testonlineshoppingstore;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Clothes extends Item {

    private String color;
    private String department;
    private String size;

    // no arg constructor 
    public Clothes() {

    }

    // constructor with arg
    public Clothes(String color, String department, String size) {
        this.color = color;
        this.department = department;
        this.size = size;
    }

    // getter method
    public String getColor() {
        return color;
    }

    // getter method
    public String getDepartment() {
        return department;
    }

    // getter method
    public String getSize() {
        return size;
    }

    // setter method
    public void setColor(String color) {
        this.color = color;
    }

    // setter method
    public void setDepartment(String department) {
        this.department = department;
    }

    // setter method
    public void setSize(String size) {
        this.size = size;
    }

    // method to calculate price of a specific quantity of product
    @Override
    public void orderSummary(int quantity) throws IOException {
        File clothesFile = new File("clothes.txt");
        Scanner input = new Scanner(clothesFile);

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
        File f = new File("clothes.txt");
        Scanner input = new Scanner(f);
        while (input.hasNext()) {
            String line = input.nextLine();
            System.out.println(line);
        }
    } // end showItems method

    // method to search a product from clothes file
    @Override
    public boolean searchItems(String itemID) throws IOException {
        File f = new File("clothes.txt");
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
    }  // end searchItems method

    // method to add a product to clothes file
    @Override
    public void writeItems() throws IOException {
        ArrayList<String> list = new ArrayList<>();
        File f = new File("clothes.txt");
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

    // method to delete a product to clothes file
    @Override
    public void deleteItems(String itemID) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        File f = new File("clothes.txt");

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

    }   // end deleteItems method         

    // toString method
    @Override
    public String toString() {
        return "Clothes{" + "color=" + color + ", department=" + department + ", size=" + size + '}';
    }

}
