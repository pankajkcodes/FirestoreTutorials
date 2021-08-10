package com.pankajkcodes.firestoretutorials;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<Model> list;

    public Adapter(Context context, ArrayList<Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  Adapter.ViewHolder holder, int position) {
        Model model = list.get(position);
        holder.name.setText(model.getName());
        holder.age.setText(model.getAge());
        holder.country.setText(model.getCounty());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        TextView name,age,country;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_item);
            age = itemView.findViewById(R.id.age_item);
            country = itemView.findViewById(R.id.country_item);

        }
    }
}
