package com.fedorov.springbootrest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "todo")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TodoEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "completed")
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
