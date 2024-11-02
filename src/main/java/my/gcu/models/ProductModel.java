package my.gcu.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import my.gcu.data.entity.ProductEntity;

public class ProductModel {
    private Integer id;
    private static Integer maxId;
    @NotEmpty(message = "Product name is required")
    private String name;
    @Positive(message = "Price must be positive")
    private double price;
    private String description;
    @PositiveOrZero(message = "Quantity must be greater than or equal to zero")
    private Integer quantity;

    // Constructors
    public ProductModel() {}

    public ProductModel(String name, double price, String description, Integer quantity)
    {
        this.id = ++maxId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }
    
    public ProductModel(ProductEntity productEnt)
    {
        this.id = productEnt.getId();
        this.name = productEnt.getName();
        this.price = productEnt.getPrice();
        this.description = productEnt.getDescription();
        this.quantity = productEnt.getQuantity();

        if (productEnt.getId() > maxId)
            maxId = productEnt.getId();
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public static void setMaxId(Integer newMaxId)
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

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }
}
