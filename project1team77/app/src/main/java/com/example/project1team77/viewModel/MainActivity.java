package com.example.project1team77.viewModel;

import android.os.Bundle;

import com.example.project1team77.R;
import com.example.project1team77.model.Classes;
import com.example.project1team77.ui.RecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1team77.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    ArrayList<Classes> classesModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView = findViewById(R.id.classScheduleRecycler);

        setUpClassesModel();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, classesModel);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding = ActivityMainBinding.inflate(getLayoutInflater());
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
    }

    private void setUpClassesModel() {
        String[] classesModelClass = getResources().getStringArray(R.array.classes);
        String[] classesModelProfessor = getResources().getStringArray(R.array.professor);
        String[] classesModelTime = getResources().getStringArray(R.array.time);

        for (int i = 0; i <= classesModelClass.length; i++) {
            classesModel.add(new Classes(classesModelClass[i], classesModelProfessor[i],
                    classesModelTime[i]));
        }
    }
}