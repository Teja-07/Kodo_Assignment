package com.example.Kodo_Assignment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.Kodo_Assignment.Entity.FormEntity;
import com.example.Kodo_Assignment.Repository.FormRepository;
//In this Service class we will be using for the developing the logics and also helps us to create effective work flow in db
@Service
public class FormService {
    @Autowired
    private FormRepository formRepo;

    public FormEntity findByDetails(FormEntity formEntity) throws Exception {
        String title = formEntity.getTitle();

        // Check if title is valid
        if (!validString(title)) { 
            throw new IllegalArgumentException("Invalid title length. Title must be between 3 and 20 characters.");
        }

        try {
            // Attempt to save the form
            return formRepo.save(formEntity);
        } catch (DataIntegrityViolationException ex) {
            // Catch exception if title already exists in database
            throw new IllegalArgumentException("Form with title '" + title + "' already exists.");
        }
    }
    //function call
    public boolean validString(String name) {
        return name != null && name.length() > 3 && name.length() < 30;
    }
}
