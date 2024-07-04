package com.example.Kodo_Assignment.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Kodo_Assignment.Entity.FieldEntity;
import com.example.Kodo_Assignment.Service.FieldService;

@RestController
@RequestMapping("/field/api")
//Controllers in Spring Boot are Java classes responsible for handling incoming HTTP requests and returning an appropriate response.
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @PostMapping("/details/{formId}")
    //HERE IT USED POST METHOD AS HTTP REQUEST ALONG WITH FORM ID WHICH IS USED FOR THE CONNECTION PURPOSE
    public FieldEntity saveFieldDetails(@PathVariable Long formId, @RequestBody FieldEntity fieldEntity) throws Exception {
        return fieldService.saveFieldDetails(formId, fieldEntity);
    }

    @GetMapping("/empdetails")
    //IT IS USED TO FETCH THE EMPLOYEE DATA USING THE ID AND NAME DETAILS
    public FieldEntity findEmpDetails(@RequestParam long id, @RequestParam String empName) {
        return fieldService.findEmpLeaveDetails(id, empName);
    }
}