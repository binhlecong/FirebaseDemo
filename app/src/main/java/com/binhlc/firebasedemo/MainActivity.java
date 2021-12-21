package com.binhlc.firebasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button btnLogout;
    private Button btnSubmit;
    private EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogout = findViewById(R.id.btn_logout);
        btnSubmit = findViewById(R.id.btn_submit);
        etInput = findViewById(R.id.et_input);

        btnLogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(MainActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, StartActivity.class));
            finish();
        });

//        FirebaseDatabase.getInstance().getReference().child("Binh's Firebase demo").child(
//                "Android").setValue("Today is 21st of December");
//        HashMap<String, Object> data = new HashMap<>();
//        data.put("Name", "Le Cong Binh");
//        data.put("Birthday", "21/01/2001");
//
//        FirebaseDatabase.getInstance().getReference().child("Multiple value").child("Binh's " +
//                "Firebase demo")
//                .updateChildren(data);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = etInput.getText().toString();
                if (inputText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Empty input", Toast.LENGTH_SHORT);
                } else {
                    FirebaseDatabase.getInstance().getReference()
                            .child("FirebaseDemo").push().child("Name").setValue(inputText);
                }
            }
        });
    }
}