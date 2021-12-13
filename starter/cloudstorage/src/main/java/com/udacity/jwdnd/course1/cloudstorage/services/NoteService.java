package com.udacity.jwdnd.course1.cloudstorage.services;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import java.util.List;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;


@Service
public class NoteService
{
    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper)
    {
        this.noteMapper = noteMapper;
    }

    public List<Note> getNotes(Integer userid)
    {
        return noteMapper.getAllNotes(userid);
    }

    public void addNote(Note note)
    {
            noteMapper.insert(note);
    }

    public void updateNote(Note note)
    {
        noteMapper.insert(note);
    }

    public void deleteNote(Integer noteid, Integer userid) {
        noteMapper.delete(noteid, userid);
    }
}




    /*public static Integer getCurrentUserId(Authentication auth) {
        String username = auth.getName();
        User user = getUser(username);
        return user.getUserid();
    }*/