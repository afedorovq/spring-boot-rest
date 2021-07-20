package com.fedorov.springbootrest.service;

import com.fedorov.springbootrest.entity.UserEntity;
import com.fedorov.springbootrest.exception.UserAlreadyExistsException;
import com.fedorov.springbootrest.exception.UserNotFoundException;
import com.fedorov.springbootrest.model.User;
import com.fedorov.springbootrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(int id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User is not found");
        }
        return User.toModel(user);
    }

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistsException("User with the same username already exists");
        }
        return userRepository.save(user);
    }

    public User deleteUser(int id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User is not found");
        }
        userRepository.delete(user);
        return User.toModel(user);
    }
}
