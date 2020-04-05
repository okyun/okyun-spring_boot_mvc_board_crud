package com.example.demo.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Table(name = "user")
public class UserDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index")
    private String index;

    @Column(name = "id")
    private String id;
}
