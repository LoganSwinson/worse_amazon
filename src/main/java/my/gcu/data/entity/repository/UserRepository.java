package my.gcu.data.entity.repository;

import org.springframework.data.repository.CrudRepository;
import my.gcu.data.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>
{
    
}
