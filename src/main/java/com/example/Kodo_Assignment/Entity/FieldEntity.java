package com.example.Kodo_Assignment.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity // developing the entity class for form
@Data
@Table(name = "field")
public class FieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //used for creating columns in the table acts the column name
    private Long id;

    @ManyToOne
    @JoinColumn(name = "form_id", nullable = false)
    private FormEntity form;
  //Generating getters and setters for the given entity class 
    @Column(name = "required")
    private boolean isRequired;

    @Column(name = "empname")
    private String name = "";

    @Column(name = "hrname")
    private String hrname = "";

    @Column(name = "dateofleave")
    private String dateofLeave = "";

    @Column(name = "dateofjoin")
    private String dataofJoin = "";

    @Column(name = "no_leave_days")
    private int no_leave_days = 0;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FormEntity getForm() {
        return form;
    }

    public void setForm(FormEntity form) {
        this.form = form;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHrname() {
        return hrname;
    }

    public void setHrname(String hrname) {
        this.hrname = hrname;
    }

    public String getDateofLeave() {
        return dateofLeave;
    }

    public void setDateofLeave(String dateofLeave) {
        this.dateofLeave = dateofLeave;
    }

    public String getDataofJoin() {
        return dataofJoin;
    }

    public void setDataofJoin(String dataofJoin) {
        this.dataofJoin = dataofJoin;
    }

    public int getNo_leave_days() {
        return no_leave_days;
    }

    public void setNo_leave_days(int no_leave_days) {
        this.no_leave_days = no_leave_days;
    }
}
