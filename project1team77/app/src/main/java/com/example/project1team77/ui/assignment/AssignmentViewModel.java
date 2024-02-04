package com.example.project1team77.ui.assignment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class AssignmentViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<Assignment>> assignmentList = new MutableLiveData<>();

    public AssignmentViewModel() {
        assignmentList.setValue(new ArrayList<Assignment>());
    }

    public ArrayList<Assignment> getAssignmentList(){
        return assignmentList.getValue();
    }

    public void setAssignmentList(ArrayList<Assignment> list){
        assignmentList.setValue(list);
    }

    public void sortDueDate(){

        ArrayList<Assignment> array = assignmentList.getValue();

        for (int i = 0; i < array.size()-1; i++)
        {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i+1; j < array.size(); j++) {
                if (array.get(j).getDueDate().before(array.get(min).getDueDate()))
                    min = j;
            }

            Assignment temp = array.get(min);
            array.set(min, array.get(i));
            array.set(i, temp);
        }

        assignmentList.setValue(array);
    }

    public void sortCourse(){
        ArrayList<Assignment> array = assignmentList.getValue();

        for (int i = 0; i < array.size()-1; i++)
        {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i+1; j < array.size(); j++) {
                if (array.get(j).getCourse().compareTo(array.get(min).getCourse()) <= 0)
                    min = j;
            }

            Assignment temp = array.get(min);
            array.set(min, array.get(i));
            array.set(i, temp);
        }

        assignmentList.setValue(array);
    }
}