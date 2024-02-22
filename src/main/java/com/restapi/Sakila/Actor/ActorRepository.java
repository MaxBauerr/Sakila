package com.restapi.Sakila.Actor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Short> {
}
