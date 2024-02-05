package com.example.project1team77.ui.exams;

public class Exams {
    String examClass;
    String examTime_date;
    String examLocation;

    public Exams(String examClass, String examTime_date, String examLocation) {
        this.examClass = examClass;
        this.examTime_date = examTime_date;
        this.examLocation = examLocation;
    }

    public String getExamClass() {
        return examClass;
    }

    public void setExamClass(String examClass) {
        this.examClass = examClass;
    }

    public String getExamTime_date() {
        return examTime_date;
    }

    public void setExamTime_date(String examTime_date) {
        this.examTime_date = examTime_date;
    }

    public String getExamLocation() {
        return examLocation;
    }

    public void setExamLocation(String examLocation) {
        this.examLocation = examLocation;
    }
}
