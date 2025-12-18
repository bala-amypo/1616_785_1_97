package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
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
    @Column(unique=true)
    private String rollNumber;
    public void setId(Long id){
        this.id=id;
    }
    public void setname(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
     public void setRollNumber(String rollNumber){
        this.rollNumber=rollNumber;
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
    public String getRollNumber(){
        return rollNumber;
    }
    public User(Long id,String name,String email,String rollNumber){
        this.id=id;
        this.username=username;
         this.email=email;
       this.rollNumber=rollNumber;
    }
    public User(){

    }
}