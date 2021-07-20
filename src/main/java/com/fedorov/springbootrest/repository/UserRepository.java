package com.fedorov.springbootrest.repository;

import com.fedorov.springbootrest.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    public UserEntity findByUsername(String username);
}
