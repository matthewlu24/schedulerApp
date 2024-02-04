package com.example.project1team77.ui.exams;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1team77.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ExamsFragment extends Fragment {
    private RecyclerView recyclerView;
    private ExamsRecyclerViewAdapter recyclerViewAdapter;
    private FloatingActionButton add;
    ArrayList<Exams> examsModel;
    private ExamsViewModel viewModel;
    private Button delete;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exams, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(ExamsViewModel.class);
        examsModel = viewModel.getExamsList();

        add = view.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setExamsList(examsModel);
                Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_examsFormView);
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerViewAdapter = new ExamsRecyclerViewAdapter(getActivity(), examsModel);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(recyclerViewAdapter);

        examsModel = viewModel.getExamsList();
        recyclerViewAdapter.setExamsModel(examsModel);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}