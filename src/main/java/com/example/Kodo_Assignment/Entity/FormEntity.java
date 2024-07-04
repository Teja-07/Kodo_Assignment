package com.example.Kodo_Assignment.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Entity // developing the entity class for form
@Data
@Table(name = "form")
public class FormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //used for creating columns in the table acts the column name
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FieldEntity> fields;
    //Generating getters and setters for the given entity class 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FieldEntity> getFields() {
        return fields;
    }

    public void setFields(List<FieldEntity> fields) {
        this.fields = fields;
    }
}
