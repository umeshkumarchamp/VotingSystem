package com.votersystem.model;

public class Register {
    private int id; 
    private String name;
    private int age; 
    private String email; 
    private Long contact; 


    public Register() {
    }

    public Register(int id, String name, int age, String email, Long contact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.contact = contact;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContact() {
        return this.contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", email='" + getEmail() + "'" +
            ", contact='" + getContact() + "'" +
            "}";
    }
    

}
