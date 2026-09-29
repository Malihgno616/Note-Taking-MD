package com.example.note_taking_md.repository;

import com.example.note_taking_md.model.NoteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteModel, Long> {

}
