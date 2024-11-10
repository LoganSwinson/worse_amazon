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
    private ProductRepository productRepo;

    @Override
    public void init()
    {
        return;
    }

    @Override
    public void destroy()
    {
        return;
    }

    public void addProduct(ProductModel product)
    {
        productRepo.save(new ProductEntity(product));
    }

    public List<ProductModel> getProductList()
    {
        var productList = new ArrayList<ProductModel>();
        var productEntities = productRepo.findAll();

        for (ProductEntity entity : productEntities)
        {
            productList.add(new ProductModel(entity));
        }

        return productList;
    }

    public void deleteProductById(Integer id)
    {
        productRepo.deleteById(id);
    }
}
