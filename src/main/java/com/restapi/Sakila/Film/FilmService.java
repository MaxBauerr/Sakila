package com.restapi.Sakila.Film;

import com.restapi.Sakila.Language.Language;
import com.restapi.Sakila.Language.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;
    private final LanguageRepository languageRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository, LanguageRepository languageRepository) {
        this.filmRepository = filmRepository;
        this.languageRepository = languageRepository;
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmById(Short id) {
        return filmRepository.findById(id);
    }

    // Method to save a new Film
    public Film saveFilm(FilmDTO filmDTO) {
        Film film = new Film();
        setFilmProperties(film, filmDTO);
        return filmRepository.save(film);
    }

    public Film updateFilm(Short id, FilmDTO filmDTO) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found for this id :: " + id));
        setFilmProperties(film, filmDTO);
        return filmRepository.save(film);
    }

    private void setFilmProperties(Film film, FilmDTO filmDTO) {
        Language language = languageRepository.findById(filmDTO.getLanguageId())
                .orElseThrow(() -> new RuntimeException("Language not found for this id :: " + filmDTO.getLanguageId()));
        film.setTitle(filmDTO.getTitle());
        film.setDescription(filmDTO.getDescription());
        film.setReleaseYear(filmDTO.getReleaseYear());
        film.setLanguage(language);
        film.setRentalDuration(filmDTO.getRentalDuration());
        film.setRentalRate(filmDTO.getRentalRate());
        film.setLength(filmDTO.getLength());
        film.setReplacementCost(filmDTO.getReplacementCost());
        film.setRating(filmDTO.getRating());
        film.setSpecialFeatures(filmDTO.getSpecialFeatures());
    }

    public void deleteFilm(Short id) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found for this id :: " + id));
        filmRepository.delete(film);
    }

    public Film patchFilm(Short id, FilmDTO filmDTO) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found for this id :: " + id));

        if (filmDTO.getTitle() != null) {
            film.setTitle(filmDTO.getTitle());
        }
        if (filmDTO.getDescription() != null) {
            film.setDescription(filmDTO.getDescription());
        }
        if (filmDTO.getReleaseYear() != null) {
            film.setReleaseYear(filmDTO.getReleaseYear());
        }
        if (filmDTO.getLanguageId() != null) {
            Language language = languageRepository.findById(filmDTO.getLanguageId())
                    .orElseThrow(() -> new RuntimeException("Language not found for this id :: " + filmDTO.getLanguageId()));
            film.setLanguage(language);
        }
        if (filmDTO.getRentalDuration() != null) {
            film.setRentalDuration(filmDTO.getRentalDuration());
        }
        if (filmDTO.getRentalRate() != null) {
            film.setRentalRate(filmDTO.getRentalRate());
        }
        if (filmDTO.getLength() != null) {
            film.setLength(filmDTO.getLength());
        }
        if (filmDTO.getReplacementCost() != null) {
            film.setReplacementCost(filmDTO.getReplacementCost());
        }
        if (filmDTO.getRating() != null) {
            film.setRating(filmDTO.getRating());
        }
        if (filmDTO.getSpecialFeatures() != null) {
            film.setSpecialFeatures(filmDTO.getSpecialFeatures());
        }

        return filmRepository.save(film);
    }

}
