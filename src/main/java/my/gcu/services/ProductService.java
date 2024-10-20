package my.gcu.services;

import java.util.ArrayList;
import java.util.List;

import my.gcu.interfaces.ServiceInterface;
import my.gcu.models.ProductModel;

public class ProductService implements ServiceInterface
{
    List<ProductModel> productList;

    @Override
    public void init()
    {
        this.productList = new ArrayList<ProductModel>();
        
        return;
    }

    @Override
    public void destroy()
    {
        this.productList.clear();
        return;
    }

    public void addProduct(ProductModel product)
    {
        this.productList.add(product);
    }

    public List<ProductModel> getProductList()
    {
        return this.productList;
    }

    public int getHighestID()
    {
        int maxId = 0;

        for (ProductModel product : productList)
        {
            if (product.getId() > maxId)
                maxId = product.getId();
        }

        return maxId;
    }
}
