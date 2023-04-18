package com.tp_integrador_argprograma.demo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usersssss")
@Data
public class User {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
    @Column
    private String pass;

}
