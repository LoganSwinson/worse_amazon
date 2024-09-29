package my.gcu.worse_amazon.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import my.gcu.worse_amazon.Models.UserModel;

@Controller
public class RegisterController
{
    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("title", "Register Form");
        model.addAttribute("userModel", new UserModel());

        return "register";
    }

    @PostMapping("/register")   
    public String doRegister(@Valid @ModelAttribute("userModel") UserModel userModel, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("title", "Register Form");
            return "register";
        }

        System.out.println(String.format("Form with a Username of %s and Password of %s", userModel.getUsername(), userModel.getPassword()));
        return "home";
    }

}
