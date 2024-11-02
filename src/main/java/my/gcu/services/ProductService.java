package my.gcu.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import my.gcu.data.entity.ProductEntity;
import my.gcu.data.entity.repository.ProductRepository;
import my.gcu.interfaces.ServiceInterface;
import my.gcu.models.ProductModel;

public class ProductService implements ServiceInterface
{   
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void init()
    {
        ProductModel.setMaxId(0);
        return;
    }

    @Override
    public void destroy()
    {
        return;
    }

    public void addProduct(ProductModel product)
    {
        productRepository.save(new ProductEntity(product));
    }

    public List<ProductModel> getProductList()
    {
        var productList = new ArrayList<ProductModel>();
        var productEntities = productRepository.findAll();

        for (ProductEntity entity : productEntities)
        {
            productList.add(new ProductModel(entity));
        }

        return productList;
    }

    public int getHighestID()
    {
        int maxId = 0;
        
        var productEntities = productRepository.findAll();

        for (ProductEntity entity : productEntities)
        {
            if (entity.getId() > maxId)
                maxId = entity.getId();
        }

        return maxId;
    }
}
