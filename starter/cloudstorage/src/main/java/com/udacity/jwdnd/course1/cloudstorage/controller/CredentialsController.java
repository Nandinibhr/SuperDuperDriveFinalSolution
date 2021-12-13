package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.services.CredentialsService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/credentials")
public class CredentialsController
{
    private CredentialsService credentialsService;

    public CredentialsController(CredentialsService credentialsService)
    {
        this.credentialsService = credentialsService;
    }

    @GetMapping("")
    public String getCredentialsPage(Authentication authentication , Credential credential, Model model)
    {
        Integer userid = UserService.getCurrentUserId(authentication);
        List<Credential> credentialslist = credentialsService.getCredentials(userid);
        model.addAttribute(credentialslist);
        return "credentials";
    }

    @GetMapping("/add")
    public String addCredentials(Authentication authentication , Credential credential, Model model)
    {
        Integer userid = UserService.getCurrentUserId(authentication);
        credentialsService.addCredentials(credential);
        return "home";
    }

    @GetMapping("/edit")
    public String editCredentials(Authentication authentication , Credential credential, Model model)
    {
        Integer userid = UserService.getCurrentUserId(authentication);
        credentialsService.updateCredentials(credential);
        return "home";
    }

    @GetMapping("/delete")
    public String deleteCredentials(Authentication authentication ,Credential credential, Model model)
    {
        Integer userid = UserService.getCurrentUserId(authentication);
        Integer credentialid = credential.getCredentialid();
        credentialsService.deleteCredentials(credentialid,userid);
        List<Credential> credentialslist = credentialsService.getCredentials(userid);
        model.addAttribute(credentialslist);
        return "credentials";
    }



}
