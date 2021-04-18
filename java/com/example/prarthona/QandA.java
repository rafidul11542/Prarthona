package com.example.prarthona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class QandA extends AppCompatActivity {

    RecyclerView recycleView;
    qaadapter adepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qand);

        recycleView = findViewById(R.id.rclView2);
        recycleView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<qamodel> options =
                new FirebaseRecyclerOptions.Builder<qamodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("question"),qamodel.class)
                        .build();
        adepter = new qaadapter(options);
        recycleView.setAdapter(adepter);
    }

    public void question(View view) {
        Intent qs = new Intent(QandA.this,Question.class);
        startActivity(qs);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adepter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adepter.stopListening();
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
                Intent gtm=new Intent(QandA.this,MainPage.class);
                startActivity(gtm);
                return true;
            case R.id.item2:
                Intent fstm=new Intent(QandA.this,DoaZikr.class);
                startActivity(fstm);
                return true;
            case R.id.item3:
                Intent tt=new Intent(QandA.this,TimeTable.class);
                startActivity(tt);
                return true;
            case R.id.item4:
                Intent rd=new Intent(QandA.this,RamadanDoa.class);
                startActivity(rd);
                return true;
            case R.id.item5:
                Intent ttm=new Intent(QandA.this,AmolDB.class);
                startActivity(ttm);
                return true;
            case R.id.item6:
                Toast.makeText(this, "Already Here!", Toast.LENGTH_SHORT).show();
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
                Intent abt=new Intent(QandA.this,About.class);
                startActivity(abt);
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }
}