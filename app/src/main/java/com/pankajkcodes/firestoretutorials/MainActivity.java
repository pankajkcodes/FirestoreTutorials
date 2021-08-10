package com.pankajkcodes.firestoretutorials;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //<------ Find All View ----->//
        EditText mName = findViewById(R.id.name);
        EditText mAge = findViewById(R.id.age);
        EditText mCountry = findViewById(R.id.country);
        Button submit = findViewById(R.id.submit);


        submit.setOnClickListener((v) -> {
            String id = UUID.randomUUID().toString();
            String name = mName.getText().toString();
            String age = mAge.getText().toString();
            String country = mCountry.getText().toString();


            saveToFirestore(id, name, age, country);

        });

        Button showData = findViewById(R.id.show);
        showData.setOnClickListener((v -> {
            startActivity(new Intent(MainActivity.this,ShowActivity.class));
        }));

    }

    private void saveToFirestore(String id, String name, String age, String country) {
        db = FirebaseFirestore.getInstance();

        Map<String, Object> data1 = new HashMap<>();
        data1.put("id",id);
        data1.put("name", name);
        data1.put("age", age);
        data1.put("country", country);
        db.collection("person").document(id).set(data1).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "Submit Successfully", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}