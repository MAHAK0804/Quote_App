package com.example.quoteapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button share;
    TextView quote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        share=findViewById(R.id.share);
        quote=findViewById(R.id.quote);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shareText = quote.getText().toString();
                Intent SendIntent =new Intent();
                SendIntent.setAction(Intent.ACTION_SEND);
                SendIntent.setType("text/plain");
                SendIntent.putExtra(
                        Intent.EXTRA_TEXT,shareText
                );
                startActivity(SendIntent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}