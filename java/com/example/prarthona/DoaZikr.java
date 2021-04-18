package com.example.prarthona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class DoaZikr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_zikr);
    }

    public void btnKalema(View view) {
        Kalema km=new Kalema();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame1, km);
        ft.addToBackStack(null);
        ft.commit();

    }

    public void btnNamaj(View view) {
        Namaj nm=new Namaj();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame1, nm);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void btnSaom(View view) {
        Saom sm=new Saom();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame1, sm);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void btnHajj(View view) {
        Hajj hz=new Hajj();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame1, hz);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void btnJakat(View view) {
        Jakat jk=new Jakat();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame1, jk);
        ft.addToBackStack(null);
        ft.commit();
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
                Intent gtm=new Intent(DoaZikr.this,MainPage.class);
                startActivity(gtm);
                return true;
            case R.id.item2:
                Toast.makeText(this, "Already Here!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Intent ttm=new Intent(DoaZikr.this,TimeTable.class);
                startActivity(ttm);
                return true;
            case R.id.item4:
                Intent rdm=new Intent(DoaZikr.this,RamadanDoa.class);
                startActivity(rdm);
                return true;
            case R.id.item5:
                Intent am=new Intent(DoaZikr.this,AmolDB.class);
                startActivity(am);
                return true;
            case R.id.item6:
                Intent qsm=new Intent(DoaZikr.this,QandA.class);
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
                Intent abt=new Intent(DoaZikr.this,About.class);
                startActivity(abt);
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }
}