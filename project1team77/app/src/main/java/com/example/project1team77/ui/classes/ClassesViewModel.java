package com.example.project1team77.ui.classes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ClassesViewModel extends ViewModel {

        private MutableLiveData<ArrayList<Classes>> classesList = new MutableLiveData<>();

        public ClassesViewModel(){
            classesList.setValue(new ArrayList<Classes>());
        }
        public MutableLiveData<ArrayList<Classes>> getLiveClassesList() {
            return classesList;
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

        public void removeClass(String toRemove){
            ArrayList<Classes> curr = classesList.getValue();

            for(int i = 0; i < curr.size(); i++){
                if(curr.get(i).getClasses().equals(toRemove)){
                    curr.remove(i);
                    classesList.setValue(curr);
                    return;
                }
            }
        }

}