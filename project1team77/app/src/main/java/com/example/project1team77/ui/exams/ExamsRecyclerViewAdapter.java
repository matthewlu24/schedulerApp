package com.example.project1team77.ui.exams;

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

public class ExamsRecyclerViewAdapter extends RecyclerView.Adapter<ExamsRecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<Exams> examsModel;

    public ExamsRecyclerViewAdapter(Context context, ArrayList<Exams> examsModel) {
        this.context = context;
        this.examsModel = examsModel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.class_schedule_row, parent, false);
        return new ExamsRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamsRecyclerViewAdapter.MyViewHolder holder, int position) {
        String examLocation = examsModel.get(position).getExamLocation();
        String examClass = examsModel.get(position).getExamClass();
        String examTimeDate = examsModel.get(position).getExamTime_date();
        holder.textView1.setText(examLocation);
        holder.textView2.setText(examClass);
        holder.textView3.setText(examTimeDate);

        int index = holder.getAdapterPosition();

        Button delete = holder.delete;
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                examsModel.remove(index);
                notifyDataSetChanged();
            }
        });

        Button edit = holder.edit;
        edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String[] classStuff = {examClass, examTimeDate, examLocation};

                Bundle args = new Bundle();
                args.putBoolean("editing?", true);
                args.putStringArray("classStuff", classStuff);
                args.putInt("index", index);
                Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_examsFormView, args);
            }
        });

    }

    @Override
    public int getItemCount() {
        return examsModel.size();
    }

    public void setExamsModel(ArrayList<Exams> examsModel) {
        this.examsModel = examsModel;
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
