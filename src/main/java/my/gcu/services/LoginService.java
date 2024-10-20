package my.gcu.services;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import my.gcu.interfaces.ServiceInterface;
import my.gcu.models.LoginModel;

public class LoginService implements ServiceInterface
{
    private boolean isLoggedIn;
    private boolean isAdmin;

    @Override
    public void init()
    {
        System.out.println("Login Service Bean Initialized");
        isLoggedIn = false;
        isAdmin = false;
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
        
        // This lets other pages know that the user is logged in
        isLoggedIn = true;

        // Check if they are an admin
        if (isAdmin(loginModel))
        {
            isAdmin = true;
            return "admin";
        }
        // A successful login sends the user to the "Products" page
        return "products";
    }

    public boolean isAdmin(LoginModel loginModel)
    {
        // Hard coded Admin Login info
        if (loginModel.getUsername().equals("admin") && loginModel.getPassword().equals("12345"))
            return true;

        return false;
    }

    public Model modelCheckAdmin(Model model)
    {
        model.addAttribute("isAdmin", this.getIsAdmin());
        return model;
    }

    public boolean getIsLoggedIn()
    {
        return isLoggedIn;
    }

    public boolean getIsAdmin()
    {
        return isAdmin;
    }
}
