package com.example.note_taking_md.controller;

import com.example.note_taking_md.model.NoteModel;
import com.example.note_taking_md.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/notes")
    public List<NoteModel> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<NoteModel> getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/notes")
    public NoteModel createNote(@RequestBody NoteModel note) {
        return noteService.saveNote(note);
    }

}
