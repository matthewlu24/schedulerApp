package com.example.project1team77.model;
import com.example.project1team77.ui.classes.Classes;

import java.util.Date;
public class Assignment {

    private String title;
    private Date dueDate;
    private Classes course;
    public Assignment(String title, Date dueDate, Classes course) {
        this.title = title;
        this.dueDate = dueDate;
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Classes getCourse() {
        return course;
    }
}
