package com.IntertecIntl.availableuser.model;


import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String username;
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   
}
