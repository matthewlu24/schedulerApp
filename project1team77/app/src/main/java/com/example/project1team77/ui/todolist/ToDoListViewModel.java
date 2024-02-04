package com.example.project1team77.ui.todolist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ToDoListViewModel extends ViewModel {
    private MutableLiveData<ArrayList<String>> itemsLiveData;

    public LiveData<ArrayList<String>> getItemsLiveData() {
        if (itemsLiveData == null) {
            itemsLiveData = new MutableLiveData<>();
            itemsLiveData.setValue(new ArrayList<>());
        }
        return itemsLiveData;
    }

    public void addItem(String item) {
        ArrayList<String> currentItems = itemsLiveData.getValue();
        if (currentItems != null) {
            currentItems.add(item);
            itemsLiveData.setValue(currentItems);
        }
    }

    public void removeItem(int position) {
        ArrayList<String> currentItems = itemsLiveData.getValue();
        if (currentItems != null && position >= 0 && position < currentItems.size()) {
            currentItems.remove(position);
            itemsLiveData.setValue(currentItems);
        }
    }
}

