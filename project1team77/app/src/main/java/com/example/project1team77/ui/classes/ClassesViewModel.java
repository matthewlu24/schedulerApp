package com.example.project1team77.ui.classes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ClassesViewModel extends ViewModel {

        private MutableLiveData<ArrayList<Classes>> classesList = new MutableLiveData<>();

        public ClassesViewModel(){
            classesList.setValue(new ArrayList<Classes>());
        }

        public ArrayList<Classes> getClassesList(){
            return classesList.getValue();
        }

        public void setClassesList(ArrayList<Classes> classesList) {
            this.classesList.setValue(classesList);
        }

        public void addClass(Classes toAdd){
            ArrayList<Classes> curr = classesList.getValue();
            curr.add(toAdd);
            classesList.setValue(curr);
        }

}