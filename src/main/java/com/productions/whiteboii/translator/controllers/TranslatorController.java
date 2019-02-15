package com.productions.whiteboii.translator.controllers;

import com.productions.whiteboii.translator.models.Word;
import com.productions.whiteboii.translator.services.TranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/translator")
public class TranslatorController {

    protected static final String GET = "";

    private TranslatorService service;

    @Autowired
    public TranslatorController(TranslatorService service) {
        this.service = service;
    }

    @GetMapping(GET)
    public ResponseEntity<Word> translate(@RequestParam("word") String word) {
        Word translatedWord = service.translate(word);
        if (translatedWord.getWord() == null) return new ResponseEntity<Word>(new Word("word not in the dictionary yet"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<Word>(translatedWord, HttpStatus.OK);
    }

}
