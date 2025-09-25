package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public  class   UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
   @Column( columnDefinition="TEXT")
   private String username;
    @Column( columnDefinition="TEXT", unique = true)
   private String email;
   @Column( columnDefinition="TEXT")
   private String password;
   @Column(nullable = false)
   private int role;
}
