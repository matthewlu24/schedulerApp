package com.example.project1team77.ui.todolist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.project1team77.R;

public class ToDoListFragment extends Fragment {

    private ToDoListViewModel viewModel;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private Button button2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_to_do_list, container, false);

        listView = view.findViewById(R.id.listView);
        button2 = view.findViewById(R.id.button2);

        viewModel = new ViewModelProvider(requireActivity()).get(ToDoListViewModel.class);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });

        itemsAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1);
        listView.setAdapter(itemsAdapter);

        viewModel.getItemsLiveData().observe(getViewLifecycleOwner(), items -> {
            itemsAdapter.clear();
            itemsAdapter.addAll(items);
        });

        setUpListViewListener();

        return view;
    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                viewModel.removeItem(i);
                return true;
            }
        });
    }

    private void addItem(View view) {
        EditText input = requireView().findViewById(R.id.editTextText);
        String itemText = input.getText().toString();

        if (!itemText.equals("")) {
            viewModel.addItem(itemText);
            input.setText("");
        } else {
            Toast.makeText(requireContext(), "Please enter text...", Toast.LENGTH_LONG).show();
        }
    }

}
