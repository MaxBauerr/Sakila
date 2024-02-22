package com.restapi.Sakila.Language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    public Optional<Language> getLanguageById(Short id) {
        return languageRepository.findById(id);
    }

    public Language saveLanguage(Language language) {
        return languageRepository.save(language);
    }

    public Language updateLanguage(Short id, Language languageDetails) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Language not found for this id :: " + id));
        language.setName(languageDetails.getName());
        return languageRepository.save(language);
    }

    public void deleteLanguage(Short id) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Language not found for this id :: " + id));
        languageRepository.delete(language);
    }
}
