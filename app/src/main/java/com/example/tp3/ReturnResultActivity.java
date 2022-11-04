package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tp3.databinding.ActivityReturnResultBinding;

public class ReturnResultActivity extends AppCompatActivity {

    private ActivityReturnResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReturnResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String message = getIntent().getStringExtra("messageIntent");
        binding.tvMessage.setText(message);
        binding.btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.etMessage.getText().toString().isEmpty()) {
                    binding.etMessage.setError("can't be empty");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("keyName", binding.etMessage.getText().toString());
                    setResult(RESULT_OK);
                    finish();
                }
            }
        });
        binding.btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("keyName", "Canceled");
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}