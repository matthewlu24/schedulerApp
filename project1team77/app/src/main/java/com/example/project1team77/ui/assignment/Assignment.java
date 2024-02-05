package com.example.project1team77.ui.assignment;
import com.example.project1team77.ui.classes.Classes;

import java.util.Date;
public class Assignment {

    private String title;
    private String dueDate;
    private Classes course;
    public Assignment(String title, String dueDate, Classes course) {
        this.title = title;
        this.dueDate = dueDate;
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public Classes getCourse() {
        return course;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setCourse(Classes course) {
        this.course = course;
    }
}
