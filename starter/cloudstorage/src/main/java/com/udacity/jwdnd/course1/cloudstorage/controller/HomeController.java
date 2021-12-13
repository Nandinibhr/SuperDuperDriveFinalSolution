package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import com.udacity.jwdnd.course1.cloudstorage.model.User;

@Controller
@RequestMapping("/home")
public class HomeController
{
    private  UserService userService;
    private  FileService fileService;
    private  NoteService noteService;
    private  CredentialsService credentialService;

    public HomeController(UserService userService, FileService fileService, NoteService noteService, CredentialsService credentialService)
    {
        System.out.print("In home controller");
        this.userService = userService;
        this.fileService = fileService;
        this.noteService = noteService;
        this.credentialService = credentialService;
    }

    @GetMapping("")
    public String homeView(Authentication authentication, Model model)
    {
        Integer userid = userService.getCurrentUserId(authentication);
        model.addAttribute("Files", fileService.getAllFiles(userid));
        model.addAttribute("Notes",noteService.getNotes(userid));
        model.addAttribute("Credentials", credentialService.getCredentials(userid));
        return "home";
    }
}