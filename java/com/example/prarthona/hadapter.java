package com.example.prarthona;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class hadapter extends FirebaseRecyclerAdapter<hmodel,hadapter.myviewholder> {

    public hadapter(@NonNull FirebaseRecyclerOptions<hmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder myviewholder, int i, @NonNull hmodel hmodel) {
        myviewholder.title.setText(hmodel.getTitle());
        myviewholder.description.setText(hmodel.getDescription());
    }

    @NonNull
    @Override
    public hadapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.hadis_layout,parent,false);
        return new myviewholder(view);

    }
    class myviewholder extends RecyclerView.ViewHolder{

        TextView title,description;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.tvHadisTitle);
            description=(TextView)itemView.findViewById(R.id.tvHadisDes);
        }
    }
}
