package com.example.shauryasingh.fitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.*;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    Button b1;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button) findViewById(R.id.button1);
        et1=(EditText) findViewById(R.id.editText1);
        et2=(EditText) findViewById(R.id.editText2);

        mAuth = FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignIn();
            }
        });
    }
    private void startSignIn() {
        final String email = et2.getText().toString();
        final String password = et1.getText().toString();
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(!task.isSuccessful()){
                    updateUI(null);
                }
                else{
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);

                }
            }
        });

    }
    private void updateUI(FirebaseUser user){

        if (user != null) {
            Toast.makeText(getApplicationContext(), "Signing in", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getApplicationContext(), com.example.shauryasingh.fitapp.HomeActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"Wrong Id or Pass",Toast.LENGTH_SHORT).show();
        }
    }


}
