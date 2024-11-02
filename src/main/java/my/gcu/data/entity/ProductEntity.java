package my.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import my.gcu.models.ProductModel;

@Table("PRODUCTS")
public class ProductEntity
{
    @Id
    private Integer id;
    private String name;
    private double price;
    private String description;
    private int quantity;

    public ProductEntity()
    {
        this.id = -1;
        this.name = "ERROR";
        this.price = -1;
        this.quantity = -1;
    }

    public ProductEntity(ProductModel productMod)
    {
        this.id = productMod.getId();
        this.name = productMod.getName();
        this.price = productMod.getPrice();
        this.description = productMod.getDescription();
        this.quantity = productMod.getQuantity();
    }

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the productName
     */
    public String getName() {
        return name;
    }

    /**
     * @param productName the productName to set
     */
    public void setName(String productName) {
        this.name = productName;
    }

    /**
     * @return double return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Integer return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
