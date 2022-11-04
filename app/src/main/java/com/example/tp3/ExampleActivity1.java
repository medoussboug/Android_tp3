package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tp3.databinding.ActivityExample1Binding;

public class ExampleActivity1 extends AppCompatActivity {
    private ActivityExample1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExample1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvMessage.setText("From intent: " + getIntent().getStringExtra("messageIntent"));
        binding.tvMessageBundle.setText("From Bundle: " + getIntent().getStringExtra("messageBundle"));
        binding.btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExampleActivity1.this.finish();
            }
        });
    }
}