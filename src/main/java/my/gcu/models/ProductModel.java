package my.gcu.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import my.gcu.data.entity.ProductEntity;

public class ProductModel
{
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
        if (maxId == null)
            maxId = 0;
        this.id = ++maxId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }
    
    public ProductModel(ProductEntity product)
    {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.quantity = product.getQuantity();

        if (product.getId() > maxId)
            maxId = product.getId();
    }

    // Getters and Setters
    public Integer getId() {
        return id;
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
