package com.restapi.Sakila.Actor;

import com.restapi.Sakila.Film.Film;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @Column(name = "actor_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short actorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public Actor() {
    }

    // Getters and Setters
    public Short getActorId() {
        return actorId;
    }

    public void setActorId(Short actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
