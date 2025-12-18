package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique=true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private String role;
    public void setId(Long id){
        this.id=id;
    }
    public void setname(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPassword(String password){
        this.password=password;
    }
     public void setRole(String role){
        this.roler=role;
    }
    public Long getId(){
        return id;
    }
    public String getname(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }
    public User(Long id,String name,String email,String password,String role){
        this.id=id;
        this.username=username;
         this.email=email;
         this.password=password;
       this.role=role;
    }
    public User(){

    }
}