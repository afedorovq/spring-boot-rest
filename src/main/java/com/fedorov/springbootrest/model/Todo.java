package com.fedorov.springbootrest.model;

import com.fedorov.springbootrest.entity.TodoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {
    private int id;
    private String title;
    private boolean completed;

    public static Todo toModel(TodoEntity entity) {
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setCompleted(entity.isCompleted());

        return model;
    }
}
