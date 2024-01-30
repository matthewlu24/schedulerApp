package com.example.project1team77.model;
import java.util.Date;
public class Exam {

    private Date date;
    private String time;
    private String location;

    public Exam(Date date, String time, String location) {
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }
}
