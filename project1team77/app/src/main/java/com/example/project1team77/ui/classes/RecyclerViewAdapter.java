package com.example.project1team77.ui.classes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1team77.R;

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
        String classProf = classesModel.get(position).getProfessor();
        String className = classesModel.get(position).getClasses();
        String classTime = classesModel.get(position).getTime();
        holder.textView1.setText(classProf);
        holder.textView2.setText(className);
        holder.textView3.setText(classTime);

        int index = holder.getAdapterPosition();

        Button delete = holder.delete;
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                classesModel.remove(index);
                notifyDataSetChanged();
            }
        });

        Button edit = holder.edit;
        edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String[] classStuff = {className, classTime, classProf};

                Bundle args = new Bundle();
                args.putBoolean("editing?", true);
                args.putStringArray("classStuff", classStuff);
                args.putInt("index", index);
                Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_classFormView, args);
            }
        });

    }

    @Override
    public int getItemCount() {
        return classesModel.size();
    }

    public void setClassesModel(ArrayList<Classes> classesModel) {
        this.classesModel = classesModel;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView1;
        TextView textView2;
        TextView textView3;

        Button delete;
        Button edit;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.professorView);
            textView2 = itemView.findViewById(R.id.classView);
            textView3 = itemView.findViewById(R.id.timeView);

            delete = itemView.findViewById(R.id.delete);
            edit = itemView.findViewById(R.id.edit);
        }
    }
}
