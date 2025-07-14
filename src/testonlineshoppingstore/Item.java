package testonlineshoppingstore;

import java.io.IOException;

public abstract class Item {

    private String itemID;
    private String itemName;
    private double price;

    // no arg constructor 
    protected Item() {

    }

    // constructor with arg
    protected Item(String itemID, String itemName, double price) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
    }

    public abstract void orderSummary(int quantity) throws IOException;

    public abstract void showItems() throws IOException;

    public abstract boolean searchItems(String itemID) throws IOException;

    public abstract void writeItems() throws IOException;

    public abstract void deleteItems(String itemID) throws IOException;

    // getter method
    public String getItemID() {
        return itemID;
    }

    // getter method
    public String getItemName() {
        return itemName;
    }

    // getter method
    public double getPrice() {
        return price;
    }

    // setter method
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    // setter method
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // setter method
    public void setPrice(double price) {
        this.price = price;
    }

    // toString method
    @Override
    public String toString() {
        return "Item{" + "itemID=" + itemID + ", itemName=" + itemName + ", price=" + price + '}';
    }

    
}

