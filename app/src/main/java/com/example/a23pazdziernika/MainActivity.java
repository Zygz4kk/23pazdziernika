package com.example.a23pazdziernika;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button buttonPlus, buttonMinus;
    TextView textView;
    int punkty = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.i("CYKL","Uruchomiona metoda OnCreate");
        buttonPlus = findViewById(R.id.button);
        buttonMinus = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        if(savedInstanceState != null){
            punkty = savedInstanceState.getInt("Punkty",0);
            textView.setText(punkty+"");
        }
        buttonPlus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        punkty ++;
                        textView.setText(punkty+"");
                    }
                }
        );
        buttonMinus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        punkty--;
                        textView.setText(punkty+"");
                    }
                }
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("CYKL", "Uruchomiono metodę onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("CYKL","Uruchomiono metodę onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("CYKL","Uruchomiono metodę onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("CYKL","Uruchomiono metodę onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("CYKL","Uruchomiono metodę onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("CYKL","Uruchomiono metodę onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("CYKL","Uruchomiono metodę onSaveInstanceState");
        outState.putInt("Punkty", punkty);
    }
}