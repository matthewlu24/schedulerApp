package com.example.project1team77.ui.assignment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.project1team77.R;
import com.example.project1team77.ui.classes.Classes;
import com.example.project1team77.ui.classes.ClassesViewModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AssignmentForm extends Fragment{

    private EditText n;
    private EditText dueDate;
    private Button dD;
    private Button submit;

    private AssignmentViewModel viewModel;
    private ArrayList<Assignment> assignmentList;
    private ArrayList<Classes> classesList;
    private AutoCompleteTextView selectClass;
    private Classes course;
    private AssignmentAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.assignment_form, container, false);

        n = (EditText) view.findViewById(R.id.name);
        dueDate = (EditText) view.findViewById(R.id.dueDateText);
        dD = (Button) view.findViewById(R.id.dueDate);
        submit = (Button) view.findViewById(R.id.submit);
        selectClass = (AutoCompleteTextView) view.findViewById(R.id.selectClass);

        viewModel = new ViewModelProvider(getActivity()).get(AssignmentViewModel.class);
        assignmentList = viewModel.getAssignmentList();

        ClassesViewModel classesViewModel = new ViewModelProvider(getActivity()).get(ClassesViewModel.class);
        classesList = classesViewModel.getClassesList();

        ArrayAdapter<Classes> adapterItems = new ArrayAdapter<Classes>(getActivity(), R.layout.list_item, toArray());
        selectClass.setAdapter(adapterItems);

        Boolean editing = getArguments().getBoolean("editing?");
        if(editing){
            String[] assignmentStuff = getArguments().getStringArray("assignmentStuff");
            n.setText(assignmentStuff[0]);
            dueDate.setText(assignmentStuff[1]);
            selectClass.setText(assignmentStuff[2]);
            course = assignmentList.get(getArguments().getInt("index")).getCourse();
        }

        selectClass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                course = (Classes)parent.getItemAtPosition(position);
            }
        });

        dD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = n.getText().toString();
                String date = dueDate.getText().toString();

                if(!editing){
                    if(course == null){
                        course = new Classes("","","");
                    }
                    Assignment toAdd = new Assignment(name, date, course);
                    viewModel.addAssignment(toAdd);
                }else{
                    Assignment curr = assignmentList.get(getArguments().getInt("index"));

                    curr.setTitle(name);
                    curr.setDueDate(date);
                    curr.setCourse(course);
                }

                assignmentList = viewModel.getAssignmentList();
                Navigation.findNavController(v).navigate(R.id.action_assignmentForm_to_navigation_dashboard);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<Classes> adapterItems = new ArrayAdapter<Classes>(getActivity(), R.layout.list_item, toArray());
        selectClass.setAdapter(adapterItems);
    }

    private Classes[] toArray(){

        Classes[] toReturn = new Classes[classesList.size()];

        for(int i = 0; i < toReturn.length; i++){
            toReturn[i] = classesList.get(i);
        }
        return toReturn;
    }

    private void openDialog(){

        Calendar now = Calendar.getInstance();
        int month = now.MONTH-1;
        int day = now.DAY_OF_MONTH-1;
        DatePickerDialog picker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {

                month++;
                dueDate.setText(month + "/" + day + "/" + year);
            }
        }, 2024, month, day);

        picker.show();
    }
}
