package com.example.prarthona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainPage extends AppCompatActivity {

    TextView dateView;
    TextView showSpin;
    Spinner spinerEx;
    TextView amol,hadith,stomvo,ques;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        spinerEx = (Spinner) findViewById(R.id.spnAmol);
        showSpin = (TextView) findViewById(R.id.tvSpn);
        amol = findViewById(R.id.txtAmol);
        hadith = findViewById(R.id.txthadis);
        stomvo = findViewById(R.id.txtSthomvo);
        ques = findViewById(R.id.txtQues);

        TextView dateView = (TextView)findViewById(R.id.datumprikaz);
        setDate(dateView);

        spinerEx.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {

                    case 0 : // for item 1
                        showSpin.setText("০৪.৩০ মিঃ");
                        break;

                    case 1 :
                        showSpin.setText("১২.০৫ মিঃ");
                        break;

                    case 2 :
                        showSpin.setText("০৪.৪০ মিঃ");
                        break;

                    case 3 :
                        showSpin.setText("০৬.২০ মিঃ");
                        break;

                    case 4 :
                        showSpin.setText("০৭.৪০ মিঃ");
                        break;

                    /* you can have any number of case statements */
                    default :

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        amol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AmolDB.class));
            }
        });

        hadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Hadis.class));
            }
        });

        stomvo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DoaZikr.class));
            }
        });

       ques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),QandA.class));
            }
        });

    }


    public void setDate (TextView view){

        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//formating according to my need
        String date = formatter.format(today);
        view.setText(date);
    }


    public void btnTimeTable(View view) {
        Intent tt=new Intent(MainPage.this,TimeTable.class);
        startActivity(tt);
    }

    public void btnRmDoa(View view) {
        Intent rd=new Intent(MainPage.this,RamadanDoa.class);
        startActivity(rd);
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
                Toast.makeText(this, "Already in Home!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Intent fstm=new Intent(MainPage.this,DoaZikr.class);
                startActivity(fstm);
                return true;
            case R.id.item3:
                Intent ttm=new Intent(MainPage.this,TimeTable.class);
                startActivity(ttm);
                return true;
            case R.id.item4:
                Intent rdm=new Intent(MainPage.this,RamadanDoa.class);
                startActivity(rdm);
                return true;
            case R.id.item5:
                Intent gtm=new Intent(MainPage.this,AmolDB.class);
                startActivity(gtm);
                return true;
            case R.id.item6:
                Intent qsm=new Intent(MainPage.this,QandA.class);
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
                Intent abt=new Intent(MainPage.this,About.class);
                startActivity(abt);
                return true;

            default:

            return super.onOptionsItemSelected(item);
        }
    }

}

