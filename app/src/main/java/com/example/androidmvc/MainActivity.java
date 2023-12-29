package com.example.androidmvc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidmvc.databinding.ActivityMainBinding;
import com.example.androidmvc.ui.activity.MVCActivity;
import com.example.androidmvc.ui.activity.NormalActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.normal.setOnClickListener(this);
        binding.mvc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == binding.normal) {
            Intent intent = new Intent(this, NormalActivity.class);
            startActivity(intent);
        } else if (v == binding.mvc) {
            Intent intent = new Intent(this, MVCActivity.class);
            startActivity(intent);
        }
    }
}