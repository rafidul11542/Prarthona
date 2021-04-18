package com.example.prarthona;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class rdadapter extends FirebaseRecyclerAdapter<rdmodel,rdadapter.myviewholder> {

    public rdadapter(@NonNull FirebaseRecyclerOptions<rdmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull rdadapter.myviewholder myviewholder, int i, @NonNull rdmodel rdmodel) {
        myviewholder.title.setText(rdmodel.getTitle());
        myviewholder.arabic.setText(rdmodel.getArabic());
        myviewholder.bangla.setText(rdmodel.getBangla());
    }

    @NonNull
    @Override
    public rdadapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rdoa_layout,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView title,arabic,bangla;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.tvRDTitle);
            arabic=(TextView)itemView.findViewById(R.id.tvRDArabic);
            bangla=(TextView)itemView.findViewById(R.id.tvRDBangla);
        }
    }
}
