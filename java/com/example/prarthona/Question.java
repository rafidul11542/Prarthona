package com.example.prarthona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question extends AppCompatActivity {

    EditText ques;
    DatabaseReference dbref;
    String sques;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        dbref= FirebaseDatabase.getInstance().getReference("question");
        ques = findViewById(R.id.etQues);
    }

    public void add(View view) {
        insertdata();
    }

    private void insertdata() {
        sques=ques.getText().toString();

        if(!TextUtils.isEmpty(sques)){
            String id=dbref.push().getKey();
            QuestionModel qs = new QuestionModel(id,sques);
            dbref.child(id).setValue(qs);
            Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"There are some Error!",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.show_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent gthm=new Intent(Question.this,MainPage.class);
                startActivity(gthm);
                return true;
            case R.id.item2:
                Intent fstm=new Intent(Question.this,DoaZikr.class);
                startActivity(fstm);
                return true;
            case R.id.item3:
                Intent ttm=new Intent(Question.this,TimeTable.class);
                startActivity(ttm);
                return true;
            case R.id.item4:
                Intent rdm=new Intent(Question.this,RamadanDoa.class);
                startActivity(rdm);
                return true;
            case R.id.item5:
                Intent gtm=new Intent(Question.this,AmolDB.class);
                startActivity(gtm);
                return true;
            case R.id.item6:
                Intent qsm=new Intent(Question.this,QandA.class);
                startActivity(qsm);
                return true;
            case R.id.item7:
                FirebaseAuth.getInstance().signOut();//logout
                startActivity(new Intent(getApplicationContext(),login.class));
                finish();
                return true;
            case R.id.item8:
                this.finishAffinity();
                return true;
            case R.id.item9:
                Intent abt=new Intent(Question.this,About.class);
                startActivity(abt);
                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }
}