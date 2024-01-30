package com.example.project1team77.model;

public class Classes {
    String professor;
    String classes;
    String time;

    public Classes(String professor, String classes, String time) {
        this.professor = professor;
        this.classes = classes;
        this.time = time;
    }


    public String getProfessor() {
        return professor;
    }

    public String getClasses() {
        return classes;
    }

    public String getTime() {
        return time;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
