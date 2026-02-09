package com.talentotech.api.model;
import jakarta.annotation.Generated;
import jakarta.persistence.*; //Permite estandariazacion con el motor de base de datos

@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String email;
}
