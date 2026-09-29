package com.example.note_taking_md.service;

import org.springframework.stereotype.Service;

@Service
public class GrammarService {

    public String checkContent(String content) {
        if(content == null || content.trim().isEmpty()) {
            return "";
        }

        String corrected = content.replaceAll("[ //t]+", " ");

        if(Character.isLowerCase(corrected.charAt(0))) {
            corrected = Character.toUpperCase(corrected.charAt(0)) +  corrected.substring(1);
        }

        return corrected;
    }

}
