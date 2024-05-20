package cmp320project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author baraa
 */
public class OrderLine {
    private int lineNumber;
    private double lineTotal;
    private String username;
    private int productID;
    private int quantity;
    private String name;
    
    public static Map <String, ArrayList<OrderLine>> orderLineList = new HashMap<>();

    public OrderLine(double lineTotal, String username, int productID, int quantity, String name) {
        this.lineNumber = orderLineList.get(username).size() + 1;
        this.lineTotal = lineTotal;
        this.username = username;
        this.productID = productID;
        this.quantity = quantity;
        this.name = name;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public double getLineTotal() {
        return lineTotal;
    }

    public String getUsername() {
        return username;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }   

    public String getName() {
        return name;
    }
    
    
}
