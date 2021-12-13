package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.udacity.jwdnd.course1.cloudstorage.model.File;

@Controller
@RequestMapping("/file")
public class FileController
{
    public FileService fileService;

    public FileController(NoteService noteService)
    {
        this.fileService = fileService;
    }

    @GetMapping("")
    public String getFiles(Authentication authentication , Model model)
    {
        Integer userid = UserService.getCurrentUserId(authentication);
        model.addAttribute("AllFiles" , fileService.getAllFiles(userid));
        return "home";
    }

    @GetMapping("/upload")
    public String uploadFile(Authentication authentication , Model model , File file )
    {
        Integer userid = UserService.getCurrentUserId(authentication);
        file.setUserid(userid);
        fileService.addFile(file);
        return "home";
    }

    @GetMapping("/view")
    public String viewFile(Authentication authentication , Model model , File file )
    {
        Integer userid = UserService.getCurrentUserId(authentication);
        model.addAttribute("blobdata",fileService.getFile(file.getFileId()));
        return "home";
    }

    @GetMapping("/delete")
    public String deleteFile(Authentication authentication , Model model , File file )
    {
        Integer userid = UserService.getCurrentUserId(authentication);
        fileService.deleteFile(userid, file.getFileId());
        return "home";
    }
}

