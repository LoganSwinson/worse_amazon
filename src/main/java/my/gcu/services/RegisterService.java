package my.gcu.services;

import org.springframework.beans.factory.annotation.Autowired;

import my.gcu.data.entity.UserEntity;
import my.gcu.data.repository.UserRepository;
import my.gcu.interfaces.ServiceInterface;
import my.gcu.models.UserModel;

public class RegisterService implements ServiceInterface
{
    @Autowired
    private UserRepository userRepo;

    @Override
    public void init()
    {
        return;
    }

    @Override
    public void destroy()
    {
        return;
    }
    
    public void addUser(UserModel user)
    {
        userRepo.save(new UserEntity(user));
    }
}
