package com.example.project1team77.ui.classes;

public class Classes implements Comparable<Classes> {
    String professor;
    String classes;
    String time;

    public Classes(String classes, String time, String professor) {
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

    @Override
    public int compareTo(Classes o) {

        if(o == null){
            return 0;
        }
        return classes.compareTo(o.classes);
    }

    @Override
    public String toString(){
        return classes;
    }

}
