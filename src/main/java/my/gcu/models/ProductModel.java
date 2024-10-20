package my.gcu.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class ProductModel {
    private int id;
    private static int maxId;

    @NotEmpty(message = "Product name is required")
    private String name;

    @Positive(message = "Price must be positive")
    private double price;

    private String description;

    // Constructors
    public ProductModel() {}

    public ProductModel(String name, double price, String description)
    {
        this.id = ++maxId;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public static void setMaxId(int newMaxId)
    {
        maxId = newMaxId;
    }

    public void updateId()
    {
        this.id = ++maxId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
