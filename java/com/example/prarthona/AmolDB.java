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
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AmolDB extends AppCompatActivity {


    RecyclerView recycleView;
    myadapter adepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amol_d_b);

        recycleView = findViewById(R.id.rclView);
        recycleView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("recyclerview"),model.class)
                .build();

        adepter = new myadapter(options);
        recycleView.setAdapter(adepter);

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
                Intent gtm=new Intent(AmolDB.this,MainPage.class);
                startActivity(gtm);
                return true;
            case R.id.item2:
                Intent fstm=new Intent(AmolDB.this,DoaZikr.class);
                startActivity(fstm);
                return true;
            case R.id.item3:
                Intent ttm=new Intent(AmolDB.this,TimeTable.class);
                startActivity(ttm);
                return true;
            case R.id.item4:
                Intent rdm=new Intent(AmolDB.this,RamadanDoa.class);
                startActivity(rdm);
                return true;
            case R.id.item5:
                Toast.makeText(this, "Already Here!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item6:
                Intent qsm=new Intent(AmolDB.this,QandA.class);
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
                Intent abt=new Intent(AmolDB.this,About.class);
                startActivity(abt);
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }

}