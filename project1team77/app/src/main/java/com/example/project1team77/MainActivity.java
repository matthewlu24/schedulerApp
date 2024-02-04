package com.example.project1team77;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.project1team77.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top-level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_exams, R.id.navigation_to_do_list)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        // Setup action bar with NavController
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // Setup bottom navigation with NavController
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();  // Handle the back button press
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Override onBackPressed to handle fragment navigation
    @Override
    public void onBackPressed() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        if (!navController.popBackStack()) {
            super.onBackPressed();
        }
    }
}
