package my.gcu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import my.gcu.services.UserService;

@Configuration
public class WebSecurityConfig
{
    private final UserService userService;

     // Constructor-based dependency injection for UserService
     public WebSecurityConfig(UserService userService) 
     {
        this.userService = userService;
     }  

 @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/images/**", "/service/**", "/register/**", "/login/**", "/css/**").permitAll() 
                .requestMatchers("/userInfo").hasAnyRole("USER", "ADMIN") 
                .anyRequest().authenticated()) 
            
            .formLogin(form -> form
                .loginPage("/login") 
                .usernameParameter("username")
                .passwordParameter("password") 
                .permitAll()
                .defaultSuccessUrl("/products", true)) 
            
            .logout(logout -> logout
                .logoutUrl("/logout") 
                .invalidateHttpSession(true) 
                .clearAuthentication(true)
                .permitAll()
                .logoutSuccessUrl("/")); 

        return http.build();
    }

@Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
            .withUser("admin").password("{noop}12345").roles("ADMIN");      
    }

     @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
