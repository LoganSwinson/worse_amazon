package my.gcu.data.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import my.gcu.data.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>
{
    Optional<UserEntity> findByUsername(String username);
}
