package my.gcu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String root()
    {
        // When the user goes to the "root" page, redirect to the "home" page
        return "redirect:/home";
    }
}