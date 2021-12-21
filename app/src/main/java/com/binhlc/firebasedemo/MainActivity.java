package com.binhlc.firebasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogout = findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(MainActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, StartActivity.class));
            finish();
        });

//        FirebaseDatabase.getInstance().getReference().child("Binh's Firebase demo").child(
//                "Android").setValue("Today is 21st of December");
        HashMap<String, Object> data = new HashMap<>();
        data.put("Name", "Le Cong Binh");
        data.put("Birthday", "21/01/2001");

        FirebaseDatabase.getInstance().getReference().child("Multiple value").child("Binh's Firebase demo")
                .updateChildren(data);
    }
}