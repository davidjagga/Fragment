package com.jaggadavid.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    EditText newTaskEditText;
    FragmentTransaction ft;
    int id=1;
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
        Bundle bundle = new Bundle();
        ft = getSupportFragmentManager().beginTransaction();
        int myMessage = Color.BLACK;
        bundle.putInt("color", myMessage );
        Random random = new Random();
        String TAG = random.toString();
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(id++);
        TaskFragment fragment = new TaskFragment(text);
        fragment.setArguments(bundle);
        linearLayout.addView(frameLayout);
        ft.add(frameLayout.getId(), fragment, TAG);
        ft.commit();
System.out.println("testing: I'm done adding");

    }
    public void updateTask(View v){
        CheckBox view = (CheckBox) v;
        if (view.getCurrentTextColor()==Color.BLACK) {
            Bundle bundle = new Bundle();
            ft = getSupportFragmentManager().beginTransaction();
            int myMessage = Color.BLUE;
            bundle.putInt("color", myMessage);
            TaskFragment fragInfo = new TaskFragment(view.getText().toString());
            fragInfo.setArguments(bundle);
            FrameLayout frameLayout = (FrameLayout) view.getParent().getParent();

            ft.replace(frameLayout.getId(), fragInfo);
            ft.commit();
        } else {
            Bundle bundle = new Bundle();
            ft = getSupportFragmentManager().beginTransaction();
            int myMessage = Color.BLACK;
            bundle.putInt("color", myMessage);
            TaskFragment fragInfo = new TaskFragment(view.getText().toString());
            fragInfo.setArguments(bundle);
            FrameLayout frameLayout = (FrameLayout) view.getParent().getParent();

            ft.replace(frameLayout.getId(), fragInfo);
            ft.commit();
        }
    }

    public void removeTask(View view) {

        String text = String.valueOf(newTaskEditText.getEditableText());
        ft = getSupportFragmentManager().beginTransaction();
        FrameLayout frameLayout = (FrameLayout) view.getParent().getParent();

        ft.remove(getSupportFragmentManager().findFragmentById(frameLayout.getId()));
        ft.commit();

    }
}