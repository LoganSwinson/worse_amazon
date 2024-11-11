package my.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import my.gcu.models.ProductModel;
import my.gcu.services.LoginService;
import my.gcu.services.ProductService;

@Controller
public class AdminController
{
    @Autowired private LoginService loginServiceBean;
    @Autowired private ProductService productServiceBean;

    @GetMapping("/admin")
    public String home(Model model)
    {
        // The loginServiceBean from login is reused to check if the user has logged in as an admin before
        model = loginServiceBean.modelCheckAdmin(model);
        model.addAttribute("title", "Admin Page");
        // Add an empty product to use for creation or updates
        model.addAttribute("product", new ProductModel());
        model.addAttribute("productList", productServiceBean.getProductList());
        
        return "admin";
    }

    @PostMapping("/admin/createProduct")
    public String createProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result, Model model)
    {
        // The login needs to be verified everytime the page is rerendered by thymeleaf
        model = loginServiceBean.modelCheckAdmin(model);
        // If errors occur, return to the product creation page
        if (result.hasErrors())
        {   System.out.println("\nERROR");
            model.addAttribute("title", "Admin Page");
            return "admin";
        }

        // The save method from the Crud Repository will also update a product if an ID has already been used
        productServiceBean.addProduct(product);
        // Used to display products
        model.addAttribute("productList", productServiceBean.getProductList());

        return "admin";
    }

    @PostMapping("/admin/updateProduct")
    public String updateProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result, Model model)
    {
        return createProduct(product, result, model);
    }

    @PostMapping("/admin/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Integer id)
    {
        productServiceBean.deleteProductById(id);
        return "redirect:/admin";
    }
}
