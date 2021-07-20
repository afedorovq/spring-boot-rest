package com.fedorov.springbootrest.service;

import com.fedorov.springbootrest.entity.TodoEntity;
import com.fedorov.springbootrest.entity.UserEntity;
import com.fedorov.springbootrest.model.Todo;
import com.fedorov.springbootrest.repository.TodoRepository;
import com.fedorov.springbootrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public Todo createTodo(TodoEntity todo, int userId) {
        UserEntity user = userRepository.findById(userId).get();
        todo.setUser(user);

        return Todo.toModel(todoRepository.save(todo));
    }

    public Todo completeTodo(int id) {
        TodoEntity todo = todoRepository.findById(id).get();
        todo.setCompleted(!todo.isCompleted());
        
        return Todo.toModel(todoRepository.save(todo));
    }
}
