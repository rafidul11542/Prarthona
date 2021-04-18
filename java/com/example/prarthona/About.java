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

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
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
                Intent gtm=new Intent(About.this,MainPage.class);
                startActivity(gtm);
                return true;
            case R.id.item2:
                Intent fstm=new Intent(About.this,DoaZikr.class);
                startActivity(fstm);
                return true;
            case R.id.item3:
                Intent tt=new Intent(About.this,TimeTable.class);
                startActivity(tt);
                return true;
            case R.id.item4:
                Intent rd=new Intent(About.this,RamadanDoa.class);
                startActivity(rd);
                return true;
            case R.id.item5:
                Intent ttm=new Intent(About.this,AmolDB.class);
                startActivity(ttm);
                return true;
            case R.id.item6:
                Intent qa=new Intent(About.this,QandA.class);
                startActivity(qa);
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
                Toast.makeText(this, "Already Here!", Toast.LENGTH_SHORT).show();
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }
}