package my.gcu.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import my.gcu.data.entity.ProductEntity;

public class ProductModel
{
    private Integer id;
    @NotEmpty(message = "Product name is required")
    private String name;
    @Positive(message = "Price must be positive")
    private double price;
    private String description;
    @PositiveOrZero(message = "Quantity must be greater than or equal to zero")
    private Integer quantity;

    // Constructors
    public ProductModel() {}
    
    public ProductModel(ProductEntity product)
    {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.quantity = product.getQuantity();
    }
    
    // Getters and Setters
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
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
