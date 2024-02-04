package com.example.project1team77.viewModel;

import android.content.Intent;
import android.os.Bundle;

import com.example.project1team77.R;
import com.example.project1team77.model.Classes;
import com.example.project1team77.ui.classes.RecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClassActivity extends AppCompatActivity {

    private com.example.project1team77.databinding.ClassScheduleBinding binding;

    ArrayList<Classes> classesModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView = findViewById(R.id.classScheduleRecycler);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, classesModel);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding = com.example.project1team77.databinding.ClassScheduleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        Intent newClassIntent = getIntent();
        String name = newClassIntent.getStringExtra("name");
        String time = newClassIntent.getStringExtra("time");
        String professor = newClassIntent.getStringExtra("professor");

        classesModel.add(new Classes(name, time, professor));
    }

}