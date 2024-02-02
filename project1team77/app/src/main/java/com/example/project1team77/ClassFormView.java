package com.example.project1team77;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project1team77.R;
import com.example.project1team77.databinding.ClassFormViewBinding;
import com.example.project1team77.model.Classes;
import com.example.project1team77.viewModel.ClassActivity;


public class ClassFormView extends AppCompatActivity {

    private Classes newClass;
    private ClassFormViewBinding binding;
    private Button submit;

    EditText n;
    EditText t;
    EditText p;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_form_view);
        getSupportActionBar().setTitle("Add New Class");
        submit = (Button) findViewById(R.id.submit);

        n = (EditText) findViewById(R.id.name);
        t = (EditText) findViewById(R.id.time);
        p = (EditText) findViewById(R.id.professor);
    }

    public void submit(View v){
        String name = n.getText().toString();
        String time = t.getText().toString();
        String professor = p.getText().toString();

        newClass = new Classes(name, time, professor);

        Intent newClassIntent = new Intent(getApplicationContext(), MainActivity.class);
        newClassIntent.putExtra("name", name);
        newClassIntent.putExtra("time", time);
        newClassIntent.putExtra("professor", professor);
        startActivity(newClassIntent);
    }
}
