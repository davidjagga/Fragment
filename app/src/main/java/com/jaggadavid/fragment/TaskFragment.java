package com.jaggadavid.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class TaskFragment extends Fragment {

    private String text;
    private int color = Color.BLUE;



    public TaskFragment(String str){
        text = str;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        color = getArguments().getInt("color");
        return inflater.inflate(R.layout.task_fragment, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        CheckBox checkBox = view.findViewById(R.id.taskCheckbox);
        checkBox.setText(text);
        if (color==Color.BLUE){
            checkBox.setTextColor(color);
            checkBox.setChecked(true);
        } else {
            checkBox.setTextColor(color);

        }


    }

}
