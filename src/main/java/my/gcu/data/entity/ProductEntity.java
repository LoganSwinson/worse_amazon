package my.gcu.data.entity;

import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUCTS")
public class ProductEntity {
    private Long id;
    private String orderNo;
    private String productName;
    private float price;
    private int quantity;
}
