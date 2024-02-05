package com.example.project1team77.ui.assignment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.project1team77.ui.classes.Classes;

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

    public void addAssignment(Assignment toAdd){
        ArrayList<Assignment> curr = assignmentList.getValue();
        curr.add(toAdd);
        assignmentList.setValue(curr);
    }

    public void sortDueDate(){

        ArrayList<Assignment> array = assignmentList.getValue();

        for (int i = 0; i < array.size()-1; i++)
        {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i+1; j < array.size(); j++) {

                String currDate = array.get(j).getDueDate();
                String[] currDates = currDate.split("/");

                int currYear = Integer.parseInt(currDates[2]);
                int currMonth = Integer.parseInt(currDates[0]);
                int currDay = Integer.parseInt(currDates[1]);

                String minDate = array.get(min).getDueDate();
                String[] minDates = minDate.split("/");

                int minYear = Integer.parseInt(minDates[2]);
                int minMonth = Integer.parseInt(minDates[0]);
                int minDay = Integer.parseInt(minDates[1]);


                if(minYear > currYear){
                    min = j;
                }else if(minYear == currYear){
                    if(minMonth > currMonth){
                        min = j;
                    }else if(minMonth == currMonth){
                        if(minDay > currDay){
                            min = j;
                        }
                    }
                }
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
                int num = array.get(j).getCourse().compareTo(array.get(min).getCourse());
                if (num < 0) {
                    min = j;
                } else if(num == 0){
                    if(array.get(j).getTitle().compareTo(array.get(min).getTitle()) < 0){
                        min = j;
                    }
                }
            }

            Assignment temp = array.get(min);
            array.set(min, array.get(i));
            array.set(i, temp);
        }

        assignmentList.setValue(array);
    }
}