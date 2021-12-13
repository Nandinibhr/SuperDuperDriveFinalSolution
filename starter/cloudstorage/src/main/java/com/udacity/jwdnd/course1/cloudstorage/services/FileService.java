package com.udacity.jwdnd.course1.cloudstorage.services;


import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService
{
    private FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }


    public File getFile(Integer fileId )
    {
        return fileMapper.select(fileId);
    }

    public List<File> getAllFiles(Integer userid)
    {
        return fileMapper.getAllFiles(userid);
    }

    public void addFile(File file)
    {
        fileMapper.insert(file);
    }


    public void deleteFile(Integer fileId, Integer userid) {
        fileMapper.delete(fileId, userid);
    }
}

