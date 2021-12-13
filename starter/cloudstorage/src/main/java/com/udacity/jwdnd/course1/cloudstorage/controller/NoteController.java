package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.security.core.Authentication;


@Controller
@RequestMapping("/note")
public class NoteController
{
    public NoteService noteService;

    public NoteController(NoteService noteService)
    {
        this.noteService = noteService;
    }

    @GetMapping("")
    public String getNotes(Authentication authentication , Model model)
    {
        Integer userid = UserService.getCurrentUserId(authentication);
        model.addAttribute(noteService.getNotes(userid));
        return "home";
    }

    @GetMapping("/add")
    public String addNote(Authentication authentication , Model model , Note note )
    {
        Integer userid = UserService.getCurrentUserId(authentication);
        note.setUserid(userid);
        noteService.addNote(note);
        return "home";
    }

    @GetMapping("/edit")
    public String updateNote(Authentication authentication , Model model , Note note )
    {
        Integer userid = UserService.getCurrentUserId(authentication);
        note.setUserid(userid);
        noteService.updateNote(note);
        return "home";
    }

    @GetMapping("/delete")
    public String deleteNote(Authentication authentication , Model model , Note note )
    {
        Integer userid = UserService.getCurrentUserId(authentication);
        noteService.deleteNote(userid, note.getNoteid());
        return "home";
    }



}


