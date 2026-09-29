package com.example.note_taking_md.service;

import com.example.note_taking_md.model.NoteModel;
import com.example.note_taking_md.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final GrammarService grammarService;
    private final MarkDownService markDownService;
    private final NoteRepository noteRepository;

    public List<NoteModel> getAllNotes() {
        return noteRepository.findAll();
    }

    public NoteModel saveNote(NoteModel note) {
        String grammarCorrected = grammarService.checkContent(note.getContent());
        note.setContent(grammarCorrected);

        String renderedHtml = markDownService.renderToHtml(grammarCorrected);
        note.setHtmlContent(renderedHtml);

        return noteRepository.save(note);
    }

    public Optional<NoteModel> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

}
