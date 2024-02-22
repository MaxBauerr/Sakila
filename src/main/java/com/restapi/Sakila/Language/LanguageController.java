package com.restapi.Sakila.Language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public List<Language> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable Short id) {
        return languageService.getLanguageById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Language addLanguage(@RequestBody Language language) {
        return languageService.saveLanguage(language);
    }

    @PutMapping("/{id}")
    public Language updateLanguage(@PathVariable Short id, @RequestBody Language languageDetails) {
        return languageService.updateLanguage(id, languageDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Short id) {
        languageService.deleteLanguage(id);
        return ResponseEntity.ok().build();
    }
}
