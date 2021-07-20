package com.fedorov.springbootrest.model;

import com.fedorov.springbootrest.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String username;
    private List<Todo> todo;

    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setTodo(entity.getTodo().stream().map(Todo::toModel).collect(Collectors.toList()));

        return model;
    }
}
