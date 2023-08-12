package com.example.katyyouthhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private Button swapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        swapButton = (Button) findViewById(R.id.swapBtn);
        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSwap();
            }
        });
    }

    public void openSwap() {
        Intent intent = new Intent(this, Donate.class);
        startActivity(intent);
    }
}