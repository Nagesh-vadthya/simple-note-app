package com.example.noteapp.controller;

import com.example.noteapp.model.Note;
import com.example.noteapp.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        model.addAttribute("note", new Note());
        return "index";
    }

    @PostMapping("/add")
    public String addNote(@ModelAttribute Note note) {
        noteService.saveNote(note);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "redirect:/";
    }
}