package my.gcu.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import my.gcu.data.entity.UserEntity;
import my.gcu.data.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

     // Constructor to initialize UserRepository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // This method is used by Spring Security to load user details during login.
    // fetches the user from the database based on the provided username.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Looks for user in database using username
        // If the user is not found, throw an exception
        UserEntity user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // Password is expected to be hashed
                .roles("USER") 
                .build();
    }
}
