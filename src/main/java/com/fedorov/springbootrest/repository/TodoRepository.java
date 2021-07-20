package com.fedorov.springbootrest.repository;

import com.fedorov.springbootrest.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoEntity, Integer> {
}
