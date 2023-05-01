package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    NavigationBarView navigationBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        navigationBarView = findViewById(R.id.bottom_navigation);

        first homeFragment = first.newInstance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment, homeFragment, null).commit();

        BadgeDrawable badge = navigationBarView.getOrCreateBadge(R.id.item_3);
        badge.setNumber(1);

        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.item_1){
                    first homeFragment = first.newInstance();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_fragment, homeFragment, null).commit();
                }
                else if (id == R.id.item_2){
                    sec searchFragment = sec.newInstance();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_fragment, searchFragment, null).commit();
                }
                else if (id == R.id.item_3){
                    th accountFragment = th.newInstance();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_fragment, accountFragment, null).commit();
                    navigationBarView.removeBadge(R.id.item_3);
                }
                return true;

            }
        });

    }
}