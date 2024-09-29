package my.gcu.controllers;

import my.gcu.models.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import jakarta.validation.Valid;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";  // Return the login.html template
    }

   @PostMapping("/doLogin")
    public String doLogin(@Valid @ModelAttribute("loginModel") LoginModel loginModel, 
                          BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // If there are errors, return to the login page
            return "login";
        }
        return "home"; 
    }
    
}
