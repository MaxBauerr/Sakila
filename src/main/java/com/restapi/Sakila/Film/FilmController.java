package com.restapi.Sakila.Film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Short id) {
        return filmService.getFilmById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Controller method to add a new film
    @PostMapping
    public Film addFilm(@RequestBody FilmDTO filmDTO) {
        return filmService.saveFilm(filmDTO);
    }

    // Controller method to update an existing film
    @PutMapping("/{id}")
    public Film updateFilm(@PathVariable Short id, @RequestBody FilmDTO filmDTO) {
        return filmService.updateFilm(id, filmDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Short id) {
        filmService.deleteFilm(id);
        return ResponseEntity.ok().build();
    }

//    @PatchMapping("/{id}")
//    public Film patchFilm(@PathVariable Short id, @RequestBody FilmDTO filmDTO) {
//        return filmService.patchFilm(id);
//    }
}
