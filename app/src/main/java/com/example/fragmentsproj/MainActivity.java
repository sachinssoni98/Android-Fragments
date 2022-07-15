package com.example.fragmentsproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button b1, b2, b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= findViewById(R.id.btn1);
        b2= findViewById(R.id.btn2);
        b3= findViewById(R.id.btn3);
        b1.setOnClickListener(this::loadFirstFragment);
        b2.setOnClickListener(this::loadSecondFragment);
        b3.setOnClickListener(this::loadThirdFragment);
        loadFragment(new SecondFragment(), 0);   // To load a fragment by default.
    }

    private void loadThirdFragment(View view) {
        loadFragment(new FirstFragment(), 1);
        Toast.makeText(this,"Button 1 is pressed",Toast.LENGTH_SHORT);
    }

    private void loadSecondFragment(View view) {
        loadFragment(new SecondFragment(), 1);
        Toast.makeText(this,"Button 2 is pressed",Toast.LENGTH_SHORT);
    }

    private void loadFirstFragment(View view) {
        loadFragment(new ThirdFragment(), 1);
        Toast.makeText(this,"Button 3 is pressed",Toast.LENGTH_SHORT);
    }

    private void loadFragment(Fragment fragment, int flag){
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        if(flag==0) {
            ft.add(R.id.frame, fragment);
        }
        else{
            ft.replace(R.id.frame, fragment); // will replace the previous loaded fragment with new one.
        }
        ft.commit();
    }
}

//References: https://youtu.be/7jcXW0Xwd4Y