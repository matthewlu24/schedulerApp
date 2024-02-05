package com.example.project1team77.ui.assignment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1team77.R;

import java.util.ArrayList;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {
    Context context;
    ArrayList<Assignment> assignmentList;

    public AssignmentAdapter(Context context, ArrayList<Assignment> assignmentList) {
        this.context = context;
        this.assignmentList = assignmentList;
    }
    @NonNull
    @Override
    public AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.assignment_row, parent, false);
        return new AssignmentAdapter.AssignmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentViewHolder holder, int position) {

        String courseName = assignmentList.get(position).getCourse().toString();
        String name = assignmentList.get(position).getTitle();
        String dueDate = assignmentList.get(position).getDueDate().toString();

        holder.dueDateView.setText(dueDate);
        holder.nameView.setText(name);
        holder.courseView.setText(courseName);

        int index = holder.getAdapterPosition();

        Button delete = holder.delete;
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                assignmentList.remove(index);
                notifyDataSetChanged();
            }
        });

        Button edit = holder.edit;
        edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String[] assignmentStuff = {name, dueDate, courseName};

                Bundle args = new Bundle();
                args.putBoolean("editing?", true);
                args.putStringArray("assignmentStuff", assignmentStuff);
                args.putInt("index", index);
                Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_assignmentForm, args);
            }
        });

    }

    @Override
    public int getItemCount() {
        return assignmentList.size();
    }

    public void setAssignmentList(ArrayList<Assignment> assignmentList) {
        this.assignmentList = assignmentList;
    }

    public static class AssignmentViewHolder extends RecyclerView.ViewHolder {

        TextView dueDateView;
        TextView nameView;
        TextView courseView;
        Button delete;
        Button edit;
        public AssignmentViewHolder(@NonNull View itemView) {
            super(itemView);
            dueDateView = itemView.findViewById(R.id.professorView);
            nameView = itemView.findViewById(R.id.classView);
            courseView = itemView.findViewById(R.id.timeView);

            delete = itemView.findViewById(R.id.delete);
            edit = itemView.findViewById(R.id.edit);
        }
    }
}
