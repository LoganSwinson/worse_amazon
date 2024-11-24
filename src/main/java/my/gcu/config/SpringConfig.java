package my.gcu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import my.gcu.services.LoginService;
import my.gcu.services.ProductService;
import my.gcu.services.RegisterService;

@Configuration
public class SpringConfig
{
    @Bean(name="loginService", initMethod="init", destroyMethod="destroy")
    public LoginService getLoginService()
    {
        return new LoginService();
    }

    @Bean(name="productService", initMethod="init", destroyMethod="destroy")
    public ProductService getProductService()
    {
        return new ProductService();
    }

    @Bean(name="registerService", initMethod="init", destroyMethod="destroy")
    public RegisterService getRegisterService()
    {
        return new RegisterService();
    }

    @Bean(name="bCryptPasswordEncoder")
    public BCryptPasswordEncoder getPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
