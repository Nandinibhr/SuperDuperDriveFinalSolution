package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/note")
public class NoteController
{

    public NoteService noteService;
    private UserService userService;

    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping("")
    public String getNotes(Authentication authentication , Note note , @ModelAttribute Model model)
    {
        Integer userid = UserService.getCurrentUserId(authentication);
        model.addAttribute("Notes", noteService.getNotes(userid));
        return "home";
    }


    @PostMapping("/add")
    public String createOrEditNote(Authentication authentication , Model model , @ModelAttribute Note note )
    {
        System.out.print("IN note controller -- add method");
        Integer userid = UserService.getCurrentUserId(authentication);
        note.setUserid(userid);
        noteService.createOrEditNote(note);
        return "home";
    }


    @GetMapping("/delete")
    public String deleteNote(Authentication authentication , Model model , @ModelAttribute Note note )
    {
        Integer userid = UserService.getCurrentUserId(authentication);
        noteService.deleteNote(userid, note.getNoteid());
        return "home";
    }



}
