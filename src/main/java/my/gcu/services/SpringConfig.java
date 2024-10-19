package my.gcu.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig
{
    @Bean(name="loginService", initMethod="init", destroyMethod="destroy")
    public LoginService getLoginService()
    {
        return new LoginService();
    }

}