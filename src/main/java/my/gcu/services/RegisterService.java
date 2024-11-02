package my.gcu.services;

import org.springframework.beans.factory.annotation.Autowired;
import my.gcu.data.entity.repository.UserRepository;
import my.gcu.data.entity.ProductEntity;
import my.gcu.data.entity.UserEntity;
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

    public int getHighestID()
    {
        int maxId = 0;
        
        var userEntities = userRepo.findAll();

        for (UserEntity entity : userEntities)
        {
            if (entity.getId() > maxId)
                maxId = entity.getId();
        }

        return maxId;
    }
}
