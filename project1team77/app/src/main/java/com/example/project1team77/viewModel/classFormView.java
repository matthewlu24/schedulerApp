package com.example.project1team77.viewModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project1team77.R;
import com.example.project1team77.model.Classes;


public class classFormView extends AppCompatActivity {

    private Classes newClass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_form_view);

        Button submit = (Button) findViewById(R.id.submit);

        EditText n = (EditText) findViewById(R.id.name);
        EditText t = (EditText) findViewById(R.id.time);
        EditText p = (EditText) findViewById(R.id.professor);
        submit.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                String name = n.getText().toString();
                String time = t.getText().toString();
                String professor = p.getText().toString();

                newClass = new Classes(name, time, professor);

                Intent newClassIntent = new Intent(getApplicationContext(), MainActivity.class);
                newClassIntent.putExtra("name", name);
                newClassIntent.putExtra("time", time);
                newClassIntent.putExtra("professor", professor);
            }

        });

    }
}
