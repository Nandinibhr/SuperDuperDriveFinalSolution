package com.udacity.jwdnd.course1.cloudstorage.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import java.util.List;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;

@Service
public class CredentialsService
{
    @Autowired
    private CredentialMapper credentialMapper;

    private List<Credential> credentialsList;

    public CredentialsService(CredentialMapper credentialMapper)
    {
        this.credentialMapper = credentialMapper;
    }


    public List<Credential> getCredentials(Integer userid)
    {
        this.credentialsList = credentialMapper.select(userid);

        return this.credentialsList;
    }

    public void addCredentials(Credential credential)
    {
        credentialMapper.insert(credential);
    }

    public void deleteCredentials(Integer credentialid, Integer userid)
    {
        credentialMapper.delete(credentialid,userid);
    }

    public void updateCredentials(Credential credential)
    {
        credentialMapper.update(credential);
    }


}
