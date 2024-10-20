package my.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import my.gcu.services.LoginService;

@Controller
public class ProductsController 
{
    @Autowired private LoginService loginServiceBean;
    
    @GetMapping("products")
    public String home(Model model)
    {
        model.addAttribute("title", "Products");
        // The loginServiceBean from login is reused to check if the user has successfully completed a login before
        model.addAttribute("isLoggedIn", loginServiceBean.getIsLoggedIn());
        return "products";
    }
}
