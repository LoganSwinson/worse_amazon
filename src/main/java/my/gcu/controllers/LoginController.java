package my.gcu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{
   /*  @Autowired private LoginService loginServiceBean; */

    @GetMapping("/login")
    public String display(Model model)
    {
        model.addAttribute("title", "Login Page");
        /* model.addAttribute("loginModel", new LoginModel());
        model.addAttribute("loginServiceBean", loginServiceBean); */
        return "login";  // Return the login.html template
    }

/*     @PostMapping("/doLogin")
public String doLogin(@Valid @ModelAttribute("loginModel") LoginModel loginModel, BindingResult bindingResult, Model model) {
    // Call validateLogin to check login credentials and add errors if necessary
    String resultPage = loginServiceBean.validateLogin(bindingResult, loginModel);
    
    // If there are validation errors or "Invalid credentials", stay on the login page
    if (bindingResult.hasErrors()) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", loginModel);
        return "login";  // Return to the login view directly to display errors
    }

    // If login is successful, redirect to the target page (either "admin" or "products")
    return "redirect:/" + resultPage;
} */

    
}
