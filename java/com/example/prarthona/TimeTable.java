package com.example.prarthona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class TimeTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
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
                Intent gtm=new Intent(TimeTable.this,MainPage.class);
                startActivity(gtm);
                return true;
            case R.id.item2:
                Intent fstm=new Intent(TimeTable.this,DoaZikr.class);
                startActivity(fstm);
                return true;
            case R.id.item3:
                Toast.makeText(this, "Already Here!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Intent rdm=new Intent(TimeTable.this,RamadanDoa.class);
                startActivity(rdm);
                return true;
            case R.id.item5:
                Intent ttm=new Intent(TimeTable.this,AmolDB.class);
                startActivity(ttm);
                return true;
            case R.id.item6:
                Intent qsm=new Intent(TimeTable.this,QandA.class);
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
                Intent abt=new Intent(TimeTable.this,About.class);
                startActivity(abt);
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }
}