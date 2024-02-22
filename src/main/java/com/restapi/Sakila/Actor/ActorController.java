package com.restapi.Sakila.Actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable Short id) {
        return actorService.getActorById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Actor addActor(@RequestBody Actor actor) {
        return actorService.saveActor(actor);
    }

    @PutMapping("/{id}")
    public Actor updateActor(@PathVariable Short id, @RequestBody Actor actorDetails) {
        return actorService.updateActor(id, actorDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Short id) {
        actorService.deleteActor(id);
        return ResponseEntity.ok().build();
    }
}
