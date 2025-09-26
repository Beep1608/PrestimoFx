package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")

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

   public UserEntity(){

   }

    public UserEntity(Long id, String username, String email, String password, int role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
