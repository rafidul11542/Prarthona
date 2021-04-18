package com.example.prarthona;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class qaadapter extends FirebaseRecyclerAdapter<qamodel,qaadapter.myviewholder> {
    public qaadapter(FirebaseRecyclerOptions<qamodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull qaadapter.myviewholder myviewholder, int i, @NonNull qamodel qamodel) {
        myviewholder.question.setText(qamodel.getQuestion());
        myviewholder.answer.setText(qamodel.getAnswer());
    }

    @NonNull
    @Override
    public qaadapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.qans,parent,false);
        return new qaadapter.myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView question,answer;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
           question=(TextView)itemView.findViewById(R.id.tvQes);
            answer=(TextView)itemView.findViewById(R.id.tvAns);
        }
    }
}
