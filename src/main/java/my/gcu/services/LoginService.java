package my.gcu.services;

import org.springframework.validation.BindingResult;
import my.gcu.interfaces.LoginServiceInterface;
import my.gcu.models.LoginModel;

public class LoginService implements LoginServiceInterface
{
    @Override
    public void init()
    {
        System.out.println("Login Service Bean Initialized");
        return;
    }

    @Override
    public void destroy()
    {
        System.out.println("Login Service Bean Destroyed");
        return;
    }

    public String validateLogin(BindingResult bindingResult, LoginModel loginModel)
    {
        // If there are errors, return to the login page
        if (bindingResult.hasErrors())
            return "login";
        
        // Check if they are an admin
        if (isAdmin(loginModel))
            return "admin";

        // A successful login sends the user to the "Products" page
        return "products";
    }

    public boolean isAdmin(LoginModel loginModel)
    {
        if (loginModel.getUsername() == "admin" && loginModel.getPassword() == "12345")
            return true;

        return false;
    }
}
