package com.example.menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        setFragment(new BlankFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.f1) {
                setFragment(new BlankFragment());
            } else if (item.getItemId() == R.id.f2) {
                setFragment(new BlankFragment2());
            } else if (item.getItemId() == R.id.f3) {
                setFragment(new BlankFragment3());
            }
            return true;
        });
    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout, fragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Настройки выбраны", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.frag_first) {
            setFragment(new BlankFragment());
            Toast.makeText(this, "Первый фрагмент открыт", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.frag_two) {
            setFragment(new BlankFragment2());
            Toast.makeText(this, "Второй фрагмент открыт", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.frag_three) {
            setFragment(new BlankFragment2());
            Toast.makeText(this, "Третий фрагмент открыт", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    }

