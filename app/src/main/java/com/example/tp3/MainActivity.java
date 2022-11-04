package com.example.tp3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tp3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btExample1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.etMessage.getText().toString().isEmpty()) {
                    binding.etMessage.setError("can't be empty");
                } else {
                    String message = binding.etMessage.getText().toString();
                    Intent intent1 = new Intent(MainActivity.this, ExampleActivity1.class);
                    intent1.putExtra("messageIntent", message);
                    Bundle myBundle = new Bundle();
                    myBundle.putString("messageBundle", message);
                    intent1.putExtras(myBundle);
                    startActivity(intent1);
                }
            }
        });
//        Intent intent = new Intent(MainActivity.this,
//                ReturnResultActivity.class);
//        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this,
                ReturnResultActivity.class);
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            switch (resultCode) {
                case RESULT_OK: {
                    Toast.makeText(this, "Action validée",
                            Toast.LENGTH_LONG).show();
                    // get String data from Intent
                    String returnString = data.getStringExtra("keyName");
                    // set text view with string
                    binding.etMessage.setText(returnString);
                }
                case RESULT_CANCELED: {
                    Toast.makeText(this, "Action annulée",
                            Toast.LENGTH_LONG).show();
                    // get String data from Intent
                    String returnString = data.getStringExtra("keyName");
                    // set text view with string
                    binding.etMessage.setText(returnString);
                }
            }
        }
    }

}
