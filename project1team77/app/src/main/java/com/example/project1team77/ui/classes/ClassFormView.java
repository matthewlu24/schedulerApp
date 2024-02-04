package com.example.project1team77.ui.classes;

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
import com.example.project1team77.databinding.ClassFormViewBinding;

import java.util.ArrayList;


public class ClassFormView extends Fragment {

    private Classes newClass;
    private ClassFormViewBinding binding;
    private Button submit;

    private EditText n;
    private EditText t;
    private EditText p;
    private ClassesViewModel viewModel;
    private ArrayList<Classes> classesList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.class_form_view, container, false);
        submit = (Button) view.findViewById(R.id.submit);

        n = (EditText) view.findViewById(R.id.name);
        t = (EditText) view.findViewById(R.id.time);
        p = (EditText) view.findViewById(R.id.professor);

        viewModel = new ViewModelProvider(getActivity()).get(ClassesViewModel.class);
        classesList = viewModel.getClassesList();

        Boolean editing = getArguments().getBoolean("editing?");

        if(editing){
            String[] classStuff = getArguments().getStringArray("classStuff");
            n.setText(classStuff[0]);
            t.setText(classStuff[1]);
            p.setText(classStuff[2]);
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = n.getText().toString();
                String time = t.getText().toString();
                String professor = p.getText().toString();

                if(!editing){
                    newClass = new Classes(name, time, professor);
                    viewModel.addClass(newClass);
                    classesList = viewModel.getClassesList();
                }else{
                    int index = getArguments().getInt("index");
                    Classes curr = classesList.get(index);

                    curr.setClasses(name);
                    curr.setTime(time);
                    curr.setProfessor(professor);
                }

                Navigation.findNavController(v).navigate(R.id.action_classFormView_to_navigation_home);
            }
        });



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
