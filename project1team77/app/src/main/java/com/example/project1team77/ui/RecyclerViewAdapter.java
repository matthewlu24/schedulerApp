package com.example.project1team77.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1team77.R;
import com.example.project1team77.model.Classes;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<Classes> classesModel;

    public RecyclerViewAdapter(Context context, ArrayList<Classes> classesModel) {
        this.context = context;
        this.classesModel = classesModel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.class_schedule_row, parent, false);
        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.textView1.setText(classesModel.get(position).getProfessor());
        holder.textView2.setText(classesModel.get(position).getClasses());
        holder.textView3.setText(classesModel.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return classesModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView1;
        TextView textView2;
        TextView textView3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.professorView);
            textView2 = itemView.findViewById(R.id.classView);
            textView3 = itemView.findViewById(R.id.timeView);
        }
    }
}
