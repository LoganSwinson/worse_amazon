package my.gcu.controllers;

import my.gcu.models.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String home(Model model) {
        model.addAttribute("title", "Admin Page");
        model.addAttribute("product", new ProductModel()); // Add a new Product object to the model
        return "admin";
    }

    @PostMapping("/admin/createProduct")
    public String createProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Admin Page");
            return "admin";
        }

        // Handle product creation logic (e.g., storing product temporarily or displaying a message)

        model.addAttribute("success", "Product created successfully!");
        return "admin";
    }
}
