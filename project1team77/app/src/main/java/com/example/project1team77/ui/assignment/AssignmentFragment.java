package com.example.project1team77.ui.assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.project1team77.R;
import com.example.project1team77.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

public class AssignmentFragment extends Fragment {

    private AssignmentViewModel viewModel;
    private ArrayList<Assignment> assignmentsList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel =
                new ViewModelProvider(this).get(AssignmentViewModel.class);

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        assignmentsList = viewModel.getAssignmentList();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}