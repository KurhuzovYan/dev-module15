package com.example.devmodule15.controller;

import com.example.devmodule15.entites.Note;
import com.example.devmodule15.servises.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/note")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(value = "/list")
    public ModelAndView getListOfNotes() {
        ModelAndView model = new ModelAndView("notes/main-page");
        model.addObject("notes", noteService.getAllNotes());
        return model;
    }

    @PostMapping(path = "/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping(value = "/edit")
    public ModelAndView editNote(@RequestParam("id") Long id) {
        ModelAndView edit = new ModelAndView("notes/editing-page");
        Note note = noteService.readById(id).get();
        edit.addObject("note", note);
        return edit;
    }

    @PostMapping(path = "/edit")
    public String updateNote(@ModelAttribute("note") Note updateNote) {
        noteService.updateById(updateNote);
        System.out.println(noteService.getAllNotes());
        return "redirect:/note/list";
    }

    @GetMapping(value = "/create")
    public String createNote() {
        return "notes/creating-new-node-page";
    }

    @PostMapping(path = "/create")
    public String updateListOfNodes(@ModelAttribute("note") Note newNote) {
        noteService.createNote(newNote);
        return "redirect:/note/list";
    }
}
