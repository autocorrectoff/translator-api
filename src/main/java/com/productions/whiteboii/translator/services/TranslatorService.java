package com.productions.whiteboii.translator.services;

import com.productions.whiteboii.translator.models.Word;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslatorService {
    private Map<String, String> dictionary;

    public TranslatorService() {
        this.dictionary = new HashMap<String, String>();
        dictionary.put("air", "hawa");
        dictionary.put("water", "ma'an");
        dictionary.put("earth", "ard");
        dictionary.put("fire", "nar");
    }

    public Word translate(String input) {
        String result = dictionary.get(input);
        Word word = new Word(result);
        return word;
    }
}
