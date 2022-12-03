package com.example.mylittleassist;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setTitle("컨테이너 리스트");

        FragMusicSheet fragMusicSheet = new FragMusicSheet();
        CalanderFragment calanderFragment = new CalanderFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, fragMusicSheet).commit();

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        actionBar.setTitle("컨테이너 리스트");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, fragMusicSheet).commit();
                        return true;

                    case R.id.list:
                        actionBar.setTitle("컨테이너 일정");
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, calanderFragment).commit();
                        return true;

                    case R.id.calendar:
                        actionBar.setTitle("마이페이지");
                        return true;
                }
                return false;
            }
        });
    }
}