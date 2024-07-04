package com.example.Kodo_Assignment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Kodo_Assignment.Entity.FieldEntity;
import com.example.Kodo_Assignment.Entity.FormEntity;
import com.example.Kodo_Assignment.Repository.FieldRepository;
import com.example.Kodo_Assignment.Repository.FormRepository;

//In this Service class we will be using for the developing the logics and also helps us to create effective work flow in db
@Service
public class FieldService {

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private FormRepository formRepository; // Assuming you have a repository for FormEntity

    public FieldEntity saveFieldDetails(Long formId, FieldEntity fieldEntity) throws Exception {
        // Fetch the FormEntity by its ID
        String dateOfJoin = fieldEntity.getDataofJoin();
        String dateOfLeave = fieldEntity.getDateofLeave();
        String hrName = fieldEntity.getHrname();
        String empName = fieldEntity.getName();
        int leaves = fieldEntity.getNo_leave_days();
        
        // Save the FieldEntity
        FormEntity form = formRepository.findById(formId)
                .orElseThrow(() -> new IllegalArgumentException("FormEntity with id " + formId + " not found"));

        // Set the fetched FormEntity into FieldEntity
        fieldEntity.setForm(form);

        boolean validParameters = notNullParameters(dateOfJoin, dateOfLeave, hrName, empName, leaves);//check null values exist
        boolean validName = properName(hrName, empName);//throgh exception if wrong user enter
        boolean validLeaveDate = validDate(leaves);// check the valid leaves
        //Handling Exception
        if (!validParameters) {
            throw new Exception("Fill All the given Parameters");
        } else if (!validName) {
            throw new Exception("Please give valid hrname or Your name");
        } else if (!validLeaveDate) {
            throw new Exception("Please give a valid number of leave dates");
        } else {
            return fieldRepository.save(fieldEntity);//Else stores the data
        }
    }
    //Calling the Functions
    public boolean notNullParameters(String dateOfJoin, String dateOfLeave, String hrName, String empName, Integer leaves) {
        return dateOfJoin != null && dateOfLeave != null && hrName != null && empName != null && leaves != null;
    }

    public boolean properName(String hrName, String empName) {
        return isValidName(hrName) && isValidName(empName);
    }

    private boolean isValidName(String name) {
        return name != null && name.length() > 3 && name.length() < 20;
    }

    public boolean validDate(int dateOfLeave) {
        return dateOfLeave > 1 && dateOfLeave < 15;
    }
    //Used to Fetch the data using given id and empname
    public FieldEntity findEmpLeaveDetails(Long id, String empName) {
        return fieldRepository.findByIdAndName(id, empName);
    }
}
