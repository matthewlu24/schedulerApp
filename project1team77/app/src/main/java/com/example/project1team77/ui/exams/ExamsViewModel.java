package com.example.project1team77.ui.exams;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ExamsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Exams>> examsList = new MutableLiveData<>();

    public ExamsViewModel(){
        examsList.setValue(new ArrayList<Exams>());
    }

    public ArrayList<Exams> getExamsList(){
        return examsList.getValue();
    }

    public void setExamsList(ArrayList<Exams> examsList) {
        this.examsList.setValue(examsList);
    }

    public void addExams(Exams toAdd){
        ArrayList<Exams> curr = examsList.getValue();
        curr.add(toAdd);
        examsList.setValue(curr);
    }

}