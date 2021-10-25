package com.jaggadavid.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    EditText newTaskEditText;
    FragmentTransaction ft;
    int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //access linear layout
        linearLayout = findViewById(R.id.placeholder);
        newTaskEditText = findViewById(R.id.editText);
        //new Framelayout

        //add fl to layout
        //put fragment in fl

        // Begin the transaction
        ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        //ft.add(R.id.placeholder, new TaskFragment());
        //ft.add(R.id.placeholder, new TaskFragment());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        //ft.commit();
    }

    public void addTask(View view) {

        String text = String.valueOf(newTaskEditText.getEditableText());
        ft = getSupportFragmentManager().beginTransaction();
        Random random = new Random();
        String TAG = random.toString();
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(id++);
        linearLayout.addView(frameLayout);
        ft.add(frameLayout.getId(), new TaskFragment(text), TAG);
        ft.commit();

    }

    public void removeTask(View view) {

        String text = String.valueOf(newTaskEditText.getEditableText());
        ft = getSupportFragmentManager().beginTransaction();
        FrameLayout frameLayout = (FrameLayout) view.getParent().getParent();

        ft.remove(getSupportFragmentManager().findFragmentById(frameLayout.getId()));
        ft.commit();

    }
}