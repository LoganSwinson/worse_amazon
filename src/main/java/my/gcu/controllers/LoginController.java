package my.gcu.controllers;

import my.gcu.models.LoginModel;
import my.gcu.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import jakarta.validation.Valid;

@Controller
public class LoginController
{
    @Autowired private LoginService loginServiceBean;

    @GetMapping("/login")
    public String display(Model model)
    {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        model.addAttribute("loginServiceBean", loginServiceBean);
        return "login";  // Return the login.html template
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid @ModelAttribute("loginModel") LoginModel loginModel, BindingResult bindingResult, Model model)
    {
        // This redirects now so that thyme leaf variables will properly work on the "products" page
        return "redirect:/" + loginServiceBean.validateLogin(bindingResult, loginModel);
    }
    
}
