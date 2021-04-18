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
import com.google.firebase.database.FirebaseDatabase;

public class RamadanDoa extends AppCompatActivity {

    RecyclerView recycleView;
    rdadapter adepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramadan_doa);
        recycleView = findViewById(R.id.rclView3);
        recycleView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<rdmodel> options =
                new FirebaseRecyclerOptions.Builder<rdmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("ramadandoa"),rdmodel.class)
                        .build();

        adepter = new rdadapter(options);
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
                Intent gtm=new Intent(RamadanDoa.this,MainPage.class);
                startActivity(gtm);
                return true;
            case R.id.item2:
                Intent fstm=new Intent(RamadanDoa.this,DoaZikr.class);
                startActivity(fstm);
                return true;
            case R.id.item3:
                Intent tt=new Intent(RamadanDoa.this,TimeTable.class);
                startActivity(tt);
                return true;
            case R.id.item4:
                Toast.makeText(this, "Already Here!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item5:
                Intent ttm=new Intent(RamadanDoa.this,AmolDB.class);
                startActivity(ttm);
                return true;
            case R.id.item6:
                Intent qsm=new Intent(RamadanDoa.this,QandA.class);
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
                Intent abt=new Intent(RamadanDoa.this,About.class);
                startActivity(abt);
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }
}