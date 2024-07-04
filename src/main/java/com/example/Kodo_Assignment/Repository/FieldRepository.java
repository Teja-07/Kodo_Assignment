package com.example.Kodo_Assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Kodo_Assignment.Entity.FieldEntity;
//It is Repository interface which connects with database and also with the service for checking the data
public interface FieldRepository extends JpaRepository<FieldEntity, Long> {
    FieldEntity findByIdAndName(Long id, String name); // acts as an function
}
