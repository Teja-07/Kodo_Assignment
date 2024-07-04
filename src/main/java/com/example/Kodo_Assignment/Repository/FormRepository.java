package com.example.Kodo_Assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Kodo_Assignment.Entity.FormEntity;
//It is Repository interface which connects with database and also with the service for checking the data
@Repository
public interface FormRepository extends JpaRepository<FormEntity, Long> {
    FormEntity findByTitle(String title);
}
