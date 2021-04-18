package com.example.prarthona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText suName,suEmail,suPass;
    Button suReg;
    TextView mLoginBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        suName = findViewById(R.id.edtName);
        suEmail = findViewById(R.id.edtEmail);
        suPass = findViewById(R.id.edtPass);
        mLoginBtn   = findViewById(R.id.createText);

        suReg = findViewById(R.id.btnReg);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainPage.class));
            finish();
        }

        suReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = suEmail.getText().toString().trim();
                String password = suPass.getText().toString().trim();


                if(TextUtils.isEmpty(email)){
                    suEmail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    suPass.setError("Password is Required.");
                    return;
                }

                if(password.length() < 6){
                    suPass.setError("Password Must be >= 6 Characters");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUp.this, "Registration Complete.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),login.class));
                        }else{
                            Toast.makeText(SignUp.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });
    }

}