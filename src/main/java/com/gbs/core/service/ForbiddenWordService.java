package com.gbs.core.service;

import com.gbs.core.datastore.ForbiddenWordRepository;
import com.gbs.core.model.ForbiddenWord;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Log4j2
public class ForbiddenWordService {

    @Autowired
    private ForbiddenWordRepository forbiddenWordRepository;

    private List<ForbiddenWord> forbiddenWords;

    @PostConstruct
    public void loadForbiddenWordsIntoMemory() {
        forbiddenWords = forbiddenWordRepository.findAll();
        log.info("Loaded {} forbidden words.", forbiddenWords.size());
    }

    public List<ForbiddenWord> getForbiddenWords() {
        return forbiddenWords;
    }
}