package com.example.project1team77.ui.assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1team77.R;
import com.example.project1team77.ui.classes.Classes;
import com.example.project1team77.ui.classes.RecyclerViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AssignmentFragment extends Fragment {

    private AssignmentViewModel viewModel;
    private ArrayList<Assignment> assignmentsList;
    private FloatingActionButton add;
    private AssignmentAdapter assignmentAdapter;
    private RecyclerView recyclerView;
    private AutoCompleteTextView sorting;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(AssignmentViewModel.class);

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        assignmentsList = viewModel.getAssignmentList();

        add = view.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setAssignmentList(assignmentsList);
                Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_assignmentForm);
                assignmentAdapter.notifyDataSetChanged();
            }
        });

        String[] sortView = {"By Date", "By Class"};
        ArrayAdapter<String> adapterItems = new ArrayAdapter<String>(getActivity(), R.layout.list_item, sortView);
        sorting = view.findViewById(R.id.sorting);
        sorting.setAdapter(adapterItems);

        sorting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    viewModel.sortDueDate();
                    assignmentAdapter.notifyDataSetChanged();
                }else if(position == 1){
                    viewModel.sortCourse();
                    assignmentAdapter.notifyDataSetChanged();
                }
            }
        });

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.assignmentRecycler);
        assignmentAdapter = new AssignmentAdapter(getActivity(), assignmentsList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(assignmentAdapter);

        assignmentsList = viewModel.getAssignmentList();
        assignmentAdapter.setAssignmentList(assignmentsList);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}