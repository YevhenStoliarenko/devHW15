package org.example.devhw15.mvc.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.devhw15.mvc.modell.Note;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final Note note;
    private final Note note1;
    private final Note note2;
    List<Note> noteList = new ArrayList<>();

    public List<Note> listAll() {
        return noteList;
    }

    public String getTime() {
        return LocalDateTime.now().toString();
    }

    @PostConstruct
    public void addNote() {
        noteList.add(note);
        noteList.add(note1);
        noteList.add(note2);
    }

    public Note editNoteById(Integer id) {
        return noteList.get(id);
    }

    public List<Note> deleteNote(int id) {
        Note note3 = noteList.get(id);
        noteList.remove(note3);
        return noteList;
    }

    public List<Note> updateNote(Integer id, Long updateId, String title, String content) {
        Note note3 = noteList.get(id);
        note3.setId(updateId);
        note3.setTitle(title);
        note3.setContent(content);
        return noteList;
    }

    public List<Note> createNote(String title, String content) {
        Note localNnote = new Note();
        localNnote.setTitle(title);
        localNnote.setContent(content);
        noteList.add(localNnote);
        return noteList;
    }

}
