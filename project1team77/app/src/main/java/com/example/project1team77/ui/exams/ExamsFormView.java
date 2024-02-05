package com.example.project1team77.ui.exams;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.project1team77.R;

import java.util.ArrayList;


public class ExamsFormView extends Fragment {

    private Exams newExam;
    private Button submit;

    private EditText n;
    private EditText t;
    private EditText l;
    private ExamsViewModel viewModel;
    private ArrayList<Exams> examsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.exams_form_view, container, false);
        submit = (Button) view.findViewById(R.id.submit);

        n = (EditText) view.findViewById(R.id.name);
        t = (EditText) view.findViewById(R.id.time_date);
        l = (EditText) view.findViewById(R.id.location);

        viewModel = new ViewModelProvider(getActivity()).get(ExamsViewModel.class);
        examsList = viewModel.getExamsList();

        Boolean editing = getArguments().getBoolean("editing?");

        if(editing){
            String[] examStuff = getArguments().getStringArray("classStuff");
            n.setText(examStuff[0]);
            t.setText(examStuff[1]);
            l.setText(examStuff[2]);
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = n.getText().toString();
                String time_date = t.getText().toString();
                String location = l.getText().toString();

                if(!editing){
                    newExam = new Exams(name, time_date, location);
                    viewModel.addExams(newExam);
                    examsList = viewModel.getExamsList();
                }else{
                    int index = getArguments().getInt("index");
                    Exams curr = examsList.get(index);

                    curr.setExamClass(name);
                    curr.setExamTime_date(time_date);
                    curr.setExamLocation(location);
                }

                Navigation.findNavController(v).navigate(R.id.action_examsFormView_to_navigation_exams);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

