package com.example.note_taking_md.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NoteController {

    @GetMapping("/notes")
    public String api() {
        return "Hello World!!";
    }

}
