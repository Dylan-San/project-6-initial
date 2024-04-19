package com.example.dictionary.service;


import com.example.dictionary.exception.WordNotFoundException;
import com.example.dictionary.model.Entry;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {

    public Entry getWord(String word) throws WordNotFoundException {

        Entry entry = new Entry(word, DictionaryReference.getDicitionary().get(word));

        return entry;
    }
}
